package com.decipher.controller;

import com.decipher.Constants;
import com.decipher.model.Employee;
import com.decipher.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author : Suraj Pratap Singh
 * @implNote : EmployeeController
 */
@Controller
@RequestMapping("/")
public class EmployeeController {
    private static final Logger LOGGER = Logger.getLogger ( EmployeeController.class.getName () );

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * @return : home JSP
     * @implNote : Send to the Home page
     */
    @RequestMapping(value = Constants.PATH_HOME_PAGE)
    public String homePage() {
        return "home";
    }

    /**
     * @return : employeeList JSP page
     * @implNote : Register employee
     */
    @RequestMapping(value = Constants.REGISTER_EMPLOYEE)
    public String registerData(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.save ( employee );
        String msg = "Employee Registered Successfully....";
        LOGGER.info ( msg );
        model.addAttribute ( "msg", msg );
        return Constants.PATH_HOME_PAGE;

    }

    /**
     * @param model : return employee List using model object
     * @return employeeList JSP page
     * @implNote : It will redirect to Employee List
     */
    @RequestMapping(value = Constants.GOTO_EMPLOYEE_LIST)
    public String gotoEmployeeList(Model model) {

        List <Employee> employeeData = employeeService.getAllEmployeeData ();
        if (employeeData != null) {
            model.addAttribute ( Constants.EMPLOYEE_LIST, employeeData );
        }
        return Constants.EMPLOYEE_LIST;
    }

    /**
     * @param id : Employee Id
     * @return : redirect:/goto
     * @implNote : It will delete employee then redirect to employeeList
     */
    @RequestMapping(value = Constants.DELETE_EMPLOYEE)
    public String deleteEmployee(@RequestParam("id") int id, Model model) {
        String msg = "Successfully deleted...";
        try {
            employeeService.delete ( id );
            model.addAttribute ( "msg", msg );

        } catch (Exception ex) {
            LOGGER.warning ( ex.getMessage () );
        }
        LOGGER.info ( "Employee Deleted Successfully..." );
        return Constants.UPDATE_BUTTON;
    }

    /**
     * @param employee : Employee Object
     * @return : redirect:/goto
     * @implNote : Update employee details then redirect to employeeList
     */
    @RequestMapping(value = Constants.UPDATE_EMPLOYEE)
    public String updateRecord(@ModelAttribute("employee") Employee employee, Model model) {
        try {
            employeeService.update ( employee );
        } catch (Exception e) {
            LOGGER.warning ( e.getMessage () );
        }
        String msg = "Employee record updated Successfully...";
        model.addAttribute ( "msg", msg );

        return Constants.UPDATE_BUTTON;
    }

    /**
     * @return update
     * @implNote : It will get employee data and redirect to update form
     */
    @RequestMapping(value = Constants.UPDATE_BUTTON)
    public String employeeList1() {
        return Constants.UPDATE_BUTTON;
    }

    /**
     * @param id    : Employee Id
     * @param model : Set employee details in model, related to that Employee id
     * @return : employeeList JSP
     * @implNote : This method is used to search by Id
     */
    @RequestMapping(value = "/searchById")
    public String searchById(@RequestParam("id") int id, Model model) {
        Employee emp1 = employeeService.getEmployee ( id );

        String msg = "Search by id \"Employee Not Found\"";
        if (emp1 != null) {
            model.addAttribute ( "employee", emp1 );
        } else {
            model.addAttribute ( "msg", msg );
            return Constants.SEARCH_EMPLOYEE;
        }

        return Constants.UPDATE_BUTTON;
    }

    /**
     * @return : search JSP
     * @implNote : It will redirect to search page
     */
    @RequestMapping(value = Constants.SEARCH_EMPLOYEE)
    public String searchPage() {
        return Constants.SEARCH_EMPLOYEE;
    }

    /**
     * @param mobileNumber : Employee Contact number
     * @param model        : Employee object into the model attribute.
     * @return : employeeList JSP
     * @implNote : Search employee by contact
     */
    @RequestMapping(value = "/searchByContact")
    public String searchByContact(@RequestParam("mobileNumber") String mobileNumber, Model model) {
        String msg = "Search by contact \"No record found!\" ";
        List <Employee> list = employeeService.getByContact ( mobileNumber );
        if (list.isEmpty ()) {
            model.addAttribute ( "msg", msg );
            return Constants.SEARCH_EMPLOYEE;
        } else {
            model.addAttribute ( "employeeList", list );
        }
        return Constants.EMPLOYEE_LIST;

    }

}


