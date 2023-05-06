package com.developwizard.springbootbackend.service.impl;

import com.developwizard.springbootbackend.entity.Employee;
import com.developwizard.springbootbackend.exception.ResourceNotFoundException;
import com.developwizard.springbootbackend.repository.EmployeeRepository;
import com.developwizard.springbootbackend.service.EmployeeService;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private static final String EMPLOYEE = "Employee";
    private static final String ID = "ID";

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(EMPLOYEE, ID, id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        val existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(EMPLOYEE, ID, id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(EMPLOYEE, ID, id));
        employeeRepository.deleteById(id);
    }
}
