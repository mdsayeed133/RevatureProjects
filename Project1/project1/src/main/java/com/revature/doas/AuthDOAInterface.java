package com.revature.doas;

import com.revature.models.User;

public interface AuthDOAInterface {
    User login(String username, String password);
}
