package com.emp.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.emp.bean.Employee;
import com.emp.dao.EmployeeDAO;

@SuppressWarnings("serial")
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Employee e = new Employee();
        e.setEmpName(req.getParameter("name"));
        e.setDepartment(req.getParameter("dept"));
        e.setSalary(Double.parseDouble(req.getParameter("salary")));

        EmployeeDAO.addEmployee(e);
        res.sendRedirect("list");
    }
}