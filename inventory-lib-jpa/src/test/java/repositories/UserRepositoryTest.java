package repositories;


import domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-test-context.xml")
public class UserRepositoryTest  {

    private Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class.getName());

   @Autowired UserRepository userRepository;
    @Autowired private EntityManagerFactory entityManagerFactory;


    @Test
    public void createUser() {
        User user = new User();
                userRepository.save(user);

        EntityManager em = entityManagerFactory.createEntityManager();
        em.persist(user);
        logger.info("Id value: {}",user.getId());
    }
}
