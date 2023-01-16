package com.revature.services;

import com.revature.daos.UsersDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UsersDAO usersDAO;

    @Autowired
    public UserService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public Optional<User> getUserById(int id){
        return usersDAO.findById(id);
    }

    public boolean updatePassword(int userId, String password) {
        User user = usersDAO.findById(userId).orElse(null);
        if (user == null) {
            return false;
        }
        user.setPassword(password);
        usersDAO.save(user);
        return true;
    }
    public boolean updateFirstName(int userId, String firstName) {
        User user = usersDAO.findById(userId).orElse(null);
        if (user == null) {
            return false;
        }
        user.setFirstName(firstName);
        usersDAO.save(user);
        return true;
    }

    public boolean updateLastName(int userId, String lastName) {
        User user = usersDAO.findById(userId).orElse(null);
        if (user == null) {
            return false;
        }
        user.setLastName(lastName);
        usersDAO.save(user);
        return true;
    }

    public boolean updateAddress(int userId, String address) {
        User user = usersDAO.findById(userId).orElse(null);
        if (user == null) {
            return false;
        }
        user.setAddress(address);
        usersDAO.save(user);
        return true;
    }

    public boolean updateEmail(int userId, String email){
        User user = usersDAO.findById(userId).orElse(null);
        if (user == null) {
            return false;
        }
        user.setEmail(email);
        usersDAO.save(user);
        return true;
    }
}
