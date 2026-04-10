package com.library;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books(title, author, category, quantity) VALUES (?, ?, ?, ?)"
            );

            ps.setString(1, req.getParameter("title"));
            ps.setString(2, req.getParameter("author"));
            ps.setString(3, req.getParameter("category"));
            ps.setInt(4, Integer.parseInt(req.getParameter("quantity")));

            ps.executeUpdate();

            res.sendRedirect("ViewBooksServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}