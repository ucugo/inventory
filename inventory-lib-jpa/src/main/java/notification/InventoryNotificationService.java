package notification;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;

/**
 * Created by Ugo on 26/05/2015.
 */
public class InventoryNotificationService {

    public InventoryNotificationService(TemplateEngine templateEngine,JavaMailSenderImpl mailSender){

    }

    public void sendNotification(NotificationResource notificationResource, String userName, String recipientEmail){

    }
}
