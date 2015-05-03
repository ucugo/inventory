package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ugo on 01/05/2015.
 */
@Controller
@RequestMapping(value = {"/","hello"})
public class LoginController extends ControllerBase {

    @RequestMapping(value = "/")
    public String getValue(){
        return "Success";
    }
}
