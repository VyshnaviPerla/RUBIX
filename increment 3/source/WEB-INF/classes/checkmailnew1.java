import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.text.*;
import java.util.*;


public class checkmailnew1 extends HttpServlet
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
            
           DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
   
            Statement stmt1 = con.createStatement();
    
            String name="";
              
            java.util.Date d = new java.util.Date();
             Format form1 = new SimpleDateFormat("dd-MMM-yyyy");
        String dd=" ";
             ses=req.getSession();
          
            res.setContentType("text/html");
            
            pw.println("<html>");
          
            pw.println("<body background=\'E:/Tomcat/webapps/WebBasedMail/images/tile_ragged_edge_bubbles.gif\'  alink=black vlink=black link=black>");
                
            int read=0,unread=0;
            ResultSet rset1 = stmt1.executeQuery("select  count(*) from trashcan where username='"+ses.getAttribute("user")+"'and status='unread'");
              pw.println(dd);
                         if(rset1.next())
               
                unread=rset1.getInt(1);
   
            rset1 = stmt1.executeQuery("select  count(*) from trashcan where username='"+ses.getAttribute("user")+"' and status='read'");
            if(rset1.next())
                read=rset1.getInt(1);
           rset1=stmt1.executeQuery("select name from register where LOGINID='"+ses.getAttribute("user")+"'");
           
            if(rset1.next())name=rset1.getString(1);
            rset1 = stmt1.executeQuery("select * from trashcan where username='"+ses.getAttribute("user")+"'");
            
            pw.println("<center>");
			pw.println("<form name=del method=get action=http://localhost:8088/WebBasedMail/deletetrash>");
            pw.println("<input type=hidden name=user value="+ses.getAttribute("user")+">");
            pw.println("<table  background='E:/Tomcat/webapps/WebBasedMail/images/bg3.gif' width=75%><tr><td><b><font color='darkblue'><h1>"+name+" 's Trashbox</h1></td></tr>");
            pw.println("<tr><td><hr color=\'black\'></td></tr></table>");
            pw.println("<table  background='E:/Tomcat/webapps/WebBasedMail/images/bg3.gif' width=75%><tr><td><center><font face=arial color=darkblue size=3><b>Total messages : </b>"+(unread+read));
            
              
            pw.println("</center></td></tr></table><p><center><table border=1  width=75%><tr><th><font color='darkblue' size=3 face=arial>Select</font></th><th ><font color='darkblue' size=3 face=arial>Sender</font></th><th><font color='darkblue' size=3 face=arial>Subject</font></th><th><font color='darkblue' size=3 face=arial>Date</font></th></tr>");
		int i=1;
		String clr;
                   
               
          while(rset1.next())
                {
                        
			if(i%2==0) 
			   clr="#fbcc7d";
			else
			   
                         clr="orange";
                      
			String frid=rset1.getString("fromid");
			String subb=rset1.getString("subject");	
                        String dt=rset1.getString("date1");
                        String status=rset1.getString("status");
                        String mid=rset1.getString("mailid");
                        String t=rset1.getString("time");
                       String rrr[]=t.split(" ");    
                   String dd1=rset1.getString("dateofdelivery");
					   try{
					   DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy ");
						java.util.Date d1 = (java.util.Date)formatter.parse(dd1);
						pw.println(d);
						Format form = new SimpleDateFormat("yyyy-MM-dd");
						pw.println(form.format(d1));
					   }
					   catch (ParseException e){
						   System.out.println("hai i have an exception"+e);
						   e.printStackTrace();
		}
             finally{
				 System.out.println("hai i have an exception");
			 }
				 
                  if(status.equals("unread"))
                  {
                    
			
                    pw.println("<tr bgcolor="+clr+"><td><center><input type=checkbox name=n value="+mid+"></td><td><center><font face=\"arial narrow\">"+frid+"</td><td><center>"+subb+"</td><td><center>"+rrr[0]+"</td></tr>");
                       i++;
                  }
                  else
                  {
                   pw.println("<tr bgcolor="+clr+"><td><center><input type=checkbox name=n value="+mid+"></td><td><center>"+frid+"</td><td><center>"+subb+"</td><td><center>"+rrr[0]+"</td></tr>");
                       i++;
                 
                  }
                }
				
          pw.println("</table><br><br><center><input type=image src='E:/Tomcat/webapps/WebBasedMail/images/restore.jpg' width=100 height=25 name=p1></center><br><br><br>");
            pw.println("</form></center></body></html>");
            pw.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}                        
