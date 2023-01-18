package com.revature.models;

public class TransactionDTO {
    private int targetAccountId;
    private String msg;
    private double amount;

    public TransactionDTO() {
    }

    public TransactionDTO(int targetAccountId, String msg, double amount) {
        this.targetAccountId = targetAccountId;
        this.msg = msg;
        this.amount = amount;
    }

    public int getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(int targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "targetAccountId=" + targetAccountId +
                ", msg='" + msg + '\'' +
                ", amount=" + amount +
                '}';
    }
}
