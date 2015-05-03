package repositories;

import domain.Organization;
import domain.InventoryUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ugo on 18/04/2015.
 */

public interface UserRepository extends CrudRepository<InventoryUser,Long> {

    public List<InventoryUser> findByEmailAddress(@Param("email")String email);
    public List<InventoryUser> findByFirstName(@Param("firstName")String firstName);
    public List<InventoryUser> findByEmailAddressAndPassword(@Param("emailAddress")String EmailAddress, @Param("password")String password);
    public List<InventoryUser> findByOrganization(Organization organization);
    public List<InventoryUser> findByEmailAddressLikeAndPasswordLike(@Param("emailAddress")String emailAddress,@Param("password")String password);


}
