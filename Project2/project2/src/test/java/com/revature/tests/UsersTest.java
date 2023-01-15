package com.revature.tests;

import com.revature.daos.UsersDAO;
import com.revature.models.User;
import com.revature.models.UserLoginDTO;
import jakarta.servlet.http.HttpSession;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsersTest {

    @InjectMocks
    private UsersController usersController;
    @InjectMocks
    private AuthController authController;
    @Mock
    private UsersDAO usersDAO;
    @Mock
    private HttpSession session;

    @Before
    public void setup() {
        // Set up mock request
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(request.getSession()).thenReturn(session);

    }

    @Test
    public void testLogin() {
        // Create a mock HttpSession
        HttpSession session = mock(HttpSession.class);
        authController.ses = session;

        // Create a mock User object
        User user = new User(1, "fake", "password", "fake", "user", "address", "email");

        // Configure UsersDAO.findByUsernameAndPassword to return the mock User object
        when(usersDAO.findByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(Optional.of(user));

        // Create a UserLoginDTO object with the correct username and password
        UserLoginDTO loginDTO = new UserLoginDTO("fake", "password");

        // Call the login method
        ResponseEntity<User> response = authController.login(loginDTO);

        // Verify that the method returned a 200 OK response and the returned User object is the same as the mock User object
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), user);

        // Verify that the session attribute "activeUser" was set to the mock User object
        verify(session).setAttribute("activeUser", user);
    }

    @Test
    public void testGetUser() {
        // Create a mock HttpSession
        HttpSession session = mock(HttpSession.class);
        authController.ses = session;

        // Create a new User instance
        User user = new User(1, "username", "password", "firstName", "lastName", "address", "email");

        // Configure UsersDAO.findById to return the new created user
        when(usersDAO.findById(1)).thenReturn(Optional.of(user));
        // Configure AuthController.authorized to return true
        when(authController.authorized()).thenReturn(true);

        // Call the addUser method
        ResponseEntity<User> response = usersController.getUser(1);

        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody(),user);
    }

    @Test
    public void testAddUser() {
        // Create a mock HttpSession
        HttpSession session = mock(HttpSession.class);
        authController.ses = session;

        // Create a new User instance
        User user = new User(1, "username", "password", "firstName", "lastName", "address", "email");

        // Call the addUser method
        ResponseEntity<User> response = usersController.addUser(user);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
    @Test
    public void testUpdatePassword() {
        // Create a mock HttpSession
        HttpSession session = mock(HttpSession.class);
        authController.ses = session;

        // Configure UsersDAO.updateUserPassword to return true
        when(usersDAO.updateUserPassword(1, "password")).thenReturn(true);
        when(authController.authorized()).thenReturn(true);

        // Call the updatePassword method
        ResponseEntity<String> response = usersController.updatePassword(1, "password");

        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody(),"Password updated successfully");
    }



}