package com.example.employeemanagementsystem_backend.Mapper;

import com.example.employeemanagementsystem_backend.Dto.EmployeeDto;
import com.example.employeemanagementsystem_backend.Entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee e) {
        return new EmployeeDto(
                e.getId(),
        e.getFirstName(),
        e.getLastName(),
        e.getEmail()

        );
    }

    public static Employee mapToEmployee(EmployeeDto e) {
        return new Employee(
            e.getId(),
            e.getFirstName(),
            e.getLastName(),
            e.getEmail()
        );
    }
}
