package com.revature.doas;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDOA implements RoleDOAInterface{
    @Override
    public Role getRoleById(int role_id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
        String sql= "select * from ers_user_roles where role_id= ?";
        PreparedStatement ps= conn.prepareStatement(sql);
        ps.setInt(1,role_id);
        ResultSet resultSet= ps.executeQuery();
        while (resultSet.next()){
            Role role = new Role(
                    resultSet.getInt("role_id"),
                    resultSet.getString("user_role")
                    );
            return role;
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
