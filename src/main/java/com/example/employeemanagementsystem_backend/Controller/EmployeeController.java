package com.example.employeemanagementsystem_backend.Controller;

import com.example.employeemanagementsystem_backend.Dto.EmployeeDto;
import com.example.employeemanagementsystem_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping(("/api/employees"))
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> getEmployee(@RequestBody EmployeeDto e) {
    EmployeeDto saved = employeeService.createEmployee(e);

    return new  ResponseEntity<>(saved,HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
       List<EmployeeDto> aa=  employeeService.allEmployees();
        return new ResponseEntity<>(aa,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto e) {
        EmployeeDto employeeDto = employeeService.updateEmployeeById(id,e);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);

    }


}
