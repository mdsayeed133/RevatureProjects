package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="inner_transfer_logs")
@Component
public class InnerTransferLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int innerTransferLogsId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="fromAccountId", nullable=false,insertable=true, updatable=false) //These are not null constrained. Might need to fix?
    private Account fromAccountId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="toAccountId", nullable=false,insertable=true, updatable=false) //These are not null constrained. Might need to fix?
    private Account toAccountId;

    @Column(nullable = false)
    private double amount;

    //Boilerplate

    public InnerTransferLog() {
    }

    public InnerTransferLog(Account fromAccountId, Account toAccountId, double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public InnerTransferLog(int innerTransferLogsId, Account fromAccountId, Account toAccountId, double amount) {
        this.innerTransferLogsId = innerTransferLogsId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public int getInnerTransferLogsId() {
        return innerTransferLogsId;
    }

    public void setInnerTransferLogsId(int innerTransferLogsId) {
        this.innerTransferLogsId = innerTransferLogsId;
    }

    public Account getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Account fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Account getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Account toAccountId) {
        this.toAccountId = toAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "InnerTransferLog{" +
                "innerTransferLogsId=" + innerTransferLogsId +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", amount=" + amount +
                '}';
    }
}
