
<%@ page import="java.util.*, com.inventory.Product" %>

<html>
<head>
    <title>Products</title>
</head>
<body>

<h2>Product List</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Category</th>
    <th>Actions</th> <!-- ✅ NEW COLUMN -->
</tr>

<%
List<Product> list = (List<Product>) request.getAttribute("productList");

for(Product p : list) {
%>
<tr>
    <td><%= p.getProductId() %></td>
    <td><%= p.getProductName() %></td>
    <td><%= p.getPrice() %></td>
    <td><%= p.getQuantity() %></td>
    <td><%= p.getCategory() %></td>

    <td>
      
    <a href="EditProductServlet?id=<%= p.getProductId() %>">Edit</a>

    <a href="DeleteProductServlet?id=<%= p.getProductId() %>"
       onclick="return confirm('Are you sure?')">Delete</a> |

   
  
</td>
 
</tr>
<%
}
%>

</table>


</body>
</html>