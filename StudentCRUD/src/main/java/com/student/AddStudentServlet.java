package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/AddStudentServlet")

public class AddStudentServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws IOException {

String name = request.getParameter("name");
String email = request.getParameter("email");
String course = request.getParameter("course");

try{

Connection con = DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement(
"insert into students(name,email,course) values(?,?,?)");

ps.setString(1,name);
ps.setString(2,email);
ps.setString(3,course);

ps.executeUpdate();

response.sendRedirect("viewStudents.jsp");

}

catch(Exception e){
e.printStackTrace();
}

}
}