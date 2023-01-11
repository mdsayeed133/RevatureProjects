package com.revature.models;

import jakarta.persistence.*;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_type", nullable = false)
    private String statusType;

    public Status() {
    }

    public Status(String statusType) {
        this.statusType = statusType;
    }

    public Status(Long id, String statusType) {
        this.id = id;
        this.statusType = statusType;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }
}