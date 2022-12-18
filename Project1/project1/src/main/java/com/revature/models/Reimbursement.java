package com.revature.models;

public class Reimbursement {
    private int reimb_id;
    private String reimb_username_fk;
    private double reimb_amount;
    private String reimb_description;
    private int ers_reimbursement_type_id_fk;//for put
    private int getErs_reimbursement_status_id_fk;//for put
    private Status status;//for get
    private Type type;//for get

    public Reimbursement() {
    }

    public Reimbursement(int reimb_id, String reimb_username_fk, double reimb_amount, String reimb_description, int ers_reimbursement_type_id_fk, int getErs_reimbursement_status_id_fk) {
        this.reimb_id = reimb_id;
        this.reimb_username_fk = reimb_username_fk;
        this.reimb_amount = reimb_amount;
        this.reimb_description = reimb_description;
        this.ers_reimbursement_type_id_fk = ers_reimbursement_type_id_fk;
        this.getErs_reimbursement_status_id_fk = getErs_reimbursement_status_id_fk;
    }

    public Reimbursement(int reimb_id, String reimb_username_fk, double reimb_amount, String reimb_description, Status status, Type type) {
        this.reimb_id = reimb_id;
        this.reimb_username_fk = reimb_username_fk;
        this.reimb_amount = reimb_amount;
        this.reimb_description = reimb_description;
        this.status = status;
        this.type = type;
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
        this.ers_reimbursement_type_id_fk = ers_reimbursement_type_id_fk;
    }

    public int getGetErs_reimbursement_status_id_fk() {
        return getErs_reimbursement_status_id_fk;
    }

    public void setGetErs_reimbursement_status_id_fk(int getErs_reimbursement_status_id_fk) {
        this.getErs_reimbursement_status_id_fk = getErs_reimbursement_status_id_fk;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimb_id=" + reimb_id +
                ", reimb_username_fk='" + reimb_username_fk + '\'' +
                ", reimb_amount=" + reimb_amount +
                ", reimb_description='" + reimb_description + '\'' +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
