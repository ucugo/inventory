package com.ugo.uchegbu.repository;
import com.mongodb.WriteResult;
import com.ugo.uchegbu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by Ugo on 11/04/2015.
 */

@Component("userRepository")
public class UserRepository extends BaseRepository<User> {

    @Autowired private MongoOperations mongoOperations;


    @Override
    public User save(User t) {

        mongoOperations.save(t);
        return mongoOperations.findOne(new Query(where("firstName").is(t.getFirstName())),User.class);
    }

    @Override
    public List<User> findAll() {

        return mongoOperations.findAll(User.class);
    }

    @Override
    public User update(User user) {
        WriteResult writeResult = mongoOperations.updateFirst(new Query(where("id").is(user.getUserId())), Update.update("firstName", user.getFirstName()), User.class);
        return null;
    }
}
