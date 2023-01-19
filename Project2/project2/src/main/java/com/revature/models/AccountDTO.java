package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class AccountDTO {

    private int userId;

    private double amount;

    private int accountTypeId;

    public AccountDTO() {
    }

    public AccountDTO(int userId, double amount, int accountTypeId) {
        this.userId = userId;
        this.amount = amount;
        this.accountTypeId = accountTypeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }
}
