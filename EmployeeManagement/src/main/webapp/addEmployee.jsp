<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Employee</h2>
<form action="add" method="post">
    Name: <input type="text" name="name"><br>
    Department: <input type="text" name="dept"><br>
    Salary: <input type="text" name="salary"><br>
    <input type="submit" value="Add">
</form>

<a href="list">View Employees</a>

</body>
</html>