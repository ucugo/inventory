package thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;

/**
 * Created by Ugo on 25/05/2015.
 */
public abstract class AbstractEmailContext {

    private JavaMailSenderImpl mailSender;

    final Context context;
    private TemplateEngine templateEngine;

    public AbstractEmailContext(TemplateEngine templateEngine,JavaMailSenderImpl mailSender){
        this.context = new Context();
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    public MimeMessage createMimeMessage(String subject, String receipientEmail) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true,"UTF-8");
        message.setFrom("");
        message.setSubject(subject);
        message.setTo(receipientEmail);

        final String htmlContent = this.templateEngine.process(htmlResource(), context);
        message.setText(htmlContent, true); // true = isHtml
        return mimeMessage;
    }

    public void setContextVariables(HashMap<String, Object> contextVariables){
        for(HashMap.Entry<String,Object> entry : contextVariables.entrySet()){
            this.context.setVariable(entry.getKey(),entry.getValue());
        }
    }

    public abstract String htmlResource();

    public Context getContext(){
        return this.context;
    }

    protected JavaMailSenderImpl getMailSender(){
        return mailSender;
    }
}
