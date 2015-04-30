package repositories;

import domain.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Ugo on 30/04/2015.
 */
public interface SignUpRepository extends JpaRepository<SignUp,Serializable> {
}
