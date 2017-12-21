 import java.sql.*;
 import javax.servlet.*;
 import java.io.*;
 import java.util.*;

 public class home extends GenericServlet
  {
    public void service(ServletRequest rq, ServletResponse rs) throws IOException,ServletException
     {
       rs.setContentType("text/html");
       PrintWriter pw=rs.getWriter();
       BufferedReader br = new BufferedReader(new FileReader("E:/Tomcat/webapps/WebBasedMail/home1.txt"));
       String data="";
       while((data=br.readLine()) != null)
       pw.println(data);
       pw.close();
     }
     
   
  }
