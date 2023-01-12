package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "accounts")
@Component
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "amount", nullable = false)
    private double amount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "accountTypeId", nullable = false)
    private AccountType accountType;

    public Account() {
    }

    public Account(int accountId, User user, double amount, AccountType accountType) {
        accountId = accountId;
        this.user = user;
        this.amount = amount;
        this.accountType = accountType;
    }

    public Account(User user, double amount, AccountType accountType) {
        this.user = user;
        this.amount = amount;
        this.accountType = accountType;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        accountId = accountId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", user=" + user +
                ", amount=" + amount +
                ", accountType=" + accountType +
                '}';
    }
}
