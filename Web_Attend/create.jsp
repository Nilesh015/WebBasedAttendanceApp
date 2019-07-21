<%-- 
    Document   : faculty
    Created on : 27 Mar, 2019, 1:11:29 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                  <h2>Course Details</h2>
                  <br>
                    <form action="Create" method="post">
                        <div class="form-group">
                          <label for="courseName">Course Name:</label>
                          <input type="text" class="form-control" id="courseId" aria-describedby="emailHelp" placeholder="Enter Course Name" name = "CourseName" required>
                        </div>
                        <div class="form-group">
                          <label for="courseId">Course ID:</label>
                          <input type="text" class="form-control" id="courseId" aria-describedby="emailHelp" placeholder="Enter Course Id" name = "CourseId" required>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="semester">Semester:</label>
                                <input type="text" class="form-control" id="semester" placeholder="Enter Semester" name = "Semester" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="slot">Slot:</label>
                                <input type="text" class="form-control" id="slot" placeholder="Enter Slot" name = "Slot" required>             
                            </div>
                        </div>  
                        <button type="submit" class="btn btn-primary">Add Course</button>
                    </form>  
                       <br><br><br><br><br>
                      <form action="Logout">
                        <button type="submit" class="btn btn-primary" value = "Logout">Log out</button>
                      </form>
                </p>
              </div>
          </div>         
    </body> 
</html>
