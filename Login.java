/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import java.io.IOException;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        if( uname.equals("Nilesh") && pass.equals("1234"))
        {
            
            session.setAttribute("username",uname);
            response.sendRedirect("student.jsp");
        }
        
        else if( uname.equals("Rohit") && pass.equals("5678"))
        {
            session.setAttribute("username1",uname);
            response.sendRedirect("faculty.jsp");
        }
        else
        {
            response.sendRedirect("login.jsp");
        }
    
    }

}

