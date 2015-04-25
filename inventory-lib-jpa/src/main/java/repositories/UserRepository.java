package repositories;

import domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ugo on 18/04/2015.
 */

public interface UserRepository extends CrudRepository<User,Long>{

    @Override
     User save(User user);

}
