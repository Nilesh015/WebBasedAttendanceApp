/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startattend;

import com.login.dao.AttendDao;
import com.login.dao.StartattendDao;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hp
 */
@WebServlet(name = "startattend", urlPatterns = {"/startattend"})
public class startattend extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Handles the HTTP <code>POST</code> method.
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
    	String courseId = request.getParameter("CourseId");
		String slot = request.getParameter("Slot");
		String sem = request.getParameter("Sem");
		
		int PIN = (int)(Math.floor(100000 + Math.random() * 900000));
		String pin = String.valueOf(PIN);
		HttpSession session = request.getSession();
        String user = (String)session.getAttribute("username1");
		
        int endTime = (int)( (System.currentTimeMillis() ) % 1000000000 + (5*60*1000));
        AttendDao ad = new AttendDao();
        
        if(ad.checkExistence(courseId, sem, slot,user) == 1)
        {
        	session.setAttribute("courseId",courseId);
            session.setAttribute("slot",slot);
            session.setAttribute("sem",sem);
            session.setAttribute("Pin", pin);
            session.setAttribute("started", "s");
            
    		StartattendDao dao = new StartattendDao();
    		dao.insertData(courseId,sem,slot,user,endTime,pin);	
    		response.sendRedirect("timer.jsp");
        }
        else
        	{
        	   out.println("<script type=\"text/javascript\">");
	   	       out.println("alert('Incorrect course details');");
	   	       out.println("location='startattend.jsp';");
	   	       out.println("</script>");
        	}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
