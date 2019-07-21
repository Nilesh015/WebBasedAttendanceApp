/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.dao;
import java.sql.*;

/**
 *
 * @author Rohit Pathak
 */
public class CreateDao {
   String url = "jdbc:mysql://localhost:3306/student";
   String username = "root";
   String password = "nilesh123";
   String lsql = "insert into course(name,courseId,sem,slot,fname) values(?,?,?,?,?)";
   
   public void createData(String name,String id, String semester,String slot,String fname)
   {
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            
            	
            PreparedStatement st = con.prepareStatement(lsql);
            st.setString(1,name);
            st.setString(2,id);
            st.setString(3,semester);
            st.setString(4,slot);
            st.setString(5,fname);
            
            st.executeUpdate(); 
            st.close();
        
            con.close();
       }
       catch(ClassNotFoundException | SQLException e)
       {
         e.printStackTrace();
       }
   }
   
   public static void main(String args[])throws Exception
   {
      CreateDao d = new CreateDao();
      d.createData("Software Engineering","CS2006","Spring","G","Rohit");
   }
}
