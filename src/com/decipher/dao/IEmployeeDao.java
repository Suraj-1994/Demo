package com.decipher.dao;

import java.util.List;

import com.decipher.model.Employee;

/**
 * @author : Suraj Pratap Singh
 * {@link com.decipher.dao.impl.EmployeeDaoImpl}
 */
public interface IEmployeeDao {

    void save(Employee employee);

    void update(Employee employee);

    Employee getEmployee(int id);

    List <Employee> getAllEmployeeData();

    List <Employee> getByContact(String mobileNumber);
}
