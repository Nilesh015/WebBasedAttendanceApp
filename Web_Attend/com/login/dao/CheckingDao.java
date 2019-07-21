package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckingDao {
	   String url = "jdbc:mysql://localhost:3306/student";
	   String username = "root";
	   String password = "nilesh123";
	   String sql = "select * from student_course_data where course_name=? and courseId=? and sem=? and slot=? and uname=?";
	   String sql1 = "select * from course where courseId=? and sem=? and slot=?";
	   
	   String sql2 = "select * from student_data where rollno=?";
	   String sql3 = "select * from faculty_data where facultyId=?";
	   
	   String sql4 = "select * from student_data where Username=?";
	   String sql5 = "select * from faculty_data where Username=?";
	   
	   //To check if enrolled already
	   public int enrollCheck(String course_name,String courseId,String sem,String slot,String uname)
	   {
	       try
	       {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url,username,password);
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1,course_name);
	            st.setString(2,courseId);
	            st.setString(3,sem);
	            st.setString(4,slot);
	            st.setString(5,uname);
	            
	            ResultSet rs = st.executeQuery();
	            
	            if(rs.next())
	            {
	            	 //Already enrolled
		             return 1;
	            }
	       }
	       catch(Exception e)
	       {
	         e.printStackTrace();
	       }
	       return 0;
	   }
	   
	   //To check if registered already
	   public int registerCheck(String roll,String Username,String type)
	   {
	       try
	       {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url,username,password);
	            PreparedStatement st = con.prepareStatement(sql2);
	            st.setString(1,roll);   
                
	            PreparedStatement st1 = con.prepareStatement(sql3);
	            st1.setString(1,roll);  
	            
	            PreparedStatement st2 = con.prepareStatement(sql4);
	            st2.setString(1,Username);
	            
	            PreparedStatement st3 = con.prepareStatement(sql5);
	 	        st3.setString(1,Username); 
	 	         
	            ResultSet rs;
	            ResultSet rs1 = st2.executeQuery(); ;
	            ResultSet rs2 = st3.executeQuery();
	            
	            if(type.equals("S"))
	            {
	            	 rs = st.executeQuery(); 
	            }
	            else
	                { 
	            	   rs = st1.executeQuery();  
	                }
	            
	            if(rs.next()||rs1.next()||rs2.next())
	            {
	            	 //Already registered
		             return 1;
	            }
	       }
	       catch(Exception e)
	       {
	         e.printStackTrace();
	       }
	       return 0;
	   }
	   
	 //To check if created already
	   public int createCheck(String courseId,String sem,String slot)
	   {
	       try
	       {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url,username,password);
	            PreparedStatement st = con.prepareStatement(sql1);
	            st.setString(1,courseId);
	            st.setString(2,sem);
	            st.setString(3,slot);
	            
	            ResultSet rs = st.executeQuery();
	            
	            if(rs.next())
	            {
	            	 //Already created
		             return 1;
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
	      CheckingDao d = new CheckingDao();
	      if(d.registerCheck("17CS100310","Nilesh","F") == 1)
	          System.out.print("There");
	      else
	    	  System.out.print("Not There");
	   }
	}

