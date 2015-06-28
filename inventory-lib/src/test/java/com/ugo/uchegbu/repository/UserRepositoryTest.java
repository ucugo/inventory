package com.ugo.uchegbu.repository;

import com.ugo.uchegbu.JpaConfig;
import com.ugo.uchegbu.model.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Ugo on 11/04/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class})
public class UserRepositoryTest{


    private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);
    @Autowired UserRepository userRepository;

   @Ignore
    public void testEnterUser(){

       User user =new User();
       user.setFirstName("Ugo");
       user.setLastName("Uchegbu");
       user.setUserId(3l);
       User savedUser = userRepository.save(user);

       assertNotNull(savedUser);
      assertEquals(savedUser.getFirstName(), user.getFirstName());
       assertEquals(savedUser.getLastName(),user.getLastName());

       log.info("User {}",savedUser);


   }

    @Ignore
    public void testFindAllUsers(){
        List<User> users = userRepository.findAll();

        log.info("Users:{}", users);
    }

    @Ignore
    public void testUpdateUserName(){
//        User user = userRepository.updateUser(new User());

//        log.info("User {}", user);
    }


}

