package com.revature.controllers;

import com.revature.daos.UsersDAO;
import com.revature.models.User;
import com.revature.models.UserLoginDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class AuthController {
    private static HttpSession ses;
    private UsersDAO uDAO;
    @Autowired
    public AuthController(UsersDAO uDAO) {
        this.uDAO = uDAO;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody UserLoginDTO u)
    {
        Optional possibleUser =  uDAO.findByUsernameAndPassword(u.getUsername(),u.getPassword());
        if (possibleUser.isPresent()) //found a user.
        {
            User user = (User) possibleUser.get(); //possible error point...
            ses.setAttribute("activeUser",user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().build();
    }

    public static boolean authorized()
    {
        return ses.getAttribute("activeUser")!=null;
    }

}
