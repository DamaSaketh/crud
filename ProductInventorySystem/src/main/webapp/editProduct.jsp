<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.inventory.Product" %>

<%
Product p = (Product) request.getAttribute("product");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>

<body>



<form action="UpdateProductServlet" method="post">

    <input type="hidden" name="id" value="${product.productId}">

    Name: <input type="text" name="productName" value="${product.productName}"><br>
    Price: <input type="text" name="price" value="${product.price}"><br>
    Quantity: <input type="text" name="quantity" value="${product.quantity}"><br>
    Category: <input type="text" name="category" value="${product.category}"><br>

    <input type="submit" value="Update Product">
</form>
</body>
</html>