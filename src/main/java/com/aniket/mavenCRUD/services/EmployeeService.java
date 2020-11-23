package com.aniket.mavenCRUD.services;

import com.aniket.mavenCRUD.dataAccessObjects.EmployeeDAO;
import com.aniket.mavenCRUD.models.Employee;

import java.util.List;

public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
    }

    public void add(Employee emp) {
        employeeDAO.insert(emp);
    }

    public Employee getEmployeeById(int i) {
        return employeeDAO.getEmployeeById(i);
    }

    public void delete(int i) {
        employeeDAO.delete(i);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public void update(Employee emp) {
        employeeDAO.update(emp);
    }
}
