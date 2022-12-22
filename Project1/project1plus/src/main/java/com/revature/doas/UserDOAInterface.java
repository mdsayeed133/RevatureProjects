package com.revature.doas;

import com.revature.models.User;

public interface UserDOAInterface {
    User insertUser(User user);

    User getUserByUserName(String username);
    Boolean updateUsersRole(String username, int role_id);
    Boolean updateUsersAddress(String username, String address);

}
