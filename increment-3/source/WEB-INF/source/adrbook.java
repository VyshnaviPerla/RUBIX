/* view multiple row address book*/

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.text.*;
public class adrbook extends HttpServlet
 {
  Connection con=null; 
   Statement stmt1=null;
    PrintWriter pw=null;
   HttpSession ses=null;
   public void doGet(HttpServletRequest    req,HttpServletResponse res)throws    IOException,ServletException
    {
     try
      {
       Class.forName("oracle.jdbc.driver.OracleDriver");
      pw =res.getWriter();
       con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
       Statement stmt1 = con.createStatement();

       String name="";
       java.util.Date d = new java.util.Date();
       String dd=" ";
       ses=req.getSession();
       if(d.getDate()<10)
        dd +="0"+d.getDate();
       else
        dd +=d.getDate();
       if(d.getMonth()<10)
        dd+="/"+"0"+(d.getMonth()+1);
       else
        dd+="/"+(d.getMonth()+1);
       dd+="/"+(d.getYear()+1900);
        res.setContentType("text/html");
        pw.println("<html>");
        res.setContentType("text/html");
        pw.println("<html>");
        pw.println("<body bgcolor=\'#fbcc7d\' background=\'E:/Tomcat/webapps/WebBasedMail/images/tile_ragged_edge_bubbles.gif\' alink=black vlink=black link=black>");
        ResultSet rset1 = stmt1.executeQuery("select * from addressbook where         USERNAME='"+ses.getAttribute("user")+"'");
        pw.println("<input type=hidden name=user value="+ses.getAttribute("user")+">");
         pw.println("<center><table  background='E:/Tomcat/webapps/WebBasedMail/images/bg3.gif' width=40% height=20%><tr><td><b><font color='darkblue'><h1>"+ses.getAttribute("user")+" 's Addressbook</h1></td></tr>");
            pw.println("<tr><td><hr color=\'black\'></td></tr><center></table>");
        pw.println("<center><table bgcolor=white border=0 ><tr>");
        pw.println("<th bgcolor=white><font face=arial color=darkblue size=3>Select</font></th>");
        pw.println("<th bgcolor=white><font face=arial color=darkblue size=3>Name</font></th>");
        pw.println("<th bgcolor=white><font face=arial color=darkblue size=3>");
        pw.println("Date of Birth</font></th>");
        pw.println("<th bgcolor=white><font face=arial color=darkblue size=3>");
        pw.println("Mail ld </font></th></tr>");
        pw.println("<form name=del method =get action='./deladdrb'>");
        int i=1;
        String clr;
        while(rset1.next())
         {
          if(i%2==0)
           clr="#FFFFF0";
          else
           clr="FFCC99";
          String n=rset1.getString("NICKNAME");
          String dob=rset1.getString("DATEOFBIRTH");
             String rrr[]=dob.split(" ");
          String mailid=rset1 .getString("EMAILID");
          int id1=rset1.getInt("ID"); /* column name in address table for 'id'(sequence)*/
          pw.println("<tr bgcolor="+clr+"><td><center><input type=checkbox name=c value='"+id1+"'></td>");
          pw.println("<td><b><center>"+n+"</b></td><td><b><center>"+rrr[0]+"</b></td>");
          pw.println("<td><b><center>"+mailid+"</b></td></tr></center>");
          i++;
         }
        pw.println("</table><br><br><br><center><input type=image img src='E:/Tomcat/webapps/WebBasedMail/images/delete.jpg' ></center>");
        pw.println("</center></form>");
        pw.println("<form name=add method=post action=./address>");
        pw.println("<center><input type=image <img src='E:/Tomcat/webapps/WebBasedMail/images/add.jpg'  name=add value='add to contact'></center>");
        pw.println("</form></body></html>");
        pw.close();
       }
      catch(Exception e)
       {
       
         pw.close();
       }
      }
     }                        
