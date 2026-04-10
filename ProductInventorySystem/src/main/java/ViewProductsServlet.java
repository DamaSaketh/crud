import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.inventory.Product;

import java.sql.*;
import java.util.*;

@SuppressWarnings("serial")
@WebServlet("/viewProducts")

public class ViewProductsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        List<Product> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");

            while(rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("product_id"));
                p.setProductName(rs.getString("product_name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategory(rs.getString("category"));

                list.add(p);
            }

            req.setAttribute("productList", list);
            req.getRequestDispatcher("viewProducts.jsp").forward(req, res);
           

        } catch(Exception e) {
            e.printStackTrace();
    
        }
        
    }
    
}

