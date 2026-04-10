<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*, com.library.Book" %>

<h2>Library Books</h2>

<form action="SearchBookServlet" method="get">
    Search: <input type="text" name="title">
    <input type="submit" value="Search">
</form>

<a href="addBook.jsp">Add Book</a>

<table border="1">
<tr>
<th>ID</th><th>Title</th><th>Author</th>
<th>Category</th><th>Qty</th><th>Actions</th>
</tr>

<%
List<Book> list = (List<Book>) request.getAttribute("bookList");

for(Book b : list){
%>
<tr>
<td><%= b.getBookId() %></td>
<td><%= b.getTitle() %></td>
<td><%= b.getAuthor() %></td>
<td><%= b.getCategory() %></td>
<td><%= b.getQuantity() %></td>

<td>
<a href="EditBookServlet?id=<%= b.getBookId() %>">Edit</a> |
<a href="DeleteBookServlet?id=<%= b.getBookId() %>"
onclick="return confirm('Delete?')">Delete</a>
</td>

</tr>
<% } %>
</table>
</body>
</html>