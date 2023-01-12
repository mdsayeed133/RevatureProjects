package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "account_type")
@Component
public class AccountType {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int accountId;
    @Column(name = "account_type_name", nullable = false)
    private String accountTypeName;

    //Boilerplate
    public AccountType() {
    }

    public AccountType(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public AccountType(int accountId, String accountTypeName) {
        this.accountId = accountId;
        this.accountTypeName = accountTypeName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountId=" + accountId +
                ", accountTypeName='" + accountTypeName + '\'' +
                '}';
    }
}
