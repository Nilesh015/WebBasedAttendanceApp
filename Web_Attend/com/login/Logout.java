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

import com.attend.AttendStatusDao;
import com.attend.ConfirmDao;
import com.login.dao.TimerDao;

/**
 *
 * @author Hp
 */
@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        //session.removeAttribute("username");
        String courseId = (String)session.getAttribute("courseId");
        String sem = (String)session.getAttribute("sem");
        String slot = (String)session.getAttribute("slot");
        String user = (String)session.getAttribute("username1");
        
        AttendStatusDao asd = new AttendStatusDao();
        asd.clearStatus(courseId, sem, slot);
        
        TimerDao td = new TimerDao();
        td.deleteData(user);
        
        session.removeAttribute("courseId");
        session.removeAttribute("sem");
        session.removeAttribute("slot");
        session.removeAttribute("Pin");
        session.removeAttribute("username");
        session.removeAttribute("username1");
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

}

