<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Book</h2>

<form action="AddBookServlet" method="post">
    Title: <input type="text" name="title"><br>
    Author: <input type="text" name="author"><br>
    Category: <input type="text" name="category"><br>
    Quantity: <input type="number" name="quantity"><br>
    <input type="submit" value="Add Book">
</form>

<a href="ViewBooksServlet">View Books</a>
</body>
</html>