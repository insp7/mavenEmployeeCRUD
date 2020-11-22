package com.lti.dataAccessObjects;

import com.lti.Database;
import com.lti.constants.EmployeeDAOConstants;
import com.lti.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATE TABLE employees (
 *      id NUMBER(10) PRIMARY KEY,
 *      name VARCHAR2(127),
 *      designation VARCHAR2(127),
 *      salary NUMBER(10)
 * );
 *
 * Employee DAO to perform operations on the employees relation.
 */
public class EmployeeDAO {
    private final Connection con;
    private PreparedStatement ps;

    public EmployeeDAO() {
        con = Database.getConnection();
        if(con != null)
            System.out.println("Connection established.");
    }

    public void insert(Employee emp) {
        try {
            ps = con.prepareStatement(EmployeeDAOConstants.INSERT_QUERY);
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDesignation());
            ps.setInt(4, emp.getSalary());

            int recordsInserted = ps.executeUpdate();
            System.out.println(recordsInserted + " record(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Employee emp) {
        try {
            ps = con.prepareStatement(EmployeeDAOConstants.UPDATE_QUERY);
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDesignation());
            ps.setInt(3, emp.getSalary());
            ps.setInt(4, emp.getId());

            int recordsUpdated = ps.executeUpdate();
            System.out.println(recordsUpdated + " record(s) updated.");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            ps = con.prepareStatement(EmployeeDAOConstants.DELETE_QUERY);
            ps.setInt(1, id);
            int recordsDeleted = ps.executeUpdate();
            System.out.println(recordsDeleted + " record(s) deleted.");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        try {
            ps = con.prepareStatement(EmployeeDAOConstants.SELECT_QUERY);
            ResultSet rs = ps.executeQuery();

            List<Employee> employees = new ArrayList<>();
            while(rs.next())
                employees.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("designation"), rs.getInt("salary")));
            return employees;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Employee getEmployeeById(int id) {
        try {
            ps = con.prepareStatement(EmployeeDAOConstants.SELECT_BY_ID_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("designation"), rs.getInt("salary"));
            return null;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
