package com.revature.doas;

import com.revature.models.User;

public interface UserDOA {

    User insertUser(User user);

    Boolean updateRole(String username, int role_id);

}
