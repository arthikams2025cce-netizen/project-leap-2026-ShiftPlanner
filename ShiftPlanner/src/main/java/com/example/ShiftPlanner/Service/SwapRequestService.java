package com.example.ShiftPlanner.Service;

import com.example.ShiftPlanner.Repository.SwapRequestRepository;
import com.example.ShiftPlanner.model.SwapRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwapRequestService {

    private final SwapRequestRepository repository;

    public SwapRequestService(SwapRequestRepository repository) {
        this.repository = repository;
    }



    // Create swap request
    public SwapRequest createRequest(SwapRequest request) {

        request.setStatus("PENDING");

        request.setColleagueApproved(false);

        request.setManagerApproved(false);

        return repository.save(request);
    }

    // View all requests
    public List<SwapRequest> getRequests() {

        return repository.findAll();
    }

    // Colleague approval
    public SwapRequest colleagueApproval(
            Long id, boolean approved) {

        SwapRequest request =
                repository.findById(id).orElse(null);

        if (request == null) {
            return null;
        }

        if (approved) {

            request.setColleagueApproved(true);

            request.setStatus("WAITING FOR MANAGER");

        } else {

            request.setStatus("REJECTED");
        }

        return repository.save(request);
    }

    // Manager approval
    public SwapRequest managerApproval(
            Long id, boolean approved) {

        SwapRequest request =
                repository.findById(id).orElse(null);

        if (request == null) {
            return null;
        }

        // Manager can approve only after colleague approval
        if (!request.isColleagueApproved()) {

            request.setStatus(
                    "COLLEAGUE APPROVAL REQUIRED");

            return repository.save(request);
        }

        if (approved) {

            request.setManagerApproved(true);

            request.setStatus("APPROVED");

        } else {

            request.setStatus("REJECTED");
        }

        return repository.save(request);
    }
}