<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page session="true" %>
<%
    String user = (String) session.getAttribute("username");

    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>


<head>
    <title>Home</title>
</head>
<body>

<h2>Welcome, <%= user %>!</h2>

<a href="LogoutServlet">Logout</a>

</body>
</html>
