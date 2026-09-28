package com.example.ShiftPlanner.Service;

import com.example.ShiftPlanner.model.Employee;
import com.example.ShiftPlanner.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployee(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee employee) {

        Employee oldEmployee = repository.findById(id).orElse(null);

        if (oldEmployee != null) {
            oldEmployee.setName(employee.getName());
            oldEmployee.setEmail(employee.getEmail());
            oldEmployee.setRole(employee.getRole());

            return repository.save(oldEmployee);
        }

        return null;
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}