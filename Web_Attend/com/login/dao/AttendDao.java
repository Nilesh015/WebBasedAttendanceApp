package com.login.dao;
import java.sql.*;

public class AttendDao {
	
	String url = "jdbc:mysql://localhost:3306/student";
	String username = "root";
	String password = "nilesh123";
	String query = "select * from start_attendance where courseId=? and sem=? and slot=? and pin=?";
	String query1 = "select * from course where courseId=? and sem=? and slot=? and fname=?";
	public int check(String courseId, String sem,String slot,int time,String pin)
	   {
	       try
	       {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url,username,password);
	        	PreparedStatement st = con.prepareStatement(query);
	            st.setString(1, courseId);
	            st.setString(2, sem);
	            st.setString(3, slot);
	            st.setString(4, pin);
	            
	            ResultSet rs = st.executeQuery();
	            if(rs.next() && (time <= rs.getInt("endTime")))
	            {
		            return 1;
	            }
	       }
	       catch(ClassNotFoundException | SQLException e)
	       {
	         e.printStackTrace();
	       }
	       return 0;
	   }
	
	public int checkExistence(String courseId, String sem,String slot,String fname)
	   {
	       try
	       {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url,username,password);
	        	PreparedStatement st = con.prepareStatement(query1);
	            st.setString(1, courseId);
	            st.setString(2, sem);
	            st.setString(3, slot);
	            st.setString(4, fname);
	            
	            ResultSet rs = st.executeQuery();
	            if(rs.next())
	            {
		            return 1;
	            }
	       }
	       catch(ClassNotFoundException | SQLException e)
	       {
	         e.printStackTrace();
	       }
	       return 0;
	   }
}
