package repositories;


import domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-test-context.xml")
public class UserRepositoryTest  {

    private Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class.getName());

   @Autowired UserRepository userRepository;
    @Autowired private EntityManagerFactory entityManagerFactory;


    @Test
    public void createUser() {
        User user = userRepository.save(dummyUser());
        Assert.assertNotNull(user);

//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.persist(user);
    }

    @Test
    public void testGetUserByEmail(){
        List<User> users =userRepository.findByEmailAddress(dummyUser().getEmailAddress());
        Assert.assertNotNull(users);
    }

    @Test
    public void testFindAllUsers(){
        Iterable<User> users = userRepository.findAll();

        Assert.assertTrue(users.iterator().hasNext());
    }

    @Test
    public void testGetUserByFirstName(){
        List<User> user = userRepository.findByFirstName(dummyUser().getFirstName());
        Assert.assertNotNull(user);
    }

    @Test
    public void testUserAuthentication(){
        List<User> user = userRepository.findByEmailAddressAndPassword("ucugo@yahoo.co.uk", "5f4dcc3b5aa765d61d8327deb882cf99");

        assertTrue(user.size() > 0);
        assertEquals(user.get(0).getEmailAddress(),"ucugo@yahoo.co.uk");
        assertEquals(user.get(0).getPassword(), "5f4dcc3b5aa765d61d8327deb882cf99");

    }

    private User dummyUser(){
        User dummyUser = new User();

        dummyUser.setFirstName("Barry");
        dummyUser.setLastName("White");
        dummyUser.setEmailAddress("ucugo@yahoo.co.uk");
        dummyUser.setPassword("password");
        return dummyUser;
    }
}
