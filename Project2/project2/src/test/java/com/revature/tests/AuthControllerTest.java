package com.revature.tests;

import com.revature.controllers.AuthController;
import com.revature.daos.UsersDAO;
import com.revature.models.User;
import com.revature.models.UserLoginDTO;
import com.revature.utils.RequestSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {
    @Mock
    private UsersDAO usersDAO;
    @Mock
    private RequestSession requestSession;

    @InjectMocks
    private AuthController authController;

    @Test
    public void testLogin() {
        UserLoginDTO userLoginDTO = new UserLoginDTO("username", "password");
        User user = new User();
        when(usersDAO.findByUsernameAndPassword("username", "password")).thenReturn(Optional.of(user));
        ResponseEntity<User> response = authController.login(userLoginDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(requestSession).setAttribute("activeUser", user);
    }

    @Test
    public void testLogout() {
        authController.logout();
        verify(requestSession).setAttribute("activeUser", null);
    }

}