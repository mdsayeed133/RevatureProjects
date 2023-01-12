package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="inner_transfer_logs")
@Component
public class InnerTransferLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int innerTransferLogsId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="from_account_id") //These are not null constrained. Might need to fix?
    private int fromAccountId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="accountId") //These are not null constrained. Might need to fix?
    private int toAccountId;

    @Column(nullable = false)
    private double amount;

    //Boilerplate

    public InnerTransferLog() {
    }

    public InnerTransferLog(int fromAccountId, int toAccountId, double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public InnerTransferLog(int innerTransferLogsId, int fromAccountId, int toAccountId, double amount) {
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

    public int getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public int getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(int toAccountId) {
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
