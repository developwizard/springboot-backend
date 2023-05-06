package com.developwizard.springbootbackend.service.impl;

import com.developwizard.springbootbackend.entity.Employee;
import com.developwizard.springbootbackend.repository.EmployeeRepository;
import com.developwizard.springbootbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
