package com.attend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JFrames.AttendFailed;
import JFrames.AttendSuccess;
import com.login.dao.AttendDao;
/**
 * Servlet implementation class Attend
 */
@WebServlet("/Attend")
public class Attend extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Attend() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String courseId = request.getParameter("courseId");
		String slot = request.getParameter("slot");
		String sem = request.getParameter("sem");
		String pin = request.getParameter("pin");
		
		
		HttpSession session = request.getSession();
        String user = (String)session.getAttribute("username");
        
        int time = (int)( (System.currentTimeMillis() ) % 1000000000 );
		AttendDao dao = new AttendDao();
		AttendStatusDao asd = new AttendStatusDao();
		
		if(dao.check(courseId, sem, slot,time,pin)==1)
		{
			asd.setStatus(user, courseId, sem, slot);
			response.sendRedirect("success.jsp");
		}
		else {
			   out.println("<script type=\"text/javascript\">");
	     	   out.println("alert('Failed to attend');");
	     	   out.println("location='attend.jsp';");
	     	   out.println("</script>");
		}	
	}

}
