package domain;

/**
 * Created by Ugo on 04/05/2015.
 */

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "inventory_user_login_history")
public class InventoryUserLoginHistory extends AbstractModel{
    /**
     *
     */
    private static final long serialVersionUID = -4548167170004814487L;

    @ManyToOne
    private InventoryUser inventoryUser;

    private Date loginAt;
    private String ip;
    private String xForwardedFor;
    private String userAgent;

    public InventoryUser getInventoryUser() {
        return inventoryUser;
    }
    public void setInventoryUser(InventoryUser meridianUser) {
        this.inventoryUser = meridianUser;
    }
    public Date getLoginAt() {
        return loginAt;
    }
    public void setLoginAt(Date loginAt) {
        this.loginAt = loginAt;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getxForwardedFor() {
        return xForwardedFor;
    }
    public void setxForwardedFor(String xForwardedFor) {
        this.xForwardedFor = xForwardedFor;
    }
    public String getUserAgent() {
        return userAgent;
    }
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
