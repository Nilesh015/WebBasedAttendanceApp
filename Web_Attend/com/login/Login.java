/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;


import java.sql.*;

import com.login.dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import JFrames.LoginFailed;
/**
 *
 * @author Hp
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    public Login()
    {
       super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        //session.removeAttribute("username");
        LoginDao dao = new LoginDao();
        if( dao.check(uname,pass) == 1)
        {   
            session.setAttribute("username",uname);
            response.sendRedirect("student.jsp");
        }
        
        else if( dao.check(uname,pass) == 2)
        {
            session.setAttribute("username1",uname);
            session.setAttribute("cname","");
            response.sendRedirect("faculty.jsp");
        }
        else
        {      
        	   out.println("<script type=\"text/javascript\">");
        	   out.println("alert('Username or password incorrect');");
        	   out.println("location='login.jsp';");
        	   out.println("</script>");
        	 
        }
    
    }
}

