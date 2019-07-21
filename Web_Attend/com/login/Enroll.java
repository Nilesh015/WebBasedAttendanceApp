/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import com.login.dao.CheckingDao;
import com.login.dao.EnrollDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import JFrames.EnrollFailed;
import JFrames.EnrollSuccess;

/**
 *
 * @author Rohit Pathak
 */
@WebServlet(name = "Enroll", urlPatterns = {"/Enroll"})
public class Enroll extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        	PrintWriter out = response.getWriter();
        String name = request.getParameter("CourseName");	
        String id = request.getParameter("CourseId");
        String semester = request.getParameter("Semester");
        String slot = request.getParameter("Slot");
               
        HttpSession session = request.getSession();
        String user = (String)session.getAttribute("username");
        //session.removeAttribute("username");

        EnrollDao dao = new EnrollDao();
        
        if(dao.checkData(name, id, semester, slot) == 1)
          {
        	CheckingDao cd = new CheckingDao();
        	if(cd.enrollCheck(name, id, semester, slot, user) == 1)
        		{
        		  out.println("<script type=\"text/javascript\">");
   	     	      out.println("alert('You are Already Enrolled');");
   	     	      out.println("location='enroll.jsp';");
   	     	      out.println("</script>");
        		}
        	else
        	  {
        		dao.addCourseToStudent(user,name,id,semester,slot);
            	dao.updateMaster(user,name,id,semester,slot);
            	dao.updateStatus(user, name, id, semester, slot);
                response.sendRedirect("enrollSuccess.jsp");	
        	  }	
          }
        else
        	{
	           out.println("<script type=\"text/javascript\">");
	     	   out.println("alert('Incorrect data');");
	     	   out.println("location='enroll.jsp';");
	     	   out.println("</script>");
        	}
    }    
}
