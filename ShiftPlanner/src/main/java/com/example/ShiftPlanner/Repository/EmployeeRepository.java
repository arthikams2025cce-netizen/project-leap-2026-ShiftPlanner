package com.example.ShiftPlanner.Repository;

import com.example.ShiftPlanner.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
