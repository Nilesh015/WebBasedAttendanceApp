/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.register;

import com.login.dao.CheckingDao;
import com.login.dao.RegisterDao;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import JFrames.registersuccess;
import JFrames.registerfailure;
/**
 *
 * @author Hp
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String department = request.getParameter("dep");
        
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        
        String type = request.getParameter("type");
        
        HttpSession session = request.getSession();
        //session.removeAttribute("username");
        CheckingDao cd = new CheckingDao();
        if(cd.registerCheck(roll, uname, type) == 1)
        	{
		          out.println("<script type=\"text/javascript\">");
		   	      out.println("alert('Either username or roll no already used');");
		   	      out.println("location='register.jsp';");
		   	      out.println("</script>");
        	}
        else 
        {
        	RegisterDao dao = new RegisterDao();
            dao.insertData(name,roll,department,uname,pass,type);
            response.sendRedirect("registerSuccess.jsp");	
        }
    }    
}
