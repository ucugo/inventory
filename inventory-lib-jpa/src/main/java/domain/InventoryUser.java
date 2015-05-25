package domain;

import util.UserRole;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Ugo on 18/04/2015.
 */

@Entity
@Table(name="inventory_users")
public class InventoryUser extends AbstractModel {

    private static final long serialVersionUID = 1L;
    public static final String RequestScopeAttributeName="inventoryuser";
    public static final String ADMIN_ROLE="ADMIN";
    public static final String MANAGER_ROLE="MANAGER";
    public static final String SALES_ROLE="SALES";

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String userUUId;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String telephoneNumber;
    private String mobilePhoneNumber;

    @ManyToOne
    private Organization organization;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastActivityAt = new Date();

    @OneToMany(mappedBy = "inventoryUser")
    private List<InventoryUserLoginHistory> inventoryUserLoginHistories;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserUUId() {
        return userUUId;
    }

    public void setUserUUId(String userUUId) {
        this.userUUId = userUUId;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public boolean isAdmin(){
       return UserRole.ADMIN.equals(this.userRole);
    }


    public List<InventoryUserLoginHistory> getInventoryUserLoginHistories() {
        return inventoryUserLoginHistories;
    }

    public void setInventoryUserLoginHistories(List<InventoryUserLoginHistory> inventoryUserLoginHistories) {
        this.inventoryUserLoginHistories = inventoryUserLoginHistories;
    }

    public Date getLastActivityAt() {
        return lastActivityAt;
    }

    public void setLastActivityAt(Date lastActivityAt) {
        this.lastActivityAt = lastActivityAt;
    }
}
