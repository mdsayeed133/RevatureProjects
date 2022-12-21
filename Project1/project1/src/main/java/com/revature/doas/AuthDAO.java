package com.revature.doas;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO implements AuthDOAInterface{
    @Override
    public User login(String username, String password) {
        try (Connection connection = ConnectionUtil.getConnection();) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ers_users where ers_username= ? and ers_password = ?");
            ps.setString(1,username);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String firstName= resultSet.getString("user_first_name");
                String lastName= resultSet.getString("user_last_name");
                int roleId= resultSet.getInt("ers_user_roles_id_fk");

                User user = new User(username,password,firstName,lastName,roleId);
                return user;
            } else {
                System.out.println("No user by that username");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
