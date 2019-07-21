package com.login.dao;
import java.io.IOException;
import java.sql.*;



public class StartattendDao {
	String url = "jdbc:mysql://localhost:3306/student";
	String username = "root";
	String password = "nilesh123";
	String query = "insert into start_attendance (courseId,sem,slot,username,endTime,pin) values (?,?,?,?,?,?)";
	
	public void insertData(String courseId, String sem,String slot,String user,int endTime,String pin)
	   {
	       try
	       {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url,username,password);
	        	PreparedStatement st = con.prepareStatement(query);
	            
	        	st.setString(1, courseId);
	            st.setString(2, sem);
	            st.setString(3, slot);
	            st.setString(4, user);
	            st.setInt(5, endTime);
	            st.setString(6, pin);
	            
	            st.executeUpdate(); 
	            st.close();
	        
	            con.close();
	       }
	       catch(ClassNotFoundException | SQLException e)
	       {
	         e.printStackTrace();
	       }
	   }
	
	public static void main(String args[])throws IOException
	{
	   StartattendDao sd = new StartattendDao();
	   sd.insertData("CS20006","Spring","G","Rohit",86400000*7,"667662");
	}
}
