package com.mspifarre.curriculum_ws.Controllers;

import com.mspifarre.curriculum_ws.Entities.User;
import com.mspifarre.curriculum_ws.Raw.ChangePasswordRaw;
import com.mspifarre.curriculum_ws.Services.UserService;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Url privada que serveix per canviar el password de l'usuari (es requereix token d'autenticació.)
     */
    @PutMapping
    public ResponseEntity<?> changePassword(UsernamePasswordAuthenticationToken userToken, @RequestBody ChangePasswordRaw password){
        try{
            return userService.changePassword((User)userToken.getPrincipal(), password);
        }
        catch(Exception ex){
            // En cas que peti el casting de l'usertoken... (no hauria de petar mai)...
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getUser(UsernamePasswordAuthenticationToken token){
        User user = userService.getUser((String)token.getPrincipal());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
