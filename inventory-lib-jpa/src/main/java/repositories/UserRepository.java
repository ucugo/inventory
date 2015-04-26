package repositories;

import domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Ugo on 18/04/2015.
 */

public interface UserRepository extends CrudRepository<User,Long>{

    @Override
    public User save(User user);

    @Override
    public User findOne(Long userId);

    @Query("FROM user u where u.emailAddress=:email")
    public User getUserByEailAddress(@Param("email")String email);

}
