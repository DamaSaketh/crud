<%@ page import="java.sql.*" %>
<%@ page import="com.student.DBConnection" %>

<html>
<head>
<title>Students</title>
</head>

<body>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="com.student.DBConnection" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students List</title>
</head>

<body>

<h2>Students List</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Course</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<%
Connection con = null;
Statement st = null;
ResultSet rs = null;

try {

    con = DBConnection.getConnection();

    // ✅ Check if connection failed
    if(con == null){
        out.println("<h3 style='color:red;'>Database connection failed!</h3>");
    } else {

        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM students");

        while(rs.next()){
%>

<tr>
<td><%= rs.getInt("id") %></td>
<td><%= rs.getString("name") %></td>
<td><%= rs.getString("email") %></td>
<td><%= rs.getString("course") %></td>

<td>
<a href="editStudent.jsp?id=<%= rs.getInt("id") %>">Edit</a>
</td>

<td>
<a href="DeleteStudentServlet?id=<%= rs.getInt("id") %>">Delete</a>
</td>
</tr>

<%
        }
    }

} catch(Exception e){
    out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
    e.printStackTrace();
} finally {

    // ✅ Close resources safely
    try { if(rs != null) rs.close(); } catch(Exception e){}
    try { if(st != null) st.close(); } catch(Exception e){}
    try { if(con != null) con.close(); } catch(Exception e){}
}
%>

</table>

<br>

<a href="addStudent.jsp">Add Student</a>

</body>
</html>

</body>
</html>