package com.example.ShiftPlanner.Service;

import com.example.ShiftPlanner.Repository.RosterRepository;
import com.example.ShiftPlanner.model.Roster;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RosterService {

    private final RosterRepository repository;

    public RosterService(RosterRepository repository) {
        this.repository = repository;
    }

    // Add a roster
    public Roster addRoster(Roster roster) {
        return repository.save(roster);
    }

    // Get all rosters
    public List<Roster> getRosters() {
        return repository.findAll();
    }

    // Get one roster by ID
    public Roster getRoster(Long id) {
        return repository.findById(id).orElse(null);
    }
}