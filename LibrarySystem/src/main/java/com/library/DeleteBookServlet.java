package com.library;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM books WHERE book_id=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            res.sendRedirect("ViewBooksServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
