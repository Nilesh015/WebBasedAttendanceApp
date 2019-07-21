/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attend;
import java.io.IOException;
import java.sql.*;
/**
 *
 * @author Hp
 */
public class ConfirmDao {
   String url = "jdbc:mysql://localhost:3306/student";
   String username = "root";
   String password = "nilesh123";
   String sql = "select * from attendance_status where courseId=? and sem=? and slot=?";
   String sql0 = "select * from master_student where uname=? and courseId=? and sem=? and slot=?";
   String sql1 = "update master_student set attended=? where uname=? and courseId=? and sem=? and slot=?";
   String sql2 = "update master_student set missed=? where uname=? and courseId=? and sem=? and slot=?";
   String sql3 = "update master_student set percentage=? where uname=? and courseId=? and sem=? and slot=?";
   
   String sql4 = "update student_course_data set attended=? where uname=? and courseId=? and sem=? and slot=?";
   String sql5 = "update student_course_data set missed=? where uname=? and courseId=? and sem=? and slot=?";
   String sql6 = "update student_course_data set percentage=? where uname=? and courseId=? and sem=? and slot=?";
        
   public void updateAttendance(String courseId,String sem,String slot)
   {
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, courseId);
            st.setString(2, sem);
            st.setString(3, slot);
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
            	String uname = rs.getString("uname");
	            int status = rs.getInt("status");
	            
	            PreparedStatement st0 = con.prepareStatement(sql0);
	            st0.setString(1, uname);
	            st0.setString(2, courseId);
	            st0.setString(3, sem);
	            st0.setString(4, slot);
	            
	            ResultSet rs0 = st0.executeQuery();
	            rs0.next();
	            int attended = rs0.getInt("attended");
	            int missed = rs0.getInt("missed");
	            double percentage = rs0.getDouble("percentage");
	            
	            if(status == 1)
	                    attended = attended + 1;
	            else
	                     missed = missed + 1;
	            System.out.println(attended+","+missed);
	            
	            percentage = (attended*1.0)/(attended + missed) * 100.0;
	            
	            PreparedStatement st1 = con.prepareStatement(sql1);
	            st1.setInt(1, attended);
	            st1.setString(2, uname);
	            st1.setString(3, courseId);
	            st1.setString(4, sem);
	            st1.setString(5, slot);
	            st1.executeUpdate();
	            
	            PreparedStatement st2 = con.prepareStatement(sql2);
	            st2.setInt(1, missed);
	            st2.setString(2, uname);
	            st2.setString(3, courseId);
	            st2.setString(4, sem);
	            st2.setString(5, slot);
	            st2.executeUpdate();
	            
	            PreparedStatement st3 = con.prepareStatement(sql3);
	            st3.setDouble(1, percentage);
	            st3.setString(2, uname);
	            st3.setString(3, courseId);
	            st3.setString(4, sem);
	            st3.setString(5, slot);
	            st3.executeUpdate();
	            
	            PreparedStatement st4 = con.prepareStatement(sql4);
	            st4.setInt(1, attended);
	            st4.setString(2, uname);
	            st4.setString(3, courseId);
	            st4.setString(4, sem);
	            st4.setString(5, slot);
	            st4.executeUpdate();
	            
	            PreparedStatement st5 = con.prepareStatement(sql5);
	            st5.setInt(1, missed);
	            st5.setString(2, uname);
	            st5.setString(3, courseId);
	            st5.setString(4, sem);
	            st5.setString(5, slot);
	            st5.executeUpdate();
	            
	            PreparedStatement st6= con.prepareStatement(sql6);
	            st6.setDouble(1, percentage);
	            st6.setString(2, uname);
	            st6.setString(3, courseId);
	            st6.setString(4, sem);
	            st6.setString(5, slot);
                st6.executeUpdate();
                
	            st0.close();
	            st1.close();
	            st2.close();
	            st3.close();
	            st4.close();
	            st5.close();
	            st6.close();
	            
            }    
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
          ConfirmDao cod = new ConfirmDao();
          cod.updateAttendance("CS20006","Spring","G");
   }

}
