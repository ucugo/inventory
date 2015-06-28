package repositories;


import domain.InventoryUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManagerFactory;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-test-context.xml")
public class InventoryUserRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(InventoryUserRepositoryTest.class.getName());

   @Autowired UserRepository userRepository;
    @Autowired private EntityManagerFactory entityManagerFactory;


    @Test
    public void createUser() {
        InventoryUser inventoryUser = userRepository.save(dummyUser());
        Assert.assertNotNull(inventoryUser);

//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.persist(user);
    }

//    @Test
    public void testGetUserByEmail(){
        InventoryUser inventoryUsers =userRepository.getInventoryUserByEmailAddress(dummyUser().getEmailAddress());
        Assert.assertNotNull(inventoryUsers);
    }

    @Test
    public void testFindAllUsers(){
        Iterable<InventoryUser> users = userRepository.findAll();

//        Assert.assertTrue(users.iterator().hasNext());
    }

//    @Test
    public void testGetUserByFirstName(){
        List<InventoryUser> inventoryUser = userRepository.findByFirstName(dummyUser().getFirstName());
        Assert.assertNotNull(inventoryUser);
    }

    private InventoryUser dummyUser(){
        InventoryUser dummyInventoryUser = new InventoryUser();

        dummyInventoryUser.setFirstName("Barry");
        dummyInventoryUser.setLastName("White");
        dummyInventoryUser.setEmailAddress("ucugo@yahoo.co.uk");
        dummyInventoryUser.setPassword("5f4dcc3b5aa765d61d8327deb882cf99");
        return dummyInventoryUser;
    }
}
