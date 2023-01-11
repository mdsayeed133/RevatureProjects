package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "transaction_types")
@Component
public class TransactionType {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column(name="transaction_types_name", nullable = false )
    private String transaction_types_name;

    //boilerplate
    public TransactionType() {
    }

    //All args - id
    public TransactionType(String transaction_types_name) {
        this.transaction_types_name = transaction_types_name;
    }

    //All args
    public TransactionType(int id, String transaction_types_name) {
        this.id = id;
        this.transaction_types_name = transaction_types_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransaction_types_name() {
        return transaction_types_name;
    }

    public void setTransaction_types_name(String transaction_types_name) {
        this.transaction_types_name = transaction_types_name;
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "id=" + id +
                ", transaction_types_name='" + transaction_types_name + '\'' +
                '}';
    }
}
