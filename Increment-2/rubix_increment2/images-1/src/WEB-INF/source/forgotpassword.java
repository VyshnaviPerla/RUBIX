 import java.sql.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.io.*;
 import java.util.*;

 public class forgotpassword extends HttpServlet
  {
    public void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException,ServletException
     {
       rs.setContentType("text/html");
       PrintWriter pw=rs.getWriter();
       BufferedReader br=new BufferedReader(new FileReader("E:/Tomcat/webapps/WebBasedMail/password.txt"));
       String data="";
       while((data=br.readLine())!= null)
       pw.println(data);
       pw.close();
     }
     
   
  }
