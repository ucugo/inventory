package domain;

import util.AccountStatus;
import util.AccountType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ugo on 26/04/2015.
 */
@Entity
@Table(name="organizations")
public class Organization extends AbstractModel{

    private static final long serialVersionUID = 1L;

    private String organizationName;
    private String organizationUUId;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date validityFrom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date validityTo;

    private String telephoneNumber;

    @OneToMany(mappedBy = "organization")
    private List<InventoryUser> inventoryUsers = new ArrayList<InventoryUser>();

    @OneToMany(mappedBy = "organization")
    private List<Address> addresses = new ArrayList<Address>();

    @OneToMany(mappedBy = "organization")
    private List<Item> items = new ArrayList<Item>();


    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationUUId() {
        return organizationUUId;
    }

    public void setOrganizationUUId(String organizationUUId) {
        this.organizationUUId = organizationUUId;
    }



    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getValidityFrom() {
        return validityFrom;
    }

    public void setValidityFrom(Date validityFrom) {
        this.validityFrom = validityFrom;
    }

    public Date getValidityTo() {
        return validityTo;
    }

    public void setValidityTo(Date validityTo) {
        this.validityTo = validityTo;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public List<InventoryUser> getInventoryUsers() {
        return inventoryUsers;
    }

    public void setInventoryUsers(List<InventoryUser> inventoryUsers) {
        this.inventoryUsers = inventoryUsers;
    }


    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
