package com.emp.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import com.emp.dao.EmployeeDAO;
import com.emp.bean.Employee;

@SuppressWarnings("serial")
public class ListEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<Employee> list = EmployeeDAO.getAllEmployees();
        req.setAttribute("empList", list);
        RequestDispatcher rd = req.getRequestDispatcher("listEmployees.jsp");
        rd.forward(req, res);
    }
}