<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.library.Book" %>

<%
Book b = (Book) request.getAttribute("book");
%>

<h2>Edit Book</h2>

<form action="UpdateBookServlet" method="post">

<input type="hidden" name="id" value="<%= b.getBookId() %>">

Title: <input type="text" name="title" value="<%= b.getTitle() %>"><br>
Author: <input type="text" name="author" value="<%= b.getAuthor() %>"><br>
Category: <input type="text" name="category" value="<%= b.getCategory() %>"><br>
Quantity: <input type="number" name="quantity" value="<%= b.getQuantity() %>"><br>

<input type="submit" value="Update Book">
</form>
</body>
</html>