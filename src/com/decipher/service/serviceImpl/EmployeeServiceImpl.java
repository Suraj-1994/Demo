package com.decipher.service.serviceImpl;

import com.decipher.dao.IEmployeeDao;
import com.decipher.model.Employee;
import com.decipher.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Suraj Pratap Singh
 * @implNote : To perform CRUD operations of Employees in database
 * like Add, Delete , Update , Read Employee information.
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final IEmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void save(Employee employee) {
        employee.setStatus ( "active" );
        employeeDao.save ( employee );
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update ( employee );
    }

    @Override
    public void delete(int id) {
        Employee employee = employeeDao.getEmployee ( id );
        employee.setStatus ( "inactive" );
        employeeDao.update ( employee );
    }

    @Override
    public Employee getEmployee(int id) {
        Employee emp = employeeDao.getEmployee ( id );

        if (emp != null && emp.getStatus ().equals ( "inactive" )) {
            emp = null;
        }
        return emp;
    }

    @Override
    public List <Employee> getAllEmployeeData() {

        return employeeDao.getAllEmployeeData ();
    }

    @Override
    public List <Employee> getByContact(String mobileNumber) {
        List <Employee> emp = employeeDao.getByContact ( mobileNumber );
        return emp;
    }

}
