package com.example.ShiftPlanner.Repository;

import com.example.ShiftPlanner.model.Roster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RosterRepository
        extends JpaRepository<Roster, Long> {
}