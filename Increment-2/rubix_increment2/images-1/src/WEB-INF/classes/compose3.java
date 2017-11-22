 import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
public class compose3 extends HttpServlet
{
     
      Connection con=null; 
       Statement stmt1=null;
    RequestDispatcher rd;
int dd,yy;
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        try
        {
            int msg = Integer.parseInt (req.getParameter("messageid"));
            res.setContentType("text/html");
           
              Class.forName("oracle.jdbc.driver.OracleDriver");

con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
              PrintWriter pw = res.getWriter();
            
          
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery("select * from inbox where mailid="+msg);
            rset.next();
            String user = rset.getString(1);
            String sender = rset.getString("fromid");

            HttpSession h = req.getSession(true);
            h.setAttribute("sender",sender);


            
            String sub = rset.getString("subject");
             h.setAttribute("sub",sub);
            String date = rset.getString("date1");
            String message = rset.getString("message");
  h.setAttribute("message",message);

 java.util.Date d = new java.util.Date();
           
        	  Format form = new SimpleDateFormat("MMM");
              String m=form.format(d);
        
   
   if(d.getDate()<10)
        dd =d.getDate();
       else
        dd =d.getDate();
      
       yy=(d.getYear()+1900);
       h.setAttribute("dd",dd);
       h.setAttribute("m",m);
       h.setAttribute("yy",yy);
      
 RequestDispatcher rd=req.getRequestDispatcher("composef.jsp");
				rd.forward(req,res);
 
 	        
            pw.close();
            
            con.close();
        }
        catch(Exception e){}
    }
}