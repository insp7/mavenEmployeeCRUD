package com.lti;

import com.lti.dataAccessObjects.EmployeeDAO;
import com.lti.models.Employee;

import java.util.List;

/**
 * Driver class for basic employee management operations.
 *
 */
public class App {
    public static void main(String[] args) {
        // Create entity objects
        Employee emp1 = new Employee(7, "Aniket Konkar", "Graduate Engineer Trainee", 700);
        Employee emp2 = new Employee(8, "Soham Konkar", "Student", 800);
        Employee emp3 = new Employee(9, "Yash Vaidya", "Mechanical Engineer", 900);
        Employee emp4 = new Employee(10, "Dhananjay Ghumare", "Analyst", 1000);

        EmployeeDAO employeeDAO = new EmployeeDAO();

        // insert entity objects into database
        employeeDAO.insert(emp1);
        employeeDAO.insert(emp2);
        employeeDAO.insert(emp3);
        employeeDAO.insert(emp4);

        // display record by id
        Employee e = employeeDAO.getEmployeeById(7);
        System.out.println("Single employee object:");
        System.out.println(e.toString());

        // display all employees
        System.out.println("All the employees: ");
        List<Employee> employees = employeeDAO.getAllEmployees();
        employees.forEach(System.out::println);

        // delete employee by id
        employeeDAO.delete(10);

        // display all employees AFTER deletion
        System.out.println("All the employees AFTER DELETION: ");
        employees = employeeDAO.getAllEmployees();
        employees.forEach(System.out::println);

        // update employee by id
        emp1.setName("inspiration7");
        emp1.setDesignation("Gamer");
        emp1.setSalary(970);
        employeeDAO.update(emp1);

        // display record by id of the UPDATED employee
        e = employeeDAO.getEmployeeById(7);
        System.out.println("Single employee object AFTER UPDATE:");
        System.out.println(e.toString());
    }
}
