package com.attend;
import java.sql.*;

public class AttendStatusDao {
       
	String url = "jdbc:mysql://localhost:3306/student";
	   String username = "root";
	   String password = "nilesh123";
	   String sql = "update attendance_status set status=1 where uname=? and courseId=? and sem=? and slot=?";
	   String sql1 = "update attendance_status set status=0 where courseId=? and sem=? and slot=?";
	   public void setStatus(String user,String id, String semester,String slot)
	   {
	       try
	       {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url,username,password);
	            PreparedStatement st1 = con.prepareStatement(sql);
	            st1.setString(1,user);
	            st1.setString(2,id);
	            st1.setString(3,semester);
	            st1.setString(4,slot);
	            
	            st1.executeUpdate();
	            
	            st1.close();
	            con.close();
	       }
	       catch(ClassNotFoundException | SQLException e)
	       {
	         e.printStackTrace();
	       }
	   }
	   public void clearStatus(String id, String semester,String slot)
	   {
	       try
	       {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url,username,password);
	            PreparedStatement st1 = con.prepareStatement(sql1);
	            st1.setString(1,id);
	            st1.setString(2,semester);
	            st1.setString(3,slot);
	            
	            st1.executeUpdate();
	            
	            st1.close();
	            con.close();
	       }
	       catch(ClassNotFoundException | SQLException e)
	       {
	         e.printStackTrace();
	       }
	   }

}
