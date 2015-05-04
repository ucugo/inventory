package domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ugo on 30/04/2015.
 */
@Entity
@Table(name="sign_ups")
public class SignUp extends AbstractModel {
    private String emailAddress;
    
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }



}
