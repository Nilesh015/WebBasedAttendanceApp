/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attend;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.TimerDao;

/**
 *
 * @author Hp
 */
@WebServlet(name = "Confirm", urlPatterns = {"/Confirm"})
public class Confirm extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        //session.removeAttribute("username");
        String courseId = (String)session.getAttribute("courseId");
        String sem = (String)session.getAttribute("sem");
        String slot = (String)session.getAttribute("slot");
        String user = (String)session.getAttribute("username1");
        
        ConfirmDao cd = new ConfirmDao();
        cd.updateAttendance(courseId, sem, slot);
        
        AttendStatusDao asd = new AttendStatusDao();
        asd.clearStatus(courseId, sem, slot);
        
        TimerDao td = new TimerDao();
        td.deleteData(user);
        
        session.removeAttribute("courseId");
        session.removeAttribute("sem");
        session.removeAttribute("slot");
        session.removeAttribute("Pin");
        
        response.sendRedirect("faculty.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

}
