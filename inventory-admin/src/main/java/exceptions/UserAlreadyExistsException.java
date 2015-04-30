package exceptions;

/**
 * Created by Ugo on 30/04/2015.
 */
public class UserAlreadyExistsException extends Exception {

    public String getMessage(){
        return "User already exists";
    }
}
