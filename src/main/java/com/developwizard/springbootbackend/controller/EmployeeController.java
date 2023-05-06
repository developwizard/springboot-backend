package com.developwizard.springbootbackend.controller;

import com.developwizard.springbootbackend.entity.Employee;
import com.developwizard.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
}
