package service;

import domain.InventoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

/**
 * Created by Ugo on 10/05/2015.
 */
@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    public InventoryUser getInventoryUser(Long userId){
        return userRepository.findOne(userId);
    }

    public InventoryUser saveInventoryUser(InventoryUser user){
        return userRepository.save(user);
    }

    public InventoryUser getInventoryUserByEmailAddress(String emaailAddress){
        return userRepository.getInventoryUserByEmailAddress(emaailAddress);
    }
}
