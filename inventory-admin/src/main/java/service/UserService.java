package service;

import domain.SignUp;
import domain.User;
import exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import repositories.SignUpRepository;
import repositories.UserRepository;
import util.PasswordGenerator;

import java.util.List;

/**
 * Created by Ugo on 30/04/2015.
 */


@Component
public class UserService extends AbstractService{

    @Autowired protected UserRepository userRepository;
    @Autowired protected SignUpRepository signUpRepository;

    public User authenticateUser(String password, String emailAddress){
        String encodePassword = PasswordGenerator.encodePassword(password);
        List<User> users = userRepository.findByEmailAddressAndPassword(emailAddress, encodePassword);
        if(users.size() != 0) {
            return users.get(0);
        }
        throw new IllegalAccessError("User name or password is wrong");
    }

    public SignUp signUp(String emailAddress)throws Exception{
        List<User> user = userRepository.findByEmailAddress(emailAddress);
        if(user.size() == 0){
            SignUp signUp = new SignUp();
            signUp.setEmailAddress(emailAddress);
            signUpRepository.save(signUp);
            return signUp;
        }
        throw new UserAlreadyExistsException();
    }

    @Transactional
    public User registerUser(User user){
        User user1 = userRepository.save(user);
        return user1;
    }




}
