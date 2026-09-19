package com.example.employeemanagementsystem_backend.service;

import com.example.employeemanagementsystem_backend.Dto.EmployeeDto;
import com.example.employeemanagementsystem_backend.Entity.Employee;
import com.example.employeemanagementsystem_backend.Mapper.EmployeeMapper;
import com.example.employeemanagementsystem_backend.Repository.EmployeeRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class Employeeserviceimpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    public EmployeeDto createEmployee(EmployeeDto e){
        Employee emp = EmployeeMapper.mapToEmployee(e);
         Employee saved = employeeRepository.save(emp);
        return EmployeeMapper.mapToEmployeeDto(saved);
    }

//    public EmployeeDto getEmployeebyId(Long id){
//     Employee emp = employeeRepository.findById(id).orElseThrow(()=>
//                new ResourceNotFoundException("emp with this "+id+"not there"));
//
//        return EmployeeMapper.mapToEmployeeDto(emp);
//
//    }

    public  List<EmployeeDto> allEmployees(){

        List<Employee> emps = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for(Employee emp : emps){
            employeeDtos.add(EmployeeMapper.mapToEmployeeDto(emp));
        }

        return employeeDtos;
    }

    public EmployeeDto getEmployeeById(Long id) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    public EmployeeDto updateEmployeeById(Long id,EmployeeDto e) {
          Employee emp = employeeRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

          emp.setFirstName(e.getFirstName());
          emp.setLastName(e.getLastName());
          emp.setEmail(e.getEmail());

          return  EmployeeMapper.mapToEmployeeDto(employeeRepository.save(emp));
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

}
