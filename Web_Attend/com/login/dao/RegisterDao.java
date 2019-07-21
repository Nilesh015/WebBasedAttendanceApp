/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.dao;
import java.sql.*;
/**
 *
 * @author Hp
 */
public class RegisterDao 
{
   
   String url = "jdbc:mysql://localhost:3306/student";
   String username = "root";
   String password = "nilesh123";
   String sql = "insert into student_data (name,rollno,department,Username) values (?,?,?,?)";
   String sql1 = "insert into faculty_data (name,facultyId,department,Username) values (?,?,?,?)";
   
   String logsql = "insert into login (uname,pass,type) values (?,?,?)";
   
   public void insertData(String name, String roll,String department,String uname,String pass,String type)
   {
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            if(type.equals("S"))
            {
            	PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1,name);
	            st.setString(2,roll);
	            st.setString(3,department);
	            st.setString(4,uname);
	            st.executeUpdate(); 
	            st.close();
	        }
            
            else if(type.equals("F"))
            {
            	PreparedStatement st = con.prepareStatement(sql1);
	            st.setString(1,name);
	            st.setString(2,roll);
	            st.setString(3,department);
	            st.setString(4,uname);
	            st.executeUpdate(); 
	            st.close();
	        }
            	
        	PreparedStatement st = con.prepareStatement(logsql);
            st.setString(1,uname);
            st.setString(2,pass);
            st.setString(3,type);
            st.executeUpdate(); 
            st.close();
        
            con.close();
       }
       catch(ClassNotFoundException | SQLException e)
       {
         e.printStackTrace();
       }
   }
}
