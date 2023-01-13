package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "status")
@Component
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;

    @Column(name = "status_type", nullable = false)
    private String statusType;

    public Status() {
    }

    public Status(String statusType) {
        this.statusType = statusType;
    }

    public Status(int id, String statusType) {
        this.statusId = id;
        this.statusType = statusType;
    }

    // getters and setters
    public int getId() {
        return statusId;
    }

    public void setId(int id) {
        this.statusId = id;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + statusId +
                ", statusType='" + statusType + '\'' +
                '}';
    }


}