package domain;

import util.AccountStatus;
import util.MembershipType;

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
    private MembershipType membershipType;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date validityFrom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date validityTo;

    private String telephoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String townName;
    private String zipCode;
    private String countryName;

    @OneToMany(mappedBy = "organization")
    private List<InventoryUser> inventoryUsers = new ArrayList<InventoryUser>();

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

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
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

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<InventoryUser> getInventoryUsers() {
        return inventoryUsers;
    }

    public void setInventoryUsers(List<InventoryUser> inventoryUsers) {
        this.inventoryUsers = inventoryUsers;
    }
}
