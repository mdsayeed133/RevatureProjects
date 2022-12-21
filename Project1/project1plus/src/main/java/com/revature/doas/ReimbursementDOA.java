package com.revature.doas;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReimbursementDOA implements ReimbursementDOAInterface{
    @Override
    public Reimbursement insertReimbursement(Reimbursement reimb) {
        try (Connection conn = ConnectionUtil.getConnection();) {
            String sql= "INSERT INTO ERS_REIMBURSEMENT " +
                    "(reimb_username_fk, reimb_amount, reimb_description, ers_reimbursement_type_id_fk, ers_reimbursement_status_id_fk) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set the values for the placeholders in the query
            ps.setString(1, reimb.getReimb_username_fk());
            ps.setDouble(2, reimb.getReimb_amount());
            ps.setString(3, reimb.getReimb_description());
            ps.setInt(4, reimb.getErs_reimbursement_type_id_fk());
            ps.setInt(5, reimb.getErs_reimbursement_status_id_fk());

            // Execute the query
            ps.executeUpdate();
            return reimb;
        } catch (SQLException e) {
            // Handle the exception
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Reimbursement> getAllReimbursement() {
        ArrayList<Reimbursement> reimbursements = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection();) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("reimb_id");
                String username = resultSet.getString("reimb_username_fk");
                double amount = resultSet.getDouble("reimb_amount");
                String description = resultSet.getString("reimb_description");
                int typeId = resultSet.getInt("ers_reimbursement_type_id_fk");
                int statusId = resultSet.getInt("ers_reimbursement_status_id_fk");

                Reimbursement reimbursement = new Reimbursement(id, username, amount, description, typeId, statusId);
                reimbursements.add(reimbursement);
            }
            return reimbursements;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Reimbursement getReimbursementById(int reimb_id) {

        try (Connection connection = ConnectionUtil.getConnection();) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT where reimb_id=?");
            ps.setInt(1,reimb_id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("reimb_username_fk");
                double amount = resultSet.getDouble("reimb_amount");
                String description = resultSet.getString("reimb_description");
                int typeId = resultSet.getInt("ers_reimbursement_type_id_fk");
                int statusId = resultSet.getInt("ers_reimbursement_status_id_fk");

                Reimbursement reimbursement = new Reimbursement(reimb_id, username, amount, description, typeId, statusId);
                return reimbursement;
            } else {
                System.out.println("No reimbursement by that id");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Reimbursement> getReimbursementByUsername(String username) {
        ArrayList<Reimbursement> reimbursements = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection();) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE reimb_username_fk = ?");
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("reimb_id");
                double amount = resultSet.getDouble("reimb_amount");
                String description = resultSet.getString("reimb_description");
                int typeId = resultSet.getInt("ers_reimbursement_type_id_fk");
                int statusId = resultSet.getInt("ers_reimbursement_status_id_fk");

                Reimbursement reimbursement = new Reimbursement(id, username, amount, description, typeId, statusId);
                reimbursements.add(reimbursement);
            }
            return reimbursements;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Reimbursement> getReimbursementByStatus(int status_id) {
        ArrayList<Reimbursement> reimbursements = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection();) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE ers_reimbursement_status_id_fk = ?");
            ps.setInt(1, status_id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("reimb_id");
                String username = resultSet.getString("reimb_username_fk");
                double amount = resultSet.getDouble("reimb_amount");
                String description = resultSet.getString("reimb_description");
                int typeId = resultSet.getInt("ers_reimbursement_type_id_fk");

                Reimbursement reimbursement = new Reimbursement(id, username, amount, description, typeId, status_id);
                reimbursements.add(reimbursement);
            }
            return reimbursements;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean updateReimbursementStatus(int reimb_id, int status_id) {
        if(hasReimbursementBeenProcessed(reimb_id))return false;
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql= "UPDATE ERS_REIMBURSEMENT SET ers_reimbursement_status_id_fk = ? WHERE reimb_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, status_id);
            ps.setInt(2, reimb_id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean hasReimbursementBeenProcessed(int reimb_id) {
        Reimbursement reimbursement = getReimbursementById(reimb_id);
        if(reimbursement.getErs_reimbursement_status_id_fk()==1){
            return false;
        } else return true;
    }


}
