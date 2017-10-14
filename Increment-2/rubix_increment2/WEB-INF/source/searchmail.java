import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.text.*;
import java.util.*;


public class searchmail extends HttpServlet
{

      Connection con=null; 
       Statement stmt1=null;
    
     HttpSession ses=null;
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        try
         {
           
             Class.forName("oracle.jdbc.driver.OracleDriver");
          PrintWriter pw = res.getWriter();
            
           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
   
            Statement stmt1 = con.createStatement();
    
            String name="";
              String id=req.getParameter("m");
            java.util.Date d = new java.util.Date();
          Format form1 = new SimpleDateFormat("dd-MMM-yyyy");
                  ses=req.getSession();      
             pw.println("<html>");
          
            pw.println("<body background=\'E:/Tomcat/webapps/WebBasedMail/images/tile_ragged_edge_bubbles.gif\'  alink=black vlink=black link=black>");
                
           pw.println("<center><table  background='E:/Tomcat/webapps/WebBasedMail/images/bg3.gif' width=50%><tr><td><b><font color='darkblue'><h1>Search Results</h1></td></tr>");
            pw.println("<tr><td><hr color=\'black\'></td></tr></table></center>");
  ResultSet rset1 = stmt1.executeQuery("select * from inbox where username='"+ses.getAttribute("user")+"' and (fromid like'%"+id+"%' or subject like '%"+id+"%') and dateofdelivery<='"+form1.format(d)+"'");
            
            pw.println("<center>");
			
              
          pw.println("<p><table border=1 width=75%><tr><th><font color='darkblue' size=3 face=arial>Select</font></th><th ><font color='darkblue' size=3 face=arial>Sender</font></th><th><font color='darkblue' size=3 face=arial>Subject</font></th><th><font color='darkblue' size=3 face=arial>Date</font></th><th><font color='darkblue' size=3 face=arial>Time</font></th></tr>");
		int i=1;
		String clr="orange";
                   
               
          while(rset1.next())
                {
                        
			
                      
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
					   catch (ParseException e)
                                                                               {
						   System.out.println("hai i have an exception"+e);
		                                                 }
                              
		
			
                    pw.println("<tr bgcolor="+clr+"><td><center><input type=checkbox name=n value="+mid+"></td><td><center><font face=\"arial narrow\"><a href=http://localhost:8088/WebBasedMail/read?messageid="+mid+">"+frid+"</a></td><td><center>"+subb+"</td><td><center>"+rrr[0]+"</td><td><center>"+rrr[1]+"</td></tr>");
                 
                  }
				
          
            pw.println("</table></center></body></html>");
            pw.close();
      
} 
        catch(Exception e)
     {
         System.out.println(e);
     }
    }
}                        
