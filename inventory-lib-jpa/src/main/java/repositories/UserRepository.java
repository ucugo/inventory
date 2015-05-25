package repositories;

import domain.Organization;
import domain.InventoryUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Ugo on 18/04/2015.
 */

public interface UserRepository extends CrudRepository<InventoryUser,Serializable> {

    public List<InventoryUser> findByEmailAddress(@Param("email")String email);
    public List<InventoryUser> findByFirstName(@Param("firstName")String firstName);
    public List<InventoryUser> findByEmailAddressAndPassword(@Param("emailAddress")String EmailAddress, @Param("password")String password);
    public List<InventoryUser> findByOrganization(Organization organization);
    public List<InventoryUser> findByEmailAddressLikeAndPasswordLike(@Param("emailAddress")String emailAddress,@Param("password")String password);
    @Query("UPDATE InventoryUser i SET i.lastActivityAt = :now WHERE i.id = :userId")
    public void updateLastActivityTime(@Param("userId")long userId, @Param("now")Date now);
    @Query("SELECT i  FROM InventoryUser i WHERE i.id = :userId")
    public InventoryUser getInventoryUserById(@Param("userId")Integer userId);
    @Query("SELECT i  FROM InventoryUser i WHERE i.emailAddress = :emailAddress")
    public InventoryUser getInventoryUserByEmailAddress(@Param("emailAddress")String emailAddress);


}
