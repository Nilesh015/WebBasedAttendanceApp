# Web Based Attendance App  

This project aims to create a web based attendance application which makes use of timer based attendance marking system. The database consists of student details, faculty details, and course details as well. MySQL is used for storing and querying the data. The server side actions are handled with Servlets and JSP, and the frontend is created using JavaScript, HTML and CSS. The use cases of the project include - Register, Student/Faculty Login, View Student Details, View Faculty Details, Mark Attendance, View Attendance, Create Course, Enroll in Course, Start/Stop Timer,etc. 

### Prerequisites

The following are required for running the web based application:  
1) Eclipse IDE  
2) Apache Tomcat (The server)  
3) MySQL (RDBMS)  
3) Some .jar dependencies - mysql-connector-java-8.0.13.jar, taglibs-standard-spec-1.2.5.jar, taglibs-standard-jstlel-1.2.5.jar, taglibs-standard-impl-1.2.5.jar, taglibs-standard-compat-1.2.5.jar  

### Running the WebApp

Follow all instructions in the instructions.txt file.  
The following steps must be followed to start the application:  
1) Open project in Eclipse IDE.   
2) Go to login.jsp, Right click and select Run As --> Run on Server.  

The following page should be displayed:  

![Image could not be displayed](https://github.com/Nilesh015/WebBasedAttendanceApp/blob/master/Web_Attend/login_page.jpg)  

## Features  

Create a student and a faculty account first. Then create some courses in the faculty account, in which the student can enroll. Here is a preview of a student's details page and a faculty's details page:  

Student Details Page:  
![Image could not be displayed](https://github.com/Nilesh015/WebBasedAttendanceApp/blob/master/Web_Attend/student_page.jpg)

Faculty Details Page:  
![Image could not be displayed](https://github.com/Nilesh015/WebBasedAttendanceApp/blob/master/Web_Attend/faculty_page.jpg)  

To start an attendance session, login as Faculty. Enter course details of the course for which you want to start the attendance. Then click 'Start Timer'. The attendance session gets started and the following page is displayed:  

![Image could not be displayed](https://github.com/Nilesh015/WebBasedAttendanceApp/blob/master/Web_Attend/timer_page.jpg)  

Then just login as a student and mark the attendance. A successfully attended message shows up in case of success and the attendance is updated.  

