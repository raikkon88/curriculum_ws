package com.mspifarre.curriculum_ws.Services;

import com.mspifarre.curriculum_ws.Entities.User;
import com.mspifarre.curriculum_ws.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User addUser(User user) throws Exception {
        User existentUser = userRepository.findByUsername(user.getUsername());
        if(existentUser != null)
            throw new Exception("User already exists");

        return userRepository.save(user);

    }

}
