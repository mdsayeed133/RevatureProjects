package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "account_type")
@Component
public class AccountType {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "account_type_name", nullable = false)
    private String accountTypeName;

    //Boilerplate
    public AccountType() {
    }

    //All args - id
    public AccountType(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    //All args
    public AccountType(int id, String accountTypeName) {
        this.id = id;
        this.accountTypeName = accountTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", accountTypeName='" + accountTypeName + '\'' +
                '}';
    }
}
