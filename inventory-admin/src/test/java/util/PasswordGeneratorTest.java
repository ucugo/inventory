package util;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by Ugo on 30/04/2015.
 */
public class PasswordGeneratorTest {

    private static final Logger log = LoggerFactory.getLogger(PasswordGeneratorTest.class);
    private PasswordGenerator passwordGenerator;

    @Before
    public void init(){
        passwordGenerator = new PasswordGenerator();
    }

    @Test
    public void testEncryptPassword()throws Exception{
        String password = "password";

        String encodedPassword = passwordGenerator.encodePassword(password);
        log.info("First Encoded Value {}", encodedPassword);

        String encodedPassword2 = passwordGenerator.encodePassword(password);
        log.info("Second Encoded Value {}", encodedPassword);
        assertEquals(encodedPassword,encodedPassword2);

    }

}