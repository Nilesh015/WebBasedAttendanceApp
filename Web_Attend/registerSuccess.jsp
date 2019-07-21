<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            position: absolute;
            top: 50%;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            padding: 10px;
            width: 50%;
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
	          <div class="card center shadow-sm p-3 mb-5 bg-white rounded">
               <div class="card-body">
                  <p class="card-text" style="text-align: center">
                     <h2 style="text-align: center">Successfully Registered!</h2>
                      <p style="text-align: center">Go to the main page and Sign in with your new account.</p>
                     <br><br>
                     <form action="login.jsp" style="text-align: center">
                       <button type="submit" class="btn btn-primary" value = "back">Go to Login</button>
                     </form>
              </div>
            </div>
            
	       
	</body>
	</html>