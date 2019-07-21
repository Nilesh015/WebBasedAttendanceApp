package com.timer;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.AttendDao;
import com.login.dao.StartattendDao;
import com.login.dao.TimerDao;
/**
 * Servlet implementation class Timer
 */
@WebServlet("/Timer")
public class Timer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Timer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//For STOP timer
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
        String user = (String)session.getAttribute("username1");
        String courseId = (String)session.getAttribute("courseId");
        String sem = (String)session.getAttribute("sem");
        String slot = (String)session.getAttribute("slot");
		
        TimerDao dao = new TimerDao();
		dao.deleteData(user);
		
		int endTime = (int)( (System.currentTimeMillis() ) % 1000000000 + (5*60*1000));
		int PIN = (int)(Math.floor(100000 + Math.random() * 900000));
		String pin = String.valueOf(PIN);
		
		session.setAttribute("Pin", pin);
		AttendDao ad = new AttendDao();
		if(ad.checkExistence(courseId, sem, slot,user) == 1)
        {
    		StartattendDao sd = new StartattendDao();
    		sd.insertData(courseId,sem,slot,user,endTime,pin);	
    		out.println("<script type=\"text/javascript\">");
  	        out.println("alert('Timer Restarted');");
  	        out.println("location='timer.jsp';");
  	        out.println("</script>");
        }	
		else
			response.sendRedirect("startattend.jsp");
	}

}
