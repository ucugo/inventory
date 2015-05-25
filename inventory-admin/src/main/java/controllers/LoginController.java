package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.UserRole;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ugo on 01/05/2015.
 */
@Controller

public class LoginController extends ControllerBase {

    @RequestMapping(value = {"/login"})
    public Object showLoginPage(HttpServletRequest request){
        if(request.isUserInRole(UserRole.ADMIN.name())){
            return redirect("/");
        }
        return "login";
    }

    @RequestMapping(value = {"/welcome"})
    public Object welcomePage(){
        return "welcome";
    }


}
