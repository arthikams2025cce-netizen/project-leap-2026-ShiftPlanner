package com.example.ShiftPlanner.Controller;

import com.example.ShiftPlanner.Service.SwapRequestService;
import com.example.ShiftPlanner.model.SwapRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/swap-requests")
class SwapRequestController {

    private final SwapRequestService service;

    public SwapRequestController(
            SwapRequestService service) {

        this.service = service;
    }

    // Create request
    @PostMapping
    public SwapRequest createRequest(
            @RequestBody SwapRequest request) {

        return service.createRequest(request);
    }

    // View requests
    @GetMapping
    public List<SwapRequest> getRequests() {

        return service.getRequests();
    }

    // Colleague approval
    @PutMapping("/{id}/colleague")
    public SwapRequest colleagueApproval(
            @PathVariable Long id,
            @RequestParam boolean approved) {

        return service.colleagueApproval(
                id, approved);
    }

    // Manager approval
    @PutMapping("/{id}/manager")
    public SwapRequest managerApproval(
            @PathVariable Long id,
            @RequestParam boolean approved) {

        return service.managerApproval(
                id, approved);
    }
}