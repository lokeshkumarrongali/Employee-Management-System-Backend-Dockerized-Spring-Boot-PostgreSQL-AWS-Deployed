package com.example.employeemanagementsystem_backend.service;

import com.example.employeemanagementsystem_backend.Dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto e);
//    EmployeeDto updateEmployee(EmployeeDto e);
    EmployeeDto getEmployeeById(Long id);
   List< EmployeeDto> allEmployees();

    EmployeeDto updateEmployeeById(Long id,EmployeeDto e);

    void deleteEmployeeById(Long id);
//    EmployeeDto updateEmployee(EmployeeDto e);
}
