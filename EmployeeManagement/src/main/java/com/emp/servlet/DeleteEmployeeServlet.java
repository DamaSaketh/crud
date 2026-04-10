package com.emp.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.emp.dao.EmployeeDAO;

@SuppressWarnings("serial")
public class DeleteEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        EmployeeDAO.deleteEmployee(id);
        res.sendRedirect("list");
    }
}