<%-- 
    Document   : student
    Created on : 27 Mar, 2019, 1:11:29 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<!DOCTYPE html>
<html class="bg">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://static.anychart.com/js/8.0.1/anychart-core.min.js"></script>
        <script src="https://static.anychart.com/js/8.0.1/anychart-pie.min.js"></script>
        <title>JSP Page</title>
        <br><br><br>
    </head>
    <style>
        
        .center{
            margin: auto;
            width: 70%;
           }
        .bg{
            /* The image used */
            background-image: linear-gradient(#AEB6BF, #FBFCFC);
            background-color: #FBFCFC;
            /* Full height */
            height: 100%; 
            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
        #container {
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
          }
    </style>
    <body style="background-color: rgba(255,0,0,0)">
     <sql:setDataSource var = "db" driver = "com.mysql.jdbc.Driver" url = "jdbc:mysql://localhost:3306/student" user = "root" password = "nilesh123" />
     <sql:query var="rs" dataSource="${db}">select * from student_data where Username = ?
         <sql:param value = "${username}" />  
     </sql:query>
        
     <sql:query var="rs1" dataSource="${db}">select * from student_course_data where uname = ?
          <sql:param value = "${username}" />   
      </sql:query>
        
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cahce");
            response.setHeader("Expires","0");
            if(session.getAttribute("username") == null)
              {
                 response.sendRedirect("login.jsp");
              }
        %>
        
          <div class="card center">
              <div class="card-header">
                  <div class="btn-group" role="group" aria-label="Basic example">
                      
                      <form action = "student.jsp">
                        <button type="submit" class="btn btn-secondary" value="student">View Details</button>
                      </form>
                      
                      <form action = "attend.jsp">
                        <button type="submit" class="btn btn-secondary" value="attend">Mark Attendance</button>
                      </form>
                      
                      <form action = "enroll.jsp">
                        <button type="submit" class="btn btn-secondary" value="enroll">Enroll Course</button>
                      </form>
                  </div>
              </div>
            <div class="card-body">
              <p class="card-text">
                  <h2>Student Details</h2>
                  <br>
                   <c:forEach items= "${rs.rows}" var="info">
	                  <b>Name: </b>  <c:out value="${info.name}"></c:out>  <br>
	                  <b>Department: </b>  <c:out value="${info.department}"></c:out>  <br>
	                  <b>Roll: </b>  <c:out value="${info.rollno}"></c:out>  <br>
	               </c:forEach>
                  <br><br><br>
              <table class="table">
                    <thead>
                      <tr>
                        <th scope="col">Course</th>
                        <th scope="col">Classes Attended</th>
                        <th scope="col">Classes Missed</th>
                        <th scope="col">Percentage Attendance</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items= "${rs1.rows}" var="info1">
	                  <tr>
                        <td> <c:out value="${info1.course_name}"></c:out> </td>
                        <td> <c:out value="${info1.attended}"></c:out> </td>
                        <td> <c:out value="${info1.missed}"></c:out> </td>
                        <td> <c:out value="${info1.percentage}"></c:out> </td>
                      </tr>
                      </c:forEach>
                      
                    </tbody>
              </table>
                      <br><br><br><br>
                      <form action="Logout">
                        <button type="submit" class="btn btn-primary" value = "Logout">Log out</button>
                      </form>
                </p>
              </div>
          </div>
                     
    </body> 
</html>
