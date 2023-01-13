package com.revature.controllers;

import com.revature.daos.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {
    private UsersDAO usersDAO;

    @Autowired
    public  UsersController(UsersDAO usersDAO) {this.usersDAO = usersDAO;}


    @PutMapping("/{id}/firstname")
    public ResponseEntity<String> updateFirstName(@PathVariable int id, @RequestParam String firstName) {
        if(usersDAO.updateUserFirstName(id, firstName)&&AuthController.authorized())
            return ResponseEntity.ok().body("First name updated successfully");
        else
            return ResponseEntity.badRequest().body("Failed to update first name");
    }

    @PutMapping("/{id}/lastname")
    public ResponseEntity<String> updateLastName(@PathVariable int id, @RequestParam String lastName) {
        if(usersDAO.updateUserLastName(id, lastName)&&AuthController.authorized())
            return ResponseEntity.ok().body("Last name updated successfully");
        else
            return ResponseEntity.badRequest().body("Failed to update last name");
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<String> updatePassword(@PathVariable int id, @RequestParam String password) {
        if(usersDAO.updateUserPassword(id, password)&&AuthController.authorized())
            return ResponseEntity.ok().body("Password updated successfully");
        else
            return ResponseEntity.badRequest().body("Failed to update password");
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<String> updateAddress(@PathVariable int id, @RequestParam String address) {
        if(usersDAO.updateUserAddress(id, address)&&AuthController.authorized())
            return ResponseEntity.ok().body("Address updated successfully");
        else
            return ResponseEntity.badRequest().body("Failed to update address");
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<String> updateEmail(@PathVariable int id, @RequestParam String email) {
        if(usersDAO.updateUserEmail(id, email)&&AuthController.authorized())
            return ResponseEntity.ok().body("Email updated successfully");
        else
            return ResponseEntity.badRequest().body("Failed to update email");
    }

}
