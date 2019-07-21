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
public class LoginDao
{
   String url = "jdbc:mysql://localhost:3306/student";
   String username = "root";
   String password = "nilesh123";
   String sql = "select * from login where uname=? and pass=?";
        
   public int check(String uname, String pass)
   {
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,uname);
            st.setString(2,pass);
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
	            if(rs.getString("type").equals("S") ) //If there is such a record
	            {
	                return 1;
	            }
	            
	            else if(rs.getString("type").equals("F") ) //If there is such a record
	            {
	                return 2;
	            }
            }
       }
       catch(Exception e)
       {
         e.printStackTrace();
       }
       return 0;
   }
   public static void main(String args[])throws Exception
   {
      LoginDao d = new LoginDao();
      if(d.check("Rohita","5678") == 2)
          System.out.print("ABC");
      else
    	  System.out.print("DEF");
   }
}
