package com.emp.dao;

import java.sql.*;
import java.util.*;
import com.emp.bean.Employee;
import com.emp.util.DBConnection;

public class EmployeeDAO {

    // Add Employee
    public static int addEmployee(Employee e) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO employees(emp_name, department, salary) VALUES (?, ?, ?)");
            
            ps.setString(1, e.getEmpName());
            ps.setString(2, e.getDepartment());
            ps.setDouble(3, e.getSalary());

            status = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // Get All Employees
    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employees");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee e = new Employee();
                e.setEmpId(rs.getInt("emp_id"));
                e.setEmpName(rs.getString("emp_name"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getDouble("salary"));
                list.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Delete Employee
    public static int deleteEmployee(int id) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM employees WHERE emp_id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // Update Employee
    public static int updateEmployee(Employee e) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE employees SET emp_name=?, department=?, salary=? WHERE emp_id=?");

            ps.setString(1, e.getEmpName());
            ps.setString(2, e.getDepartment());
            ps.setDouble(3, e.getSalary());
            ps.setInt(4, e.getEmpId());

            status = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
}
