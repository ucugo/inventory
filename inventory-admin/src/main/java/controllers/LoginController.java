package controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ugo on 01/05/2015.
 */
@Controller
@RequestMapping(value = {"/","hello"})
public class LoginController extends ControllerBase {

    @RequestMapping(value = "/", produces = {"application/json"},method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> getValue(){
        String response = "{\n" +
                "    \"type\": \"Barry\"\n" +
                "}";
        ResponseEntity<String> entity = new ResponseEntity<String>(response,HttpStatus.OK);
        return entity;
    }
}
