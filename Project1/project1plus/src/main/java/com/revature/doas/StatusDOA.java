package com.revature.doas;


import com.revature.models.Status;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusDOA implements StatusDOAInterface {
    @Override
    public Status getStatusById(int status_id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql= "select * from ers_reimbursement_status where status_id= ?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1,status_id);
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()){
                Status status = new Status(
                        resultSet.getInt("status_id"),
                        resultSet.getString("reimb_status")
                );
                return status;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
