package com.revature.doas;

import com.revature.models.User;

public interface UserDOAInterface {

    User insertUser(User user);

    Boolean updateUsersRole(String username, int role_id);

}
