package com.example.ShiftPlanner.Controller;

import com.example.ShiftPlanner.Service.ShiftService;
import com.example.ShiftPlanner.model.Shift;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shifts")
class ShiftController {

    private final ShiftService service;

    public ShiftController(ShiftService service) {
        this.service = service;
    }

    @PostMapping
    public Shift addShift(@RequestBody Shift shift) {
        return service.addShift(shift);
    }

    @GetMapping
    public List<Shift> getShifts() {
        return service.getShifts();
    }

    @GetMapping("/{id}")
    public Shift getShift(@PathVariable Long id) {
        return service.getShift(id);
    }

    @DeleteMapping("/{id}")
    public String deleteShift(@PathVariable Long id) {
        service.deleteShift(id);
        return "Shift deleted";
    }
}