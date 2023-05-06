package com.developwizard.springbootbackend.service;

import com.developwizard.springbootbackend.entity.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * Saves employee into db
     *
     * @param employee Entity to be stored in the database
     */
    Employee saveEmployee(Employee employee);

    /**
     * Retrieves all employees from db
     *
     * @return Employees list
     */
    List<Employee> getAllEmployees();

    /**
     * Retrieves employee from db
     *
     * @param id Employee ID
     * @return Eployee
     */
    Employee getEmployeeById(long id);

    /**
     * Update employee by id
     *
     * @param employee New employee data
     * @param id       Employee ID to update
     * @return Updated employee
     */
    Employee updateEmployee(Employee employee, long id);

    /**
     * Remove employee from DB
     *
     * @param id Employee ID
     */
    void deleteEmployee(long id);
}
