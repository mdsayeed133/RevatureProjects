package com.revature.models;

import com.revature.doas.StatusDOA;
import com.revature.doas.TypeDOA;

public class Reimbursement {
    private int reimb_id;
    private String reimb_username_fk;
    private double reimb_amount;
    private String reimb_description;
    private int ers_reimbursement_type_id_fk;// for easy input
    private int ers_reimbursement_status_id_fk;//for easy input
    private Status status;//for get
    private Type type;//for get

    public Reimbursement() {
    }
    //default to  pending for status.
    public Reimbursement(String reimb_username_fk, double reimb_amount, String reimb_description, int ers_reimbursement_type_id_fk) {
        //to use the get methods
        TypeDOA typeDOA = new TypeDOA();
        StatusDOA statusDOA= new StatusDOA();

        this.reimb_username_fk = reimb_username_fk;
        this.reimb_amount = reimb_amount;
        this.reimb_description = reimb_description;
        this.ers_reimbursement_type_id_fk = ers_reimbursement_type_id_fk;
        this.ers_reimbursement_status_id_fk = 1;//pending
        this.type= typeDOA.getTypeById(ers_reimbursement_type_id_fk);
        this.status= statusDOA.getStatusById(1);
    }


    public Reimbursement(String reimb_username_fk, double reimb_amount, String reimb_description, int ers_reimbursement_type_id_fk, int ers_reimbursement_status_id_fk) {
        //to use the get methods
        TypeDOA typeDOA = new TypeDOA();
        StatusDOA statusDOA= new StatusDOA();

        this.reimb_username_fk = reimb_username_fk;
        this.reimb_amount = reimb_amount;
        this.reimb_description = reimb_description;
        this.ers_reimbursement_type_id_fk = ers_reimbursement_type_id_fk;
        this.ers_reimbursement_status_id_fk = ers_reimbursement_status_id_fk;
        this.type= typeDOA.getTypeById(ers_reimbursement_type_id_fk);
        this.status= statusDOA.getStatusById(ers_reimbursement_status_id_fk);
    }
    //used for getting data for sql
    public Reimbursement( int reimb_id,String reimb_username_fk, double reimb_amount, String reimb_description, int ers_reimbursement_type_id_fk, int ers_reimbursement_status_id_fk) {
        //to use the get methods
        TypeDOA typeDOA = new TypeDOA();
        StatusDOA statusDOA= new StatusDOA();
        this.reimb_id=reimb_id;
        this.reimb_username_fk = reimb_username_fk;
        this.reimb_amount = reimb_amount;
        this.reimb_description = reimb_description;
        this.ers_reimbursement_type_id_fk = ers_reimbursement_type_id_fk;
        this.ers_reimbursement_status_id_fk = ers_reimbursement_status_id_fk;
        this.type= typeDOA.getTypeById(ers_reimbursement_type_id_fk);
        this.status= statusDOA.getStatusById(ers_reimbursement_status_id_fk);
    }


    public int getReimb_id() {
        return reimb_id;
    }

    public void setReimb_id(int reimb_id) {
        this.reimb_id = reimb_id;
    }

    public String getReimb_username_fk() {
        return reimb_username_fk;
    }

    public void setReimb_username_fk(String reimb_username_fk) {
        this.reimb_username_fk = reimb_username_fk;
    }

    public double getReimb_amount() {
        return reimb_amount;
    }

    public void setReimb_amount(double reimb_amount) {
        this.reimb_amount = reimb_amount;
    }

    public String getReimb_description() {
        return reimb_description;
    }

    public void setReimb_description(String reimb_description) {
        this.reimb_description = reimb_description;
    }

    public int getErs_reimbursement_type_id_fk() {
        return ers_reimbursement_type_id_fk;
    }

    public void setErs_reimbursement_type_id_fk(int ers_reimbursement_type_id_fk) {
        TypeDOA typeDOA = new TypeDOA();
        this.ers_reimbursement_type_id_fk = ers_reimbursement_type_id_fk;
        this.type = typeDOA.getTypeById(ers_reimbursement_type_id_fk);
    }

    public int getErs_reimbursement_status_id_fk() {
        return ers_reimbursement_status_id_fk;
    }

    public void setErs_reimbursement_status_id_fk(int ers_reimbursement_status_id_fk) {
        StatusDOA statusDOA= new StatusDOA();
        this.ers_reimbursement_status_id_fk = ers_reimbursement_status_id_fk;
        this.status = statusDOA.getStatusById(ers_reimbursement_status_id_fk);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.ers_reimbursement_status_id_fk= status.getStatus_id();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
        this.ers_reimbursement_type_id_fk= type.getType_id();
    }


    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimb_id=" + reimb_id +
                ", reimb_username_fk='" + reimb_username_fk + '\'' +
                ", reimb_amount=" + reimb_amount +
                ", reimb_description='" + reimb_description + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
