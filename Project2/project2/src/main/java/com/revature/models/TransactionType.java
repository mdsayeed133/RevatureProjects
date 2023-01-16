package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "transaction_types")
@Component
public class TransactionType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int transactionTypeId;
    @Column(name="transaction_types_name", nullable = false )
    private String transactionTypesName;

    //boilerplate
    public TransactionType() {
    }

    //All args - id
    public TransactionType(String transactionTypesName) {
        this.transactionTypesName = transactionTypesName;
    }

    //All args

    public TransactionType(int transactionTypeId, String transactionTypesName) {
        this.transactionTypeId = transactionTypeId;
        this.transactionTypesName = transactionTypesName;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getTransactionTypesName() {
        return transactionTypesName;
    }

    public void setTransactionTypesName(String transactionTypesName) {
        this.transactionTypesName = transactionTypesName;
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "transactionId=" + transactionTypeId +
                ", transaction_types_name='" + transactionTypesName + '\'' +
                '}';
    }
}
