package com.login.dao;
import java.io.IOException;
import java.sql.*;

public class TimerDao {
	String url = "jdbc:mysql://localhost:3306/student";
	String username = "root";
	String password = "nilesh123";

	String query = "delete from start_attendance where username=?";
	
	public void deleteData(String user)
	   {
	       try
	       {
	    	    Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url,username,password);
	        	PreparedStatement st = con.prepareStatement(query);
	            st.setString(1, user);
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
	   TimerDao td = new TimerDao();
	   td.deleteData("Rohit");
	}
}
