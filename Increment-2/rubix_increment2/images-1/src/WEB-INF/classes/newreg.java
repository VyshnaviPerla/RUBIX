
 import java.sql.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
import javax.sql.*;
 import java.io.*;
 import java.util.*;

 public class newreg extends GenericServlet
  {
  
    
    public void service(ServletRequest rq, ServletResponse rs) throws IOException,ServletException
     {
Connection con=null;
       Statement stmt=null;
       ResultSet rss=null;
       try
        {
      Class.forName("oracle.jdbc.driver.OracleDriver");

con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
          Statement st=con.createStatement();
          String uname=rq.getParameter("Login Name");
          String pass=rq.getParameter("Password");
          String question=rq.getParameter("question");
          String answer=rq.getParameter("answer");
          String nam=rq.getParameter("Name");
          String lnam=rq.getParameter("LName");
          String dob="";
           dob = rq.getParameter("D1");
           dob += "/"+rq.getParameter("D2");
           dob += "/"+rq.getParameter("D3");

           String gen=rq.getParameter("Gender");
          String prof=rq.getParameter("Profession");
          String ad=rq.getParameter("Address");
          String ci=rq.getParameter("City");
          String zip=rq.getParameter("zipcode");
          String coun=rq.getParameter("Country");
         rss=st.executeQuery("select * from register where login='"+uname+"'");
          rs.setContentType("text/html");
          PrintWriter ps=rs.getWriter();
          if(!rss.next())
           {
            try{
             String sql="insert into register values ('"+uname+"','"+pass+"','"+question+"','"+answer+"','"+nam+"','"+lnam+"','"+dob+"','"+gen+"','"+prof+"','"+ad+"','"+ci+"','"+zip+"','"+coun+"')";
             st.executeUpdate(sql);
             java.util.Date dx = new java.util.Date();
             
             st.executeUpdate("insert into inbox values('"+uname+"','Fascimail.com','Confirmation of your registration','" +dx.toString()+ "','Welcome to Fascimail','unread',0)" );
               }catch(Exception e)
                {
                ps.println("inserting failed");
                  }
              BufferedReader br = new BufferedReader(new FileReader("C:/Program Files/Apache Software Foundation/Tomcat 5.5/webapps/mail/home1.txt"));
             String data="";
             while((data=br.readLine()) != null)
                ps.println(data);
            
             ps.close();
           }
          else
           {
             ps.println("<html><head></head><body bgcolor='#ebf1fe'><p align=center>&nbsp;&nbsp;&nbsp;&nbsp; </p><font color='990000'>");
             ps.println("<form name=f method=post action=\"http://localhost:8088/WebBasedMail/newreg\">");
             ps.println("<p align=center><font face=Arial size=4 color=red>This Login-id already exists. Please try with diffrent Login-id!</font></p><br><br>");
             ps.println("<input type=hidden name=Password value="+pass+">");
             ps.println("<input type=hidden name=Name value="+nam+">");
             ps.println("<input type=hidden name=Gender value="+gen+">");
             ps.println("<input type=hidden name=dob value="+dob+">");
             ps.println("<input type=hidden name=question value="+question+">");
             ps.println("<input type=hidden name=answer value="+answer+">");
             ps.println("<input type=hidden name=Profession value="+prof+">");
             ps.println("<input type=hidden name=Address value="+ad+">");
             ps.println("<input type=hidden name=City value="+ci+">");
             ps.println("<input type=hidden name=Country value="+coun+">");
	     ps.println("<center><IMG src='E:/Tomcat/webapps/WebBasedMail/images/Ani24.gif' width=100 height=100></center>");
             ps.println("<center><h2><font face=arial color=darkblue size=4> Login Name </h2><input name=\"Login Name\"></font>");
             ps.println("<br><br><input type=image src='E:/Tomcat/webapps/WebBasedMail/images/tryagain.gif' width=100 height=25></center></form><hr>");
             ps.println("</body></html>");
           }
          con.close();
          ps.close();
        rss.close();
        }
       catch(Exception e) {System.out.println(e); }
     }
  }
