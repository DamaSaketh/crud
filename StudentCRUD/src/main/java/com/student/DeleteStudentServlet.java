package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/DeleteStudentServlet")

public class DeleteStudentServlet extends HttpServlet {

protected void doGet(HttpServletRequest request,
HttpServletResponse response) throws IOException {

int id = Integer.parseInt(request.getParameter("id"));

try{

Connection con = DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement("delete from students where id=?");

ps.setInt(1,id);

ps.executeUpdate();

response.sendRedirect("viewStudents.jsp");

}

catch(Exception e){
e.printStackTrace();
}

}
}