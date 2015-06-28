package notification;

/**
 * Created by Ugo on 26/05/2015.
 */

public enum NotificationResource {

    REGISTRATION_NOTIFICATION("registration.html");

    final private String resourceName;
     NotificationResource(String resourceName){
        this.resourceName = resourceName;
    }

    public String getResourceName(){
        return this.resourceName;
    }
}
