package com.example.ShiftPlanner.Repository;

import com.example.ShiftPlanner.model.Roster;
import org.springframework.data.jpa.repository.JpaRepository;

interface RoasterRepository
        extends JpaRepository<Roster, Long> {
}