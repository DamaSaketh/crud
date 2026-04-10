package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/UpdateStudentServlet")

public class UpdateStudentServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws IOException {

int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String email = request.getParameter("email");
String course = request.getParameter("course");

try{

Connection con = DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement(
"update students set name=?,email=?,course=? where id=?");

ps.setString(1,name);
ps.setString(2,email);
ps.setString(3,course);
ps.setInt(4,id);

ps.executeUpdate();

response.sendRedirect("viewStudents.jsp");

}

catch(Exception e){
e.printStackTrace();
}

}
}
