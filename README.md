# Web Based Attendance App  

This project aims to create a web based attendance application which makes use of timer based attendance marking system. The database consists of student details, faculty details, and course details as well. MySQL is used for storing and querying the data. The server side actions are handled with Servlets and JSP, and the frontend is created using JavaScript, HTML and CSS. The use cases of the project include - Register, Student/Faculty Login, View Student Details, View Faculty Details, Mark Attendance, View Attendance, Create Course, Enroll in Course, Start/Stop Timer,etc. 

### Prerequisites

The following are required for running the web based application:  
1) Eclipse IDE  
2) Apache Tomcat (The server)  
3) MySQL (RDBMS)  
3) Some .jar dependencies - mysql-connector-java-8.0.13.jar, taglibs-standard-spec-1.2.5.jar, taglibs-standard-jstlel-1.2.5.jar, taglibs-standard-impl-1.2.5.jar, taglibs-standard-compat-1.2.5.jar  

### Running the WebApp

The following steps must be followed to start the application:  
1) Create a new 'Dynamic Web Project' in Eclipse IDE by the name 'WebAttend'.  
2) Copy the folder 'com' and all the other files in the 'WebAttend' directory given in the repository.  
3) Select Apache Tomcat as the server.  
3) Download and put 'mysql-connector-java-8.0.13.jar' as a Tomcat dependency.  
4) The other .jar files are put as Web App Libraries.  
5) Go to login.jsp, Right click and select Run As --> Run on Server.  

The following page should be displayed:  


```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Features  

Create a student and a faculty account first. Then create some courses in the faculty account, in which the student can enroll. Here is a preview of a student's details page and a faculty's details page:  

To start an attendance session, login as Faculty. Enter course details of the course for which you want to start the attendance. Then click 'Start Timer'. The attendance session gets started and the following page is displayed:  

Then just login as a student and mark the attendance. A successfully attended message shows up in case of success and the attendance is updated.  

