package security;

import domain.InventoryUser;
import domain.InventoryUserLoginHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;
import repositories.InventoryUserLoginHistoryRepository;
import repositories.UserRepository;
import util.AccountStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by Ugo on 03/05/2015.
 */
public class UserLookupInterceptor implements WebRequestInterceptor {

    private static final Logger accessLogger = LoggerFactory.getLogger("AccessLogger");
    private static final Logger logger = LoggerFactory.getLogger(UserLookupInterceptor.class);
    
    @Autowired private UserRepository users;
    @Autowired private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired private PlatformTransactionManager transactionManager;

    @Autowired private InventoryUserLoginHistoryRepository inventoryUserLoginHistoryRepository;

    @Override
    public void preHandle(final WebRequest request) throws Exception {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            public void doInTransactionWithoutResult(TransactionStatus arg0) {
                String username = request.getRemoteUser();

                try {
                    InventoryUser user = loadInventoryUser(request, username);
                    request.setAttribute(InventoryUser.RequestScopeAttributeName, user, WebRequest.SCOPE_REQUEST);
                } catch (IOException e) {
                    throw new RuntimeException("Your Account has been suspended");
                }

            }
        });
    }

    private InventoryUser loadInventoryUser(WebRequest request, String username) throws IOException{
        InventoryUser user = null;
        if (username != null) {
            user = this.users.findByEmailAddress(username).get(0);
            if(user == null){
                return new InventoryUser();
            }
            this.users.updateLastActivityTime(user.getId(), new Date());
//            this.users.getEntityManager().detach(user);
            if(user.getAccountStatus() != AccountStatus.APPROVED){
                throw new IOException("Your Account is not approved");
            }
                InventoryUser userSession = (InventoryUser) request.getAttribute(InventoryUser.RequestScopeAttributeName, WebRequest.SCOPE_SESSION);
                if(userSession != null && !userSession.isNew()){
                    logger.info("User is already logged in");
                    return user;
                }
                logger.info("User is not logged in");
                request.setAttribute(InventoryUser.RequestScopeAttributeName, user, WebRequest.SCOPE_SESSION);

                HttpServletRequest httpServletRequest = ((DispatcherServletWebRequest)request).getRequest();
                InventoryUserLoginHistory loginHistory = new InventoryUserLoginHistory();
                loginHistory.setInventoryUser(user);
                loginHistory.setLoginAt(new Date());
                loginHistory.setIp(httpServletRequest.getRemoteAddr());
                loginHistory.setxForwardedFor(httpServletRequest.getHeader("x-forwarded-for"));
                loginHistory.setUserAgent(httpServletRequest.getHeader("User-Agent"));
                this.inventoryUserLoginHistoryRepository.save(loginHistory);

                Iterator<String> headerNames = request.getHeaderNames();
                while(headerNames.hasNext()){
                    String headerName = headerNames.next();
                    logger.info("Header:[{}]\t\tValues:[{}]",headerName,request.getHeaderValues(headerName));
                }

        }
        if(user == null){
            user = new InventoryUser();
        }
        return user;
    }

    @Override
    public void postHandle(final WebRequest request, ModelMap model) throws Exception {
        if(request == null || model == null){
            return;
        }
        final InventoryUser user = (InventoryUser) request.getAttribute(InventoryUser.RequestScopeAttributeName, WebRequest.SCOPE_REQUEST);
        if(user != null && !user.isNew()){
            //users.updateLastActivityTime(user.getId());
        }

        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                printAccessLoggerProcess(user, ((ServletWebRequest) request).getRequest(), ((ServletWebRequest) request).getResponse());
            }
        });

        model.addAttribute(InventoryUser.RequestScopeAttributeName, user);
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }

    public void printAccessLoggerProcess(InventoryUser InventoryUser, HttpServletRequest request, HttpServletResponse response){
        String remoteAddress = request.getRemoteAddr();
        String xff = request.getHeader("x-forwarded-for");
        String xfip = request.getHeader("x-forwarded-ip");
        String useragent = request.getHeader("User-Agent");
        String url = request.getRequestURI();
        String cookieName = "0b6b3ca04b80486f8482fd7aa0b862fe";
        String cookieValue = UUID.randomUUID().toString();
        boolean cookieExists=false;
        Cookie cookies [] = request.getCookies();

        if(cookies != null && cookies.length > 0){
            for(Cookie cookie : cookies){
                if(cookieName.equalsIgnoreCase(cookie.getName())){
                    cookieExists=true;
                    cookieValue=cookie.getValue();
                    break;
                }
            }
        }

        if(!cookieExists){
            Cookie cookie = new Cookie (cookieName,cookieValue);
            cookie.setMaxAge(365 * 24 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        accessLogger.info("UserId:[{}] Username:[{}] RemoteAddress:[{}] XForwardedFor:[{}] XForwardedIP:[{}] UserAgent:[{}] IsCookieNew:[{}] Cookie:[{}] URL:[{}]",new Object[]{
                InventoryUser==null?"NULL":(InventoryUser.isNew()?"-":InventoryUser.getId()),
                InventoryUser==null?"NULL":(InventoryUser.isNew()?"Anonymous":InventoryUser.getEmailAddress()),
                remoteAddress,
                xff,
                xfip,
                useragent,
                !cookieExists,
                cookieValue,
                url
        });
    }
}
