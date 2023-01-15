package com.revature.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.revature.daos.UsersDAO;
import com.revature.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UsersControllerTest {

    @InjectMocks
    private UsersController usersController;

    @Mock
    private UsersDAO usersDAO;

    @Test
    public void testGetUser() {
        // Create a new User instance
        User user = new User(1, "username", "password", "firstName", "lastName", "address", "email");
        // Configure UsersDAO.findById to return true
        when(usersDAO.findById(1)).thenReturn(Optional.of(user));
        // Call the addUser method
        ResponseEntity<User> response = usersController.getUser(1);

        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody(),user);
        assertEquals(response.getBody().getUsername(),"username");
    }

    @Test
    public void testAddUser() {
        // Set up mock request
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        // Configure UsersDAO.addUser to return true
        when(usersDAO.save(any(User.class))).thenReturn(new User());

        // Create a new User instance
        User user = new User(1, "John", "Doe", "johndoe@example.com", "password", "address", "email");

        // Call the addUser method
        ResponseEntity<User> response = usersController.addUser(user);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


}