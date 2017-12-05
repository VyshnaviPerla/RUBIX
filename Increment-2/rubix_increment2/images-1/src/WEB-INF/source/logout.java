  import javax.servlet.*;
 import java.io.*;
 import java.util.*;
 import java.sql.*;
  import javax.servlet.http.*;
 public class logout extends HttpServlet
  {  
     
       Connection con=null; 
       Statement ps=null;
       ResultSet rs=null;
          HttpSession ses=null;
 RequestDispatcher rd;
     PrintWriter pw;
    public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException,ServletException
     {
       
       try
        {
          pw=rs.getWriter();
         
           Class.forName("oracle.jdbc.driver.OracleDriver");

           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
               ses=rq.getSession();
               ps=con.createStatement ();
       
         RequestDispatcher rd;
       
      String q="select name from register where loginid='"+ses.getAttribute("user")+"'";
        
         ResultSet r=ps.executeQuery(q);
          String name=" ";        
         if(r.next())
         name=r.getString(1);
          ses.invalidate();
        rd= rq.getRequestDispatcher("homel.html");
                               rd.forward(rq,rs);
	 
        }
       catch(Exception e)
        { 
         pw.println(e);
        }
    
        pw.close();
     }
  }
