package repositories;

import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ugo on 18/04/2015.
 */

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    public List<User> findByEmailAddress(@Param("email")String email);

    public List<User> findByFirstName(@Param("firstName")String firstName);

}
