/* delete rows*/ 

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class deladdrb extends HttpServlet
 {
  public static Connection dbconn;
  public static Statement stmt;
   PrintWriter pw=null;
int j;
  public void doGet(HttpServletRequest rq, HttpServletResponse rs) 
  throws IOException,ServletException
   {
    try
     {
      String idn[]=rq.getParameterValues("c");/*checkbox name=c: that value is stored in DN[]*/
      Class.forName("oracle.jdbc.driver.OracleDriver");


      dbconn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
      stmt=dbconn.createStatement();
RequestDispatcher rd;
    pw=rs.getWriter();
     
      pw.println("<br>length"+idn.length);
      for(int i=0;i<idn.length;i++)   
      {
       String sql="delete from addressbook where id='"+idn[i]+"'"; 
       j=stmt.executeUpdate(sql);
rd= rq.getRequestDispatcher("welcomebodyad.html");
           rd.forward(rq,rs); 
      
      }
     stmt.close();
     dbconn.close();
     }
    catch(Exception e)
     {
      pw.println("<html><body background=\'E:/Tomcat/webapps/WebBasedMail/images/tile_ragged_edge_bubbles.gif\'>");
      pw.println("<p align=center>&nbsp;</p>");
      pw.println("<p align=center>&nbsp;</p><p align=center>&nbsp;</p>");
      pw.println("<p align=center>&nbsp;</p><table border=0 width=100%>");
      pw.println("<tr><td width=100%><p align=center><font face=arial");
      pw.println("color=red face=arial size=4><b>Please select the messages for deleting/empty Inbox!</b></font></td></tr></table>");
      pw.println("<center><IMG src='E:/Tomcat/webapps/WebBasedMail/images/Ani24.gif' width=100 height=100></center>");
      pw.println("</body></html>");
     }
    }
   }