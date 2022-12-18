package com.revature.doas;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDOA implements UserDOAInterface{
    @Override
    public User insertUser(User user) {
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql= "INSERT INTO ERS_USERS(ers_username, ers_password, user_first_name, user_last_name, ers_user_roles_id_fk) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1, user.getErs_username());
            ps.setString(2, user.getErs_password());
            ps.setString(3, user.getUser_first_name());
            ps.setString(4, user.getUser_last_name());
            ps.setInt(5, user.getErs_user_roles_id_fk());
            ps.executeUpdate();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert of user failed");
        }
            return null;

    }

    @Override
    public Boolean updateUsersRole(String username, int role_id) {
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql= "UPDATE ERS_USERS SET ers_user_roles_id_fk = ? WHERE ers_username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, role_id);
            ps.setString(2, username);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Role did not update");
        }
            return false;
    }
}
