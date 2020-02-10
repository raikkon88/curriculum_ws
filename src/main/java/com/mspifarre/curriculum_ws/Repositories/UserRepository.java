package com.mspifarre.curriculum_ws.Repositories;

import com.mspifarre.curriculum_ws.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
