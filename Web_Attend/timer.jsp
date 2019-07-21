<%-- 
    Document   : faculty
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
     <sql:query var="rs" dataSource="${db}">select * from start_attendance where username = ?
         <sql:param value = "${username1}" />  
     </sql:query>
        <%
        	String courseId = request.getParameter("courseId");
			String slot = request.getParameter("slot");
			String sem = request.getParameter("sem");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cahce");
            response.setHeader("Expires","0");
            if(session.getAttribute("username1") == null)
              {
                 response.sendRedirect("login.jsp");
              }
        %>
        <div class="card center">
              <h5 class="card-header">Attendance Started</h5>  
            <div class="card-body">
              <p class="card-text center">
                  <h2>Timer Running!</h2>
                  <br>
                  <p>The Timer will run for 5 minutes.</p>
                  <br>
                  <h3>Session Attributes:</h3>
                  <table class="table">
                            <thead>
                              <tr>
                                <th scope="col">Course Id</th>
                                <th scope="col">Semester</th>
                                <th scope="col">Slot</th>
                              </tr>
                            </thead>
                            <tbody>
                              <c:forEach items= "${rs.rows}" var="info1"> 
			                  <tr>
                                <td> <c:out value="${info1.courseId}"></c:out> </td>
                                <td> <c:out value="${info1.sem}"></c:out> </td>  
                                <td> <c:out value="${info1.slot}"></c:out> </td>
                              </tr>
                              </c:forEach>
                            </tbody>
                      </table>
                  <br><br>
                  <h4>Pin:</h4>
                  <h1>${Pin}</h1>
                   <br><br>
                  <form action="startattend.jsp">
                       <button type="submit" class="btn btn-primary" value = "back" style="margin-left: 10px">Back</button>
                  </form>
                  
            </div>
        </div>         
    </body> 
    <script>
// Update the count down every 1 second
  var start = new Date().getTime();    
  var x = setInterval(function() {
  var s = 5*60*1000;
  var now = (int)( (System.currentTimeMillis() ) % 1000000000;
  var end = document.getElementById("data").value;
  
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
  // Output the result in an element with id="demo"
  document.getElementById("demo").innerHTML = ""+now;//minutes + "m " + seconds + "s ";
    
  // If the count down is over, write some text 
  if (distance < 0) {
    clearInterval(x);
    document.getElementById("demo").innerHTML = "EXPIRED";
  }
}, 1000);
</script>
</html>
