import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.text.*;
public class checkmail1 extends HttpServlet
{

      Connection con=null; 
       Statement stmt1=null;
    
     HttpSession ses=null;
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        try
         {
           
               Class.forName("oracle.jdbc.driver.OracleDriver");
          PrintWriter pw = res.getWriter();
            
          con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
   
            Statement stmt1 = con.createStatement();
          ses=req.getSession();
            String name="";
              java.util.Date d = new java.util.Date();
           
        	  Format form = new SimpleDateFormat("dd-MMM-yyyy");
	  		
           
            
            pw.println("<html>");
          
            pw.println("<body background=\'E:/Tomcat/webapps/WebBasedMail/images/tile_ragged_edge_bubbles.gif\' alink=black vlink=black link=black>");
            
            int read=0,unread=0;
           ResultSet rset1 = stmt1.executeQuery("select  count(*) from inbox where username='"+ses.getAttribute("user")+"'and status='unread'and dateofdelivery<='"+form.format(d)+"'");
             
                         if(rset1.next())
               
                unread=rset1.getInt(1);
   
            rset1 = stmt1.executeQuery("select  count(*) from inbox where username='"+ses.getAttribute("user")+"' and status='read'and dateofdelivery<='"+form.format(d)+"'");
            if(rset1.next())
                read=rset1.getInt(1);
           rset1=stmt1.executeQuery("select name from register where LOGINID='"+ses.getAttribute("user")+"'");
           
            if(rset1.next())name=rset1.getString(1);
            rset1 = stmt1.executeQuery("select * from inbox where username='"+ses.getAttribute("user")+"'and dateofdelivery<='"+form.format(d)+"' order by dateofdelivery desc,date1 desc");
   
            
            
            pw.println("<center><form name=del method=post action=http://localhost:8088/WebBasedMail/delete>");
            pw.println("<input type=hidden name=user value="+ses.getAttribute("user")+">");
            pw.println("<table  background='E:/Tomcat/webapps/WebBasedMail/images/bg3.gif' width=75%><tr><td><b><font color='darkblue'><h1>"+name+" 's Inbox</h1></td></tr>");
            pw.println("<tr><td><hr color=\'black\'></td></tr></table>");
            pw.println("<table  background='E:/Tomcat/webapps/WebBasedMail/images/bg3.gif' width=75%><tr><td><center><font face=arial color=darkblue size=3><b>Total messages : </b>"+(unread+read));
            
                pw.println("&nbsp&nbsp");
            pw.println("<font face=arial color=darkblue size=3><b>New messages : </b>"+unread);
            
                pw.println("&nbsp&nbsp");
            pw.println("<font face=arial color=darkblue size=3><b>Read messages : </b>"+read);

            pw.println("</center></td></tr></table><p><table width=75%><tr><th><font color='darkblue' size=3 face=arial>Select</font></th><th ><font color='darkblue' size=3 face=arial>Sender</font></th><th><font color='darkblue' size=3 face=arial>Subject</font></th><th><font color='darkblue' size=3 face=arial>Date</font></th><th><font color='darkblue' size=3 face=arial>Time</font></th></tr>");
		int i=1;
		String clr;
                   
               
          while(rset1.next())
                {
                        
			
                      
			String frid=rset1.getString("fromid");
			String subb=rset1.getString("subject");	
                        String dt=rset1.getString("date1");
                        String status=rset1.getString("status");
                        int mid=rset1.getInt("mailid");
                        String t=rset1.getString("time");
                       String rrr[]=t.split(" ");
                        String dd1=rset1.getString("dateofdelivery");
                  if(status.equals("unread"))
                  {
                    
			
                    pw.println("<tr bgcolor=#fbcc7d><td><center><input type=checkbox name=n value="+mid+"></td><td><center><font face=\"arial narrow\"><a href=http://localhost:8088/WebBasedMail/read?messageid="+mid+">"+frid+"</a></td><td><center>"+subb+"</td><td><center>"+rrr[0]+"</td><td><center>"+rrr[1]+"</td></tr>");
                       i++;
                  }
                  else
                  {
                   pw.println("<tr bgcolor=orange><td><center><input type=checkbox name=n value="+mid+"></td><td><center><a href=http://localhost:8088/WebBasedMail/read?messageid="+mid+">"+frid+"</a></td><td><center>"+subb+"</td><td><center>"+rrr[0]+"</td><td><center>"+rrr[1]+"</td></tr>");
                       i++;
                 
                  }
                }

 pw.println("</table><br><br><center><input type=image src='./images/delete.jpg' width=100 height=25 name=p1></center><br><br><br>");
            pw.println("</form></center></body></html>");
            pw.close();
      
        }
        catch(Exception e){System.out.println(e);}
    }
}                        
