package thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Ugo on 25/05/2015.
 */
public class AbstractEmailContextImpl extends AbstractEmailContext {



    public AbstractEmailContextImpl(TemplateEngine templateEngine, JavaMailSenderImpl mailSender) {
        super(templateEngine, mailSender);
    }

    @Override
    public String htmlResource() {
        return null;
    }

    public void sendRegistrationMessage(String name, String recipientEmail, String subject,HashMap < String, Object > contextVariables) throws MessagingException {

        super.setContextVariables(contextVariables);
        MimeMessage mimeMessage = super.createMimeMessage(subject, recipientEmail);
        super.getMailSender().send(mimeMessage);
    }


}
