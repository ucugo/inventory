package controllers;

import domain.InventoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import security.UserDetailsServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ugo on 01/05/2015.
 */

@Controller
public class RootController extends ControllerBase {
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @RequestMapping(value={"/*"})
    public Object showHomePage(WebRequest request,HttpServletResponse response)throws IOException {
        InventoryUser user = getInventoryUser(request);
        if(user.isAdmin()){
            response.sendRedirect(request.getContextPath() + "/home");
            return null;
        }

        return "welcome";
    }
}