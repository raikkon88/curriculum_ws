package com.mspifarre.curriculum_ws.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mspifarre.curriculum_ws.CurriculumWsApplication;
import com.mspifarre.curriculum_ws.Entities.Profile;
import com.mspifarre.curriculum_ws.Entities.User;
import com.mspifarre.curriculum_ws.Utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class InitService {

    @Autowired
    private UserService userService;


    @PostConstruct
    public void initialize() {
        User user = new User();
        try {

            Profile profile = new Profile();
            profile.setName("Marc Sànchez Pifarré");

            user.setUsername(CurriculumWsApplication.initParams.getAdmin());
            // We generate a random password of 32 bytes
            user.setPassword(PasswordGenerator.generatePassword(32));
            profile.setUser(user);
            user.setProfile(profile);

            user = userService.addUser(user);

            System.out.println(new ObjectMapper().writeValueAsString(user));


            // TODO: Send the email!!!!
            // At this moment the password that is generated will be sended by email.

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
