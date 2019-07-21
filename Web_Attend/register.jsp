<%-- 
    Document   : login
    Created on : 27 Mar, 2019, 1:11:17 PM
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
        <title>Attendance App</title>
    <h1 class = "appname">WEB-BASED ATTENDANCE APP</h1>
    </head>
    
    <style>
        .appname{
            background-image: linear-gradient(to right, rgba(174, 182, 191,1), rgba(174, 182, 191,0));
            padding-left: 20px;
            width: 70%;
            font-family: sans-serif;
            font-size: 400%;
            font-style: italic;
        }
        .center{
            margin: auto;
            position: absolute;
            top: 50%;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            padding: 5px;
            width: 50%;
           }
        .bg{
            /* The image used */
            
            background-image: url("back1.jpg");
            /* Full height */
            height: 100%; 
            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
    <body style="background-color: rgba(255,0,0,0)">
         <div class="card center shadow p-3 mb-5 bg-white rounded">
               <div class="card-body">
                   <h2>Register</h2><br> <br>
                   <form action="Register" method="post">
                      <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" id="inputName" placeholder="Enter Full Name" name = "name" required>
                      </div>
                      
                      <div class="form-row">
                            <div class="form-group col-md-5">
                              <label>Roll No/Faculty Id</label>
                              <input type="text" class="form-control" id="inputRollno" placeholder="Enter Roll No./Faculty Id" name="roll" required>
                            </div>
                            <div class="form-group col-md-7">
                              <label>Department</label>
                              <input type="text" class="form-control" id="inputDepartment" placeholder="Enter Department" name="dep" required>
                            </div>
                     </div>
                      <div class="form-row">
                        <div class="form-group col-md-6">
                          <label>Username</label>
                          <input type="text" class="form-control" id="inputUsername" placeholder="Enter username E.g - John123" name="uname" required>
                        </div>
                        <div class="form-group col-md-6">
                          <label>Password</label>
                          <input type="password" class="form-control" id="inputPassword" placeholder="Enter Password" name="pass" required>
                        </div>
                      </div>
                        <div class="control">
							  <label class="radio">
							    <input type="radio" name="type" value = "S" checked>
							      Student
							  </label>
							  <label class="radio">
							    <input type="radio" name="type" value = "F">
							      Faculty
							  </label>
						</div>
                       <br>
                        <button type="submit" class="btn btn-primary" style="float: left">Register</button>
                   
                    </form>
                        <form action="login.jsp">
                             <button type="submit" class="btn btn-primary" value="login" style="margin-left: 10px">Back to Login</button>
                   </form>
               </div>
  
         </div>
     
         
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
    
</html>
