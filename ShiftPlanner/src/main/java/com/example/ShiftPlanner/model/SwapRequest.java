package com.example.ShiftPlanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SwapRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requesterId;
    private Long colleagueId;
    private Long rosterId;

    private boolean colleagueApproved;
    private boolean managerApproved;

    private String status;

    public SwapRequest() {
    }

    public Long getId() {
        return id;
    }

    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public Long getColleagueId() {
        return colleagueId;
    }

    public void setColleagueId(Long colleagueId) {
        this.colleagueId = colleagueId;
    }

    public Long getRosterId() {
        return rosterId;
    }

    public void setRosterId(Long rosterId) {
        this.rosterId = rosterId;
    }

    public boolean isColleagueApproved() {
        return colleagueApproved;
    }

    public void setColleagueApproved(boolean colleagueApproved) {
        this.colleagueApproved = colleagueApproved;
    }

    public boolean isManagerApproved() {
        return managerApproved;
    }

    public void setManagerApproved(boolean managerApproved) {
        this.managerApproved = managerApproved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}