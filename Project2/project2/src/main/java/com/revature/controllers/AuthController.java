package com.revature.controllers;

import com.revature.daos.UsersDAO;
import com.revature.models.User;
import com.revature.models.UserLoginDTO;
import com.revature.utils.RequestSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    private UsersDAO uDAO;
    private static RequestSession requestSession;

    @Autowired
    public AuthController(UsersDAO uDAO, RequestSession requestSession) {
        this.uDAO = uDAO;
        this.requestSession = requestSession;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginDTO u) {
        Optional<User> possibleUser = uDAO.findByUsernameAndPassword(u.getUsername(), u.getPassword());
        if (possibleUser.isPresent()) {
            User user = possibleUser.get();
            requestSession.setAttribute("activeUser", user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/logout")
    public ResponseEntity logout() {
        requestSession.setAttribute("activeUser",null);
        return ResponseEntity.ok("The user has logged out");
    }

    public static boolean authorized() {
        return requestSession.getAttribute("activeUser") != null;
    }

}
