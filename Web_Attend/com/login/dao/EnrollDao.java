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
public class EnrollDao {
    
   String url = "jdbc:mysql://localhost:3306/student";
   String username = "root";
   String password = "nilesh123";
   String sql = "select * from course where name=? and courseId=? and sem=? and slot=?";
   String sql2 = "select * from student_data where Username = ?";
   String sql3 = "select * from student_course_data where course_name = ? and courseId = ? and sem = ? and slot = ? and uname =?";
   String sql4 = "insert into master_student (student_name,roll,course_name,courseId,sem,slot,attended,missed,percentage,uname) values (?,?,?,?,?,?,?,?,?,?)";
   
   public int checkData(String name,String id, String semester,String slot)
   {
	   try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,name);
            st.setString(2,id);
            st.setString(3,semester);
            st.setString(4,slot);
            
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
	            return 1;
            }
       }
       catch(Exception e)
       {
         e.printStackTrace();
       }
       return 0;
   }
   
   public void addCourseToStudent(String user,String name,String id, String semester,String slot)
   {
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String sql1 = "insert into student_course_data (course_name,courseId,sem,slot,attended,missed,percentage,uname) values ('"+name+"','"+id+"','"+semester+"','"+slot+"',0,0,0.0,'"+user+"')";
            
            Statement st1 = con.createStatement();
            st1.executeUpdate(sql1);
            st1.close();
            con.close();
       }
       catch(ClassNotFoundException | SQLException e)
       {
         e.printStackTrace();
       }
   }
   
   public void updateMaster(String user,String name,String id, String semester,String Slot)
   {
	   try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(sql2);
            PreparedStatement st1 = con.prepareStatement(sql3);
            PreparedStatement st2 = con.prepareStatement(sql4);
            
            st.setString(1,user);
            
            st1.setString(1,name);
            st1.setString(2,id);
            st1.setString(3,semester);
            st1.setString(4,Slot);
            st1.setString(5,user);
            
            
            ResultSet rs = st.executeQuery();
            ResultSet rs1 = st1.executeQuery();
            
            rs.next();
            String student_name = rs.getString("name");
            String roll = rs.getString("rollno");
            
            rs1.next();
            
            String course_name = rs1.getString("course_name");
            String courseId = rs1.getString("courseId");
            String sem = rs1.getString("sem");
            String slot = rs1.getString("slot");
            String attended = rs1.getString("attended");
            String missed = rs1.getString("missed");
            String percentage = rs1.getString("percentage");
            String uname = rs1.getString("uname");
                
            st2.setString(1,student_name);
            st2.setString(2,roll);
            st2.setString(3,course_name);
            st2.setString(4,courseId);
            st2.setString(5,sem);
            st2.setString(6,slot);
            st2.setString(7,attended);
            st2.setString(8,missed);
            st2.setString(9,percentage);
            st2.setString(10,uname);
            
            st2.executeUpdate();
                    
            st.close();
            st1.close();
            st2.close();
            con.close();
       }
       catch(ClassNotFoundException | SQLException e)
       {
         e.printStackTrace();
       }
   }
   
   public void updateStatus(String user,String name,String id, String semester,String slot)
   {
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String sql5 = "insert into attendance_status (uname,course_name,courseId,sem,slot,status) values (?,?,?,?,?,0)";
            
            PreparedStatement st1 = con.prepareStatement(sql5);
            st1.setString(1,user);
            st1.setString(2,name);
            st1.setString(3,id);
            st1.setString(4,semester);
            st1.setString(5,slot);
            
            st1.executeUpdate();
            
            st1.close();
            con.close();
       }
       catch(ClassNotFoundException | SQLException e)
       {
         e.printStackTrace();
       }
   }
   
   public static void main(String args[])throws Exception
   {
      EnrollDao d = new EnrollDao();
      //d.addCourseToStudent("Nilesh","Software Engineering","CS20006","Spring","G");
      //d.updateMaster("Nilesh","Software Engineering","CS20006","Spring","G");
      d.updateStatus("Nilesh","Software Engineering","CS20006","Spring","G");
   }
}
