package com.mspifarre.curriculum_ws.Repositories;

import com.mspifarre.curriculum_ws.Entities.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
