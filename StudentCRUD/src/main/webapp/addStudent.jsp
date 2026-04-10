<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Student</h2>

<form action="AddStudentServlet" method="post">
   
    Name: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Course: <input type="text" name="course"><br><br>

    <input type="submit" value="Add Student">
</form>

<a href="viewStudents.jsp">View Students</a>

</body>
</html>