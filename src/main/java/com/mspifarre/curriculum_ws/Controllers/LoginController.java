package com.mspifarre.curriculum_ws.Controllers;

import com.mspifarre.curriculum_ws.Entities.User;
import com.mspifarre.curriculum_ws.Raw.UserLogin;
import com.mspifarre.curriculum_ws.Security.JWTProvider;
import com.mspifarre.curriculum_ws.Security.SecurityConstants;
import com.mspifarre.curriculum_ws.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/login")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin){
        try {
            User stored = userService.getUser(userLogin.username);
            if(bCryptPasswordEncoder.matches(userLogin.password, stored.getPassword())){
                JWTProvider jwtProvider = JWTProvider.getInstance();
                String jwt = jwtProvider.generateToken(stored.getUsername());
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.set(HttpHeaders.AUTHORIZATION,
                        SecurityConstants.TOKEN_PREFIX + " " + jwt);
                ResponseEntity response = ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,SecurityConstants.TOKEN_PREFIX + " " + jwt).body("");
                return response;
            }
            else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
