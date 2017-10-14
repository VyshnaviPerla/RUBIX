/*Enters data into database
address.java to addressb.java*/

 import java.sql.*;
 import java.io.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.util.*;
 public class addressb extends HttpServlet
  {
   public static Connection dbconn;
   public static Statement stmt;
        HttpSession ses=null;
   int j;
   public void doPost(HttpServletRequest rq, HttpServletResponse rs) 
   throws IOException,ServletException
    {
     try
      {
       Class.forName("oracle.jdbc.driver.OracleDriver");
       dbconn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
       stmt=dbconn.createStatement();
       RequestDispatcher rd;
   ses=rq.getSession();
       String nname=rq.getParameter("n");
       String dob="";
       dob = rq.getParameter("D1");
       dob += "/"+rq.getParameter("D2");
       dob += "/"+rq.getParameter("D3");
       String mailid=rq.getParameter("mailid");
     String num="no.nextval";
       String sql="insert into addressbook values ('"+ses.getAttribute("user")+"','"+nname+"','"+dob+"','"+mailid+"',"+num+")";       
      
        
          j= stmt.executeUpdate(sql);
         
rd= rq.getRequestDispatcher("welcomebodya.html");
           rd.forward(rq,rs); 
        
        stmt.close();
        dbconn.close();
          }
       catch(Exception e)
        {
          System.out.println(e);
        }
       }
      }