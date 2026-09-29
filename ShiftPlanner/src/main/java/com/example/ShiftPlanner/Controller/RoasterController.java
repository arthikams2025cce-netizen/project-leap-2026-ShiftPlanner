package com.example.ShiftPlanner.Controller;

import com.example.ShiftPlanner.Service.RosterService;
import com.example.ShiftPlanner.model.Roster;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rosters")
class RosterController {

    private final RosterService service;

    public RosterController(RosterService service) {
        this.service = service;
    }

    @PostMapping
    public Roster addRoster(@RequestBody Roster roster) {
        return service.addRoster(roster);
    }

    @GetMapping
    public List<Roster> getRosters() {
        return service.getRosters();
    }

    @GetMapping("/{id}")
    public Roster getRoster(@PathVariable Long id) {
        return service.getRoster(id);
    }
}