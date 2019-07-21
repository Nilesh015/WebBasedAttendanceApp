<%-- 
    Document   : attend
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
     
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cahce");
            response.setHeader("Expires","0");
            if(session.getAttribute("username1") == null)
              {
                 response.sendRedirect("login.jsp");
              }
        %>
        
          <div class="card center">
              <div class="card-header">
                  <div class="btn-group" role="group" aria-label="Basic example">
                    <form action = "faculty.jsp">
                        <button type="submit" class="btn btn-secondary" value="faculty">View Details</button>
                      </form>
                      
                      <form action = "startattend.jsp">
                        <button type="submit" class="btn btn-secondary" value="startattend">Start Attendance</button>
                      </form>
                      
                      <form action = "create.jsp">
                        <button type="submit" class="btn btn-secondary" value="create">Add Course</button>
                      </form>
                  </div>
              </div>
            <div class="card-body">
              <p class="card-text">
                  <h2>Enter Details</h2>
                     <form action = "startattend" method="post">
                        <div class="form-group">
                          <label for="courseId">Course ID:</label>
                          <input type="text" class="form-control" id="courseId" aria-describedby="emailHelp" placeholder="Enter Course Id" name="CourseId" required>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="semester">Semester:</label>
                                <input type="text" class="form-control" id="semester" placeholder="Enter Semester" name="Sem" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="slot">Slot:</label>
                                <input type="text" class="form-control" id="slot" placeholder="Enter Slot" name="Slot" required>             
                            </div>
                        </div>
                        <br><br>
                        <h3>Current Session:</h3>
                        <p>(Confirm to end session)</p>
                        <table class="table">
                            <thead>
                              <tr>
                                <th scope="col">Course Id</th>
                                <th scope="col">Semester</th>
                                <th scope="col">Slot</th>
                                <th scope="col">Pin</th>
                              </tr>
                            </thead>
                            <tbody> 
			                  <tr>
                                <td>${courseId}</td>
                                <td>${sem}</td>  
                                <td>${slot}</td>
                                <td>${Pin}</td>
                              </tr>
                            </tbody>
                      </table>
                      
	                    <button type="submit" class="btn btn-primary" value = "timer" style="float: left">Start Timer</button>
                       
                     </form>    
                  
                  <form action = "Timer" method = "post">
                        <button type="submit" class="btn btn-primary" value = "restartattend" style="margin-left: 10px;float: left">Restart Timer</button>
                  </form>
                  
                  <form action = "Confirm" method ="post">
                        <button type="submit" class="btn btn-primary" value = "confirm"  style="margin-left: 10px;float: left">Confirm Attendance</button>
                  </form>
                  
                  <form action = "Cancel" method ="post">
                        <button type="submit" class="btn btn-primary" value = "cancel"  style="margin-left: 10px">Cancel</button>
                  </form>
                  
                  <br><br><br><br>
            <form action="Logout">
              <button type="submit" class="btn btn-primary" value = "Logout">Log out</button>
            </form>
           </div>
          </div>
    </body> 
</html>
