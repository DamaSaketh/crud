<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="com.student.DBConnection" %>

<%
int id = Integer.parseInt(request.getParameter("id"));

Connection con = DBConnection.getConnection();
PreparedStatement ps = con.prepareStatement(
"select * from students where id=?");

ps.setInt(1,id);

ResultSet rs = ps.executeQuery();

rs.next();
%>


<body>

<h2>Edit Student</h2>

<form action="UpdateStudentServlet" method="post">

<input type="hidden" name="id" value="<%=rs.getInt("id")%>">

Name:
<input type="text" name="name" value="<%=rs.getString("name")%>"><br><br>

Email:
<input type="text" name="email" value="<%=rs.getString("email")%>"><br><br>

Course:
<input type="text" name="course" value="<%=rs.getString("course")%>"><br><br>

<input type="submit" value="Update Student">

</form>

</body>
</html>