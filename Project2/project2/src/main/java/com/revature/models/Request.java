package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="requests")
@Component
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="fromAccountId",insertable=false, updatable=false)
    private Account fromAccountId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="fromUserId",insertable=false, updatable=false)
    private User fromUserId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="toAccountId",insertable=false, updatable=false)
    private Account toAccountId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="toUserId",insertable=false, updatable=false)
    private User toUserId;

    private double amount;
    private String reason;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="statusId") //maybe issues.
    private Status statusId;

    //boilerplate
    public Request() {
    }

    public Request(Account fromAccountId, User fromUserId, Account toAccountId, User toUserId, double amount, String reason, Status statusId) {
        this.fromAccountId = fromAccountId;
        this.fromUserId = fromUserId;
        this.toAccountId = toAccountId;
        this.toUserId = toUserId;
        this.amount = amount;
        this.reason = reason;
        this.statusId = statusId;
    }

    public Request(int requestId, Account fromAccountId, User fromUserId, Account toAccountId, User toUserId, double amount, String reason, Status statusId) {
        this.requestId = requestId;
        this.fromAccountId = fromAccountId;
        this.fromUserId = fromUserId;
        this.toAccountId = toAccountId;
        this.toUserId = toUserId;
        this.amount = amount;
        this.reason = reason;
        this.statusId = statusId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Account getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Account fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public User getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(User fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Account getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Account toAccountId) {
        this.toAccountId = toAccountId;
    }

    public User getToUserId() {
        return toUserId;
    }

    public void setToUserId(User toUserId) {
        this.toUserId = toUserId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", fromAccountId=" + fromAccountId +
                ", fromUserId=" + fromUserId +
                ", toAccountId=" + toAccountId +
                ", toUserId=" + toUserId +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                ", statusId=" + statusId +
                '}';
    }
}
