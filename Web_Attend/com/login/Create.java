/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import com.login.dao.CheckingDao;
import com.login.dao.CreateDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JFrames.AddCourseFailure;
import JFrames.AddCourseSuccess;

/**
 *
 * @author Rohit Pathak
 */
@WebServlet(name = "Create", urlPatterns = {"/Create"})
public class Create extends HttpServlet {

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
        
        String type = request.getParameter("type");
        
       
        HttpSession session = request.getSession();
        String fname = (String)session.getAttribute("username1");
        //session.removeAttribute("username");
        
        CheckingDao cd = new CheckingDao();
        if(cd.createCheck(id, semester, slot) == 1)
        	{
    	      out.println("<script type=\"text/javascript\">");
     	      out.println("alert('Course Already Created');");
     	      out.println("location='create.jsp';");
     	      out.println("</script>");
        	}
        else 
        {
        	CreateDao dao = new CreateDao();
            dao.createData(name,id,semester,slot,fname);
            response.sendRedirect("createSuccess.jsp");	
        }	
    }    
}
