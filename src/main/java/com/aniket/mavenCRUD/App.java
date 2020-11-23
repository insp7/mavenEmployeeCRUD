package com.aniket.mavenCRUD;

import com.aniket.mavenCRUD.models.Employee;
import com.aniket.mavenCRUD.services.EmployeeService;

import java.util.List;

/**
 * Driver class for basic employee management operations.
 *
 */
public class App {
    public static void main(String[] args) {
        // Create entity objects
        Employee emp1 = new Employee(7, "insp", "Graduate Engineer Trainee", 700);
        Employee emp2 = new Employee(8, "cheese", "GET", 800);
        Employee emp3 = new Employee(9, "cmp", "Mechanical Engineer", 900);
        Employee emp4 = new Employee(10, "dhs", "Analyst", 1000);

        EmployeeService empService = new EmployeeService();

        // insert entity objects into database
        empService.add(emp1);
        empService.add(emp2);
        empService.add(emp3);
        empService.add(emp4);

        // display record by id
        Employee e = empService.getEmployeeById(7);
        System.out.println("Single employee object:");
        System.out.println(e.toString());

        // display all employees
        System.out.println("All the employees: ");
        List<Employee> employees = empService.getAllEmployees();
        employees.forEach(System.out::println);

        // delete employee by id
        empService.delete(10);

        // display all employees AFTER deletion
        System.out.println("All the employees AFTER DELETION: ");
        employees = empService.getAllEmployees();
        employees.forEach(System.out::println);

        // update employee by id
        emp1.setName("inspiration7");
        emp1.setDesignation("Gamer");
        emp1.setSalary(970);
        empService.update(emp1);

        // display record by id of the UPDATED employee
        e = empService.getEmployeeById(7);
        System.out.println("Single employee object AFTER UPDATE:");
        System.out.println(e.toString());
    }
}
