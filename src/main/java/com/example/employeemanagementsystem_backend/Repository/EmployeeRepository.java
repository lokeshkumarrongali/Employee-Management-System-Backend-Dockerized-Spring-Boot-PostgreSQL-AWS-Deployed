package com.example.employeemanagementsystem_backend.Repository;

import com.example.employeemanagementsystem_backend.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}


