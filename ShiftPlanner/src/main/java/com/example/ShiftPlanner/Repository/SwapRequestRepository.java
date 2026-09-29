package com.example.ShiftPlanner.Repository;

import com.example.ShiftPlanner.model.SwapRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SwapRequestRepository
        extends JpaRepository<SwapRequest, Long> {
}