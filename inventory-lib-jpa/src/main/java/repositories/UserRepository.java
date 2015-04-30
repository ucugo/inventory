package repositories;

import domain.Organization;
import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ugo on 18/04/2015.
 */

public interface UserRepository extends CrudRepository<User,Long> {

    public List<User> findByEmailAddress(@Param("email")String email);
    public List<User> findByFirstName(@Param("firstName")String firstName);
    public List<User> findByEmailAddressAndPassword(@Param("emailAddress")String EmailAddress, @Param("password")String password);
    public List<User> findByOrganization(Organization organization);
    public List<User> findByEmailAddressLikeAndPasswordLike(@Param("emailAddress")String emailAddress,@Param("password")String password);


}
