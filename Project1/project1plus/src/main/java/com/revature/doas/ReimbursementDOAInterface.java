package com.revature.doas;

import com.revature.models.Reimbursement;

import java.util.ArrayList;

public interface ReimbursementDOAInterface {
    Reimbursement insertReimbursement(Reimbursement reimb);
    ArrayList<Reimbursement> getAllReimbursement();
    Reimbursement getReimbursementById(int reimb_id);
    ArrayList<Reimbursement> getReimbursementByUsername(String username);
    ArrayList<Reimbursement> getReimbursementByStatus(int status_id);
    ArrayList<Reimbursement> getReimbursementByType(String username, int type_id);
    Boolean updateReimbursementStatus(int reimb_id, int status_id);

    Boolean hasReimbursementBeenProcessed(int reimb_id);
}
