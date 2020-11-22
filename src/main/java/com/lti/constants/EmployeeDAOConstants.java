package com.lti.constants;

public interface EmployeeDAOConstants {
    String INSERT_QUERY = "INSERT INTO employees(id, name, designation, salary) VALUES(?, ?, ?, ?)";
    String UPDATE_QUERY = "UPDATE employees SET name = ?, designation = ?, salary = ? WHERE id = ?";
    String DELETE_QUERY = "DELETE FROM employees WHERE id = ?";
    String SELECT_BY_ID_QUERY = "SELECT * FROM employees WHERE id = ?";
    String SELECT_QUERY = "SELECT * FROM employees";
}
