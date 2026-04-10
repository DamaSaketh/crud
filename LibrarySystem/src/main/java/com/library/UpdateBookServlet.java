package com.library;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE books SET title=?, author=?, category=?, quantity=? WHERE book_id=?"
            );

            ps.setString(1, req.getParameter("title"));
            ps.setString(2, req.getParameter("author"));
            ps.setString(3, req.getParameter("category"));
            ps.setInt(4, Integer.parseInt(req.getParameter("quantity")));
            ps.setInt(5, Integer.parseInt(req.getParameter("id")));

            ps.executeUpdate();

            res.sendRedirect("ViewBooksServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
