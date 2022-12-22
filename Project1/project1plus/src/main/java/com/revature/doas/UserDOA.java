package com.revature.doas;


import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public User getUserByUserName(String username) {
        try (Connection connection = ConnectionUtil.getConnection();) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ers_users where ers_username=?");
            ps.setString(1,username);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String password= resultSet.getString("ers_password");
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

    @Override
    public Boolean updateUsersAddress(String username, String address) {
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql= "UPDATE ERS_USERS SET user_address = ? WHERE ers_username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, address);
            ps.setString(2, username);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("address did not update");
        }
        return false;
    }
}
