package com.example.ShiftPlanner.Service;
import com.example.ShiftPlanner.Repository.ShiftRepository;
import com.example.ShiftPlanner.model.Shift;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ShiftService {
    private final ShiftRepository repository;
    public ShiftService(ShiftRepository repository) {
        this.repository = repository;
    }
    public Shift addShift(Shift shift) {
        return repository.save(shift);
    }

    public List<Shift> getShifts() {
        return repository.findAll();
    }

    public Shift getShift(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteShift(Long id) {
        repository.deleteById(id);
    }
}