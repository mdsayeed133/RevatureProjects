package com.revature.tests;

import com.revature.controllers.AuthController;
import com.revature.controllers.UsersController;
import com.revature.daos.UsersDAO;
import com.revature.models.User;
import com.revature.utils.RequestSession;
import org.junit.Before;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsersTest {

    @Mock
    private UsersDAO usersDAO;
    @Mock
    private RequestSession requestSession;
    @InjectMocks
    private UsersController usersController;
    @InjectMocks
    private AuthController authController;

    @Before
    public void setup() {
        // Set up mock request
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void testGetUser() {

        // Create a new User instance
        User user = new User(1, "username", "password", "firstName", "lastName", "address", "email");

        // Configure UsersDAO.findById to return the new created user
        when(usersDAO.findById(1)).thenReturn(Optional.of(user));
        // Configure session to return the new created user
        when(requestSession.getAttribute(anyString())).thenReturn(user);

        // Call the addUser method
        ResponseEntity<User> response = usersController.getUser(1);

        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody(),user);
    }

    @Test
    public void testAddUser() {

        // Create a new User instance
        User user = new User(1, "username", "password", "firstName", "lastName", "address", "email");

        // Call the addUser method
        ResponseEntity<User> response = usersController.addUser(user);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
    @Test
    public void testUpdatePassword() {

        // Configure UsersDAO.updateUserPassword to return true
        when(usersDAO.updateUserPassword(1, "password")).thenReturn(true);
        // Configure session to return the new created user
        when(requestSession.getAttribute(anyString())).thenReturn(new User());

        // Call the updatePassword method
        ResponseEntity<String> response = usersController.updatePassword(1, "password");

        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody(),"Password updated successfully");
    }



}