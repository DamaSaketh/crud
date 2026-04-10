<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*,com.emp.bean.Employee" %>
<%@ page import="java.util.*,com.emp.bean.Employee" %>
<%@ page isELIgnored="false" %>

<h2>Employee List</h2>
<a href="addEmployee.jsp">Add New</a>

<%
List<Employee> list = (List<Employee>) request.getAttribute("empList");
%>

<% if(list != null && !list.isEmpty()) { %>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Department</th>
    <th>Salary</th>
    <th>Action</th>
</tr>

<% for(Employee e : list) { %>
<tr>
<td><%= e.getEmpId() %></td>
<td><%= e.getEmpName() %></td>
<td><%= e.getDepartment() %></td>
<td><%= e.getSalary() %></td>
<td>
    <a href="delete?id=<%= e.getEmpId() %>">Delete</a>
</td>
</tr>
<% } %>

</table>

<% } else { %>

<h3 style="color:red;">No Employees Found</h3>

<% } %>
</body>
</html>