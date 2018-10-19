package com.decipher.dao.impl;

import com.decipher.dao.IEmployeeDao;
import com.decipher.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author : Suraj pratap singh
 * @implNote : Implementation of IEmployeeDao Interface
 */
@Transactional
@Repository("IEmployeeDao")
public class EmployeeDaoImpl implements IEmployeeDao {
    private static final Logger LOGGER = Logger.getLogger ( EmployeeDaoImpl.class.getName () );

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @param employee : To save employee object
     * @implNote : Save Employee Details
     */
    @Override
    public void save(Employee employee) {
        Session session = sessionFactory.openSession ();
        Transaction transaction = session.getTransaction ();
        try {
            transaction.begin ();
            session.save ( employee );
            transaction.commit ();
        } catch (Exception e) {
            transaction.rollback ();
            LOGGER.warning ( "Exception : " + e );
        } finally {
            session.close ();
            LOGGER.info ( "Hibernate Session closed..." );
        }
    }

    /**
     * @param employee : Update Employee Details
     * @implNote : Update Employee Details
     */
    @Override
    public void update(Employee employee) {
        Session session = this.sessionFactory.openSession ();

        Transaction transaction = session.getTransaction ();
        try {
            transaction.begin ();
            session.update ( employee );
            transaction.commit ();
        } catch (Exception e) {
            transaction.rollback ();
            LOGGER.warning ( "Exception : " + e );
        } finally {
            session.close ();
            LOGGER.info ( "Hibernate Session close..." );
        }
    }
    /**
     * @return : List<Employee>
     * @implNote : Get all employee details
     */
    @Override
    public List <Employee> getAllEmployeeData() {
        Session session = sessionFactory.openSession ();
        Transaction transaction = session.getTransaction ();
        List <Employee> employees = new ArrayList <> ();
        try {
            transaction.begin ();
            Query query = session.createQuery ( "from Employee e where e.status= : status" ).setString ( "status","active" );
            employees = (List <Employee>) query.list ();
            transaction.commit ();
        } catch (Exception exp) {
            transaction.rollback ();
            LOGGER.warning ( "Exception : " + exp );
        }
        return employees;
    }

    /**
     * @param id : Employee Id
     * @return Employee Object
     * @implNote : Get One Employee Using Id
     */
    @Override
    public Employee getEmployee(int id) {
        Session session=this.sessionFactory.openSession ();
        Transaction transaction=session.getTransaction ();
        Employee employee=null;
        try{
            transaction.begin ();
            employee=(Employee)session.get ( Employee.class,id );
           }catch(Exception e){
        LOGGER.warning ( "Exception : "+e );
        }finally{
            session.close ();
            LOGGER.info("Hibernate Session closed....");
        }
        return employee;
    }

    /**
     * @param mobileNumber : Employee Contact number
     * @return : List having employee details
     * @implNote : Get employee details using contact number
     */
    @Override
    public List <Employee> getByContact(String mobileNumber) {

        String query = "from Employee e where e.mobileNumber= ? and e.status= ? ";
        Session session = this.sessionFactory.getCurrentSession ();
        Query query1 = session.createQuery ( query );
        query1.setString ( 0, mobileNumber );
        query1.setString ( 1,"active");
        return query1.list ();
    }
}
