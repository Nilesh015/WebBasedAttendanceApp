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
             .collapsible {
                    background-color: rgba(0,0,0,0.5);
                    color: white;
                    cursor: pointer;
                    padding: 18px;
                    width: 100%;
                    border: none;
                    text-align: left;
                    outline: none;
                    font-size: 15px;
                    position: relative;
                  }

                  .active, .collapsible:hover {
                    background-color: #555;
                  }

                  .content {
                    padding: 0 18px;
                    display: none;
                    overflow: hidden;
                    background-color: #f1f1f1;
                    position: relative;
                  }
            .center{
            margin: auto;
            width: 70%;
           }
        .bg{
            /* The image used */
            background-image: linear-gradient(#AEB6BF, #FBFCFC);
            background-color: #FBFCFC;
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
          
		select#soflow {
			   -webkit-appearance: button;
			   -webkit-border-radius: 2px;
			   -webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
			   -webkit-padding-end: 20px;
			   -webkit-padding-start: 2px;
			   -webkit-user-select: none;
			   background-image: url("15xvbd5.png"), -webkit-linear-gradient(#FAFAFA, #F4F4F4 40%, #E5E5E5);
			   background-position: 97% center;
			   background-repeat: no-repeat;
			   border: 1px solid #AAA;
			   color: #555;
			   font-size: inherit;
			   margin: 10px;
			   overflow: hidden;
			   padding: 5px 10px;
			   text-overflow: ellipsis;
			   white-space: nowrap;
			   width: 300px;
			}


	
    </style>
    <body style="background-color: rgba(255,0,0,0)">
    
    <sql:setDataSource var = "db" driver = "com.mysql.jdbc.Driver" url = "jdbc:mysql://localhost:3306/student" user = "root" password = "nilesh123" />
     <sql:query var="rs" dataSource="${db}">select * from faculty_data where Username = ?
         <sql:param value = "${username1}" />  
      </sql:query>
      
      <sql:query var="rs1" dataSource="${db}">select * from master_student where course_name = ?   
         <sql:param value = "${cname}" />
      </sql:query>
     
      <sql:query var="rs2" dataSource="${db}">select * from course where fname = ?
         <sql:param value = "${username1}" />  
      </sql:query>
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
                  <h2>Faculty Details</h2>
                  <br>
                  
                  <c:forEach items= "${rs.rows}" var="info">
	                  <b>Name: </b>  <c:out value="${info.name}"></c:out>  <br>
	                  <b>Department: </b>  <c:out value="${info.department}"></c:out>  <br>
	                  <b>Faculty ID: </b>  <c:out value="${info.facultyId}"></c:out>  <br>
	               </c:forEach>
	               
	              <br><br>
	              <h5>Select Course:</h5>
	                 <form action = "SetCourse" method="post">
						 <select name="cname" id="soflow">
						           <option value="Select">Select</option>
						        <c:forEach items= "${rs2.rows}" var="info2">
							       <option value="${info2.name}"> <c:out value="${info2.name}"></c:out> </option>
							    </c:forEach>
					     </select>     
					     <button type="submit" class="btn btn-secondary" value = "Logout" style="padding: 10px">Submit</button>
	                </form>	
	              <br><br>
                  <button class="collapsible">View Student List</button>
                    <div class="content">
                           <table class="table">
                            <thead>
                              <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Roll No.</th>
                                <th scope="col">Classes Attended</th>
                                <th scope="col">Classes Missed</th>
                                <th scope="col">Percentage Attendance</th>
                              </tr>
                            </thead>
                            <tbody>
                              <c:forEach items= "${rs1.rows}" var="info1"> 
			                  <tr>
                                <td> <c:out value="${info1.student_name}"></c:out> </td>
                                <td> <c:out value="${info1.roll}"></c:out> </td>  
                                <td> <c:out value="${info1.attended}"></c:out> </td>
                                <td> <c:out value="${info1.missed}"></c:out> </td>
                                <td> <c:out value="${info1.percentage}"></c:out> </td>
                              </tr>
                              </c:forEach>
                            </tbody>
                      </table>
                    </div>
                <br><br><br><br>
                      <form action="Logout">
                        <button type="submit" class="btn btn-primary" value = "Logout">Log out</button>
                      </form>
                </p>
              </div>
          </div>         
    </body> 
    <script>
    var coll = document.getElementsByClassName("collapsible");
        var i;

        for (i = 0; i < coll.length; i++) {
          coll[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var content = this.nextElementSibling;
            if (content.style.display === "block") {
              content.style.display = "none";
            } else {
              content.style.display = "block";
            }
          });
        }
    </script>
</html>
