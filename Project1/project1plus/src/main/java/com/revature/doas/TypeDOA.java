package com.revature.doas;


import com.revature.models.Type;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeDOA implements TypeDOAInterface{
    @Override
    public Type getTypeById(int type_id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql= "select * from ers_reimbursement_type where type_id= ?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1,type_id);
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()){
                Type type = new Type(
                        resultSet.getInt("type_id"),
                        resultSet.getString("reimb_type")
                );
                return type;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
