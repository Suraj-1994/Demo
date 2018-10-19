package com.decipher.service;

import com.decipher.model.Employee;

import java.util.List;

/**
 * @author : Suraj Pratap Singh
 * @implNote : interface EmployeeService
 */
public interface EmployeeService {
    void save(Employee employee);

    void update(Employee employee);

    void delete(int id);

    Employee getEmployee(int id);

    List <Employee> getAllEmployeeData();

    List <Employee> getByContact(String mobileNumber);
}
