import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
        	int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("productName");
            double price = Double.parseDouble(req.getParameter("price"));
            int qty = Integer.parseInt(req.getParameter("quantity"));
            String category = req.getParameter("category");

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE products SET product_name=?, price=?, quantity=?, category=? WHERE product_id=?"
            );

            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, qty);
            ps.setString(4, category);
            ps.setInt(5, id);

            int result = ps.executeUpdate();

            System.out.println("Rows updated: " + result);

            res.sendRedirect("ViewProductsServlet");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}