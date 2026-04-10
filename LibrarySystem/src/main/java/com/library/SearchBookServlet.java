package com.library;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<Book> list = new ArrayList<>();

        try {
            String title = req.getParameter("title");
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM books WHERE title LIKE ?"
            );

            ps.setString(1, "%" + title + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book b = new Book();
                b.setBookId(rs.getInt("book_id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setCategory(rs.getString("category"));
                b.setQuantity(rs.getInt("quantity"));
                list.add(b);
            }

            req.setAttribute("bookList", list);
            req.getRequestDispatcher("viewBooks.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
