package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="requests")
@Component
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int requestId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="accountId")
    private int fromAccountId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    private int fromUserId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="accountId")
    private int toAccountId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    private int toUserId;

    private int amount;
    private String reason;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="statusId") //maybe issues.
    private int statusId;

    //boilerplate
    public Request() {
    }

    public Request(int fromAccountId, int fromUserId, int toAccountId, int toUserId, int amount, String reason, int statusId) {
        this.fromAccountId = fromAccountId;
        this.fromUserId = fromUserId;
        this.toAccountId = toAccountId;
        this.toUserId = toUserId;
        this.amount = amount;
        this.reason = reason;
        this.statusId = statusId;
    }

    public Request(int requestId, int fromAccountId, int fromUserId, int toAccountId, int toUserId, int amount, String reason, int statusId) {
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

    public int getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public int getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(int toAccountId) {
        this.toAccountId = toAccountId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
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
