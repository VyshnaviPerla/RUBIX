import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import javax.servlet.http.*;
public class deletetrash extends HttpServlet
{
            Connection con=null;
              RequestDispatcher rd; 
    public void doGet(HttpServletRequest rq,HttpServletResponse rs)throws ServletException,IOException
    {
    PrintWriter pw = rs.getWriter();    
    rs.setContentType("text/html");
    int j=0;
    try
    {
        String id[]=rq.getParameterValues("n");
        String user=rq.getParameter("user");
       
               Class.forName("oracle.jdbc.driver.OracleDriver");

con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");

      Statement s=con.createStatement();
 
DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  Format form = new SimpleDateFormat("dd-MMM-yyyy");	
 Format f= new SimpleDateFormat("dd.MM.yyyy:HH:mm:ss");
	java.util.Date dd,a7;
        Statement s1=con.createStatement();
        PrintWriter p = rs.getWriter();
        String dd1=" ";
     
         for(int i=0;i<id.length;i++)
        {
                   pw.println("<br>mailid"+id[i]);

        }
           for(int i=0;i<id.length;i++)
        { 
         ResultSet rts=s1.executeQuery("select * from trashcan where mailid="+id[i]);
            

         String sq="";	
           while(rts.next())
           {
        

  	  String a2=rts.getString("username");
  	  String a1=rts.getString("fromid");
	  String a3=rts.getString("subject");
	
dd= (java.util.Date)formatter.parse(rts.getString("date1"));
	
	  String a4=rts.getString("message");
	  String a5=rts.getString("status");
                  java.util.Date a6=(java.util.Date)formatter.parse(rts.getString("time"));
                  	 
a7= (java.util.Date)formatter.parse(rts.getString("dateofdelivery"));

             
	  sq="insert into inbox values('"+a2+"','"+a1+"','"+a3+"','"+form.format(dd)+"','"+a4+"','"+a5+"',"+id[i]+",to_date('"+f.format(a6)+"','DD.MM.YYYY:HH24:MI:SS'),'"+form.format(a7)+"')";
         

          }
  

           s1.executeUpdate(sq);
    

      
          j=s.executeUpdate("delete from trashcan where mailid="+id[i]);
         }
            
       if(j!=0)
       {
            rd= rq.getRequestDispatcher("welcomebodydd.html");
                               rd.forward(rq,rs); 
       }
       
        pw.close();
    }
    catch(SQLException ad)
 {
 System.out.println("qinwan "+ad);
 }
    catch(ParseException ad)
 {
 System.out.println("qinwan "+ad);
 }

    catch(Exception z)
    {
       pw.println("<html><body background=\'E:/Tomcat/webapps/WebBasedMail/images/tile_ragged_edge_bubbles.gif\'>");
      pw.println("<p align=center>&nbsp;</p>");
      pw.println("<p align=center>&nbsp;</p><p align=center>&nbsp;</p>");
      pw.println("<p align=center>&nbsp;</p><table border=0 width=100%>");
      pw.println("<tr><td width=100%><p align=center><font face=arial");
      pw.println("color=red face=arial size=4><b>Please select the messages for deleting/empty Inbox!</b></font></td></tr></table>");
      pw.println("<center><IMG src='E:/Tomcat/webapps/WebBasedMail/images/Ani24.gif' width=100 height=100></center>");
      pw.println("</body></html>");
      pw.close();      
    }

    }
}
