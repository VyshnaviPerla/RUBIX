import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class trashshow extends GenericServlet
{
    public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException
    {
        try
         {
           
            res.setContentType("text/html");
            PrintWriter pw = res.getWriter();
            pw.println("<html>");
            pw.println("<body background=\'E:/Tomcat/webapps/WebBasedMail/images/tile_ragged_edge_bubbles.gif\'><center><table  background='E:/Tomcat/webapps/WebBasedMail/images/bg3.gif' width=75%><tr><td width=100% height=51>");

   	    pw.println("<p align=center><big><font color='darkblue'><h1><b>Trashed Mails</b> </h1></font></big>");
	    pw.println("</td></tr></table><hr color=black size=1>");

	    pw.println("<br><br><br><center><form name=restore method=get action=http://localhost:8088/WebBasedMail/checkmailnew>");
	  
	   pw.println("<input type=image img src='./images/delete.jpg' ></form>");
	   pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	   pw.println("<form name=del method=get action=http://localhost:8088/WebBasedMail/checkmailnew1>");
	  	
          // pw.println("<input type=image img src='./images/restore.jpg'  ></form> </center>");
           pw.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}                        
