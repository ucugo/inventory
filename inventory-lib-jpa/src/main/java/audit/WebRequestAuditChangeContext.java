package audit;

import org.springframework.web.context.request.ServletWebRequest;
import web.CurrentRequestInterceptor;

/**
 * Created by Ugo on 26/04/2015.
 */
public class WebRequestAuditChangeContext implements AuditChangeContext {

    @Override
    public AuditedChange createAuditedChange() {
        AuditedChange change = new AuditedChange();
        ServletWebRequest request = (ServletWebRequest) CurrentRequestInterceptor.getCurrent();
        if(request == null){
            return null;
        }
        String user = request.getRemoteUser();
        if (user == null)
            user = "unknown";
        change.setAdminUser(user);
        String remoteAddr = request.getRemoteUser();
        if (remoteAddr == null)
            remoteAddr = "unknown";
        change.setRemoteAddress(remoteAddr);
        return change;
    }

}
