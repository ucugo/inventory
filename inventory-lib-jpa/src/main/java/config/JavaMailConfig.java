package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templatemode.ITemplateModeHandler;
import org.thymeleaf.templatemode.TemplateModeHandler;
import org.thymeleaf.templateparser.html.AbstractHtmlTemplateParser;
import org.thymeleaf.templateparser.html.LegacyHtml5TemplateParser;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import thymeleaf.AbstractEmailContextImpl;

import java.util.HashSet;
import java.util.Set;

import static constants.LibConstants.*;

/**
 * Created by Ugo on 25/05/2015.
 */
@Configuration
public class JavaMailConfig {


    public JavaMailSenderImpl javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(JAVA_MAIL_HOST);
        mailSender.setPort(JAVA_MAIL_PORT);
        mailSender.setProtocol(JAVA_MAIL_PROTOCOL);
        mailSender.setPassword(JAVA_MAIL_PASSWORD);
        mailSender.setUsername(JAVA_MAIL_USERNAME);

        return mailSender;
    }


    public SpringTemplateEngine springTemplateEngine(){
        SpringTemplateEngine templateEngine =  new SpringTemplateEngine();
        templateEngine.setTemplateResolver(classLoaderTemplateResolver());
        return templateEngine;
    }

    private ClassLoaderTemplateResolver classLoaderTemplateResolver(){
        ClassLoaderTemplateResolver templateResolver =  new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("mail");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setOrder(2);
        return templateResolver;
    }

    @Bean(name = "abstractEmailContextImpl")
    public AbstractEmailContextImpl abstractEmailContext(){
        return new AbstractEmailContextImpl(springTemplateEngine(),javaMailSender());
    }

}
