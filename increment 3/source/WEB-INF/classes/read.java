import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class read extends HttpServlet
{
     
      Connection con=null; 
       Statement stmt1=null;
    
     HttpSession ses=null;
    public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
		PrintWriter pw=res.getWriter();
        try
        {
            int msg = Integer.parseInt (req.getParameter("messageid"));
            res.setContentType("text/html");
           
            Class.forName("oracle.jdbc.driver.OracleDriver");

con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery("select * from inbox where mailid="+msg);
            rset.next();
            String user = rset.getString(1);
            String sender = rset.getString("fromid");

            HttpSession h = req.getSession(true);
            h.putValue("sender",sender);


            
            String sub = rset.getString("subject");
            String date = rset.getString("date1");
            String message = rset.getString("message");
            h.putValue("message",message);

 	         pw.println("<html><body background=\'E:/Tomcat/webapps/WebBasedMail/images/tile_ragged_edge_bubbles.gif\'><center><table border=0 height=57  background='E:/Tomcat/webapps/WebBasedMail/images/bg3.gif' width=75%><tr><td width=75% height=51>");
		  pw.println("<p align=center><big><font color='darkblue'><h1><b> CheckMail </h1></b></font></big>");
		  pw.println("</td></tr></table></center><hr color=black size=1><br><br>");

            pw.println("<table border=0 width=75% bgcolor=white align=center>");
            pw.println("<tr><td><font face=arial color=darkblue  size=3><b>Sender </b></font></td>");
            pw.println("<td><input type=text name=s value="+sender+" READONLY size=41><font color=darkblue face=arial size=3><b>@Fasci.com</b></font>" );
            pw.println("</td></tr><tr>");
            pw.println("<td ><font face=arial color=darkblue size=3><b>Subject</b></font></td>");
            if(!sub.equals("---No Subject---"))
           pw.println("<td ><input type=text name=ss value="+sub+" READONLY size=41></td>");
           else
           pw.println("<td ><input type=text value=' ' READONLY size=41></td>");
           
            pw.println("</tr><tr><td><font face=arial color=darkblue  size=3><b>Date </b></font></td>");
            pw.println("<td ><input type=text name='d1' value="+date+" READONLY size=41></td>");
            pw.println("</tr>");
            pw.println("<tr><td valign='center'><font face=arial color=darkblue size=3><b>Message </b></font></td>");
            pw.println("<td>");
            pw.println("<textarea  name=msg rows=10 cols=54 READONLY size=1000>"+message+"</textarea></p>");
            pw.println("</td></tr>");
            pw.println("</table>");
            pw.println("<center>");
pw.println("<a href=http://localhost:8088/WebBasedMail/compose2?messageid="+msg+"><img src='E:/Tomcat/webapps/WebBasedMail/images/reply.jpg' border=0 width=100></a>");
pw.println("<a href=http://localhost:8088/WebBasedMail/compose3?messageid="+msg+"><img src='E:/Tomcat/webapps/WebBasedMail/images/forward.jpg' border=0 width=100></a>");


            pw.println("</body></html>");
            pw.close();
            stmt.executeUpdate("update inbox set status='read' where mailid="+msg);
            con.close();
        }
        catch(Exception e){}
    }
}
