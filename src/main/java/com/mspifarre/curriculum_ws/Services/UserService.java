package com.mspifarre.curriculum_ws.Services;

import com.mspifarre.curriculum_ws.Entities.User;
import com.mspifarre.curriculum_ws.Raw.ChangePasswordRaw;
import com.mspifarre.curriculum_ws.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional
    public User addUser(User user) throws Exception {
        try {
            User existentUser = userRepository.findByUsername(user.getUsername()).get();
            // The password will be stored codified.
            return null;
        }
        catch(Exception ex) {
            System.out.println(user.getPassword());
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            return userRepository.save(user);
        }
    }

    @Transactional
    public ResponseEntity<?> changePassword(User user, ChangePasswordRaw password) throws Exception {
        if(bCryptPasswordEncoder.matches(password.oldPassword,user.getPassword())){
            // Verificat que l'usuari sap la contrasenya anterior i per tant el deixem canviar per la nova.
            return _changePassword(user, password.newPassword);
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    private ResponseEntity<?> _changePassword(User user, String newPassword){
        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    public User getUser(String username){
        return userRepository.findByUsername(username).get();
    }

    @Transactional
    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

}
