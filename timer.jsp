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
    </head>
    <style>
        
        .center{
            margin: auto;
            position: absolute;
            top: 50%;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            height: 90%;
            width: 70%;
           }
        .bg{
            /* The image used */
            
            background-color: rgba(0,0,0,0.1);
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
              <h5 class="card-header">Faculty Page</h5>  
            <div class="card-body">
              <p class="card-text">
                  <h2>Timer Running!</h2>
                  <br>
                      <h1 id="demo"></h1>
                      <br>
                  <form action="faculty.jsp">
                        <button type="submit" class="btn btn-primary" value = "faculty">Stop Timer</button>
                  </form>
                   <br><br><br><br><br><br><br><br><br><br><br><br>
                  <form action="Logout">
                       <button type="submit" class="btn btn-primary" value = "Logout">Log out</button>
                  </form>
              </p>
            </div>
        </div>         
    </body> 
    <script>
// Update the count down every 1 second
  var start = new Date().getTime();    
  var x = setInterval(function() {
  var s = 5*60*1000;
  var now = new Date().getTime();
  var distance = (s+start) - now;
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
  // Output the result in an element with id="demo"
  document.getElementById("demo").innerHTML = minutes + "m " + seconds + "s ";
    
  // If the count down is over, write some text 
  if (distance < 0) {
    clearInterval(x);
    document.getElementById("demo").innerHTML = "EXPIRED";
  }
}, 1000);
</script>
</html>
