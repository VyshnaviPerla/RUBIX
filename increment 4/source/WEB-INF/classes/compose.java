 import java.sql.*;
 import javax.servlet.*;
 import java.io.*;
 import java.util.*;
 import java.util.Date;
 import javax.servlet.http.*;
import java.text.*;
 public class compose extends HttpServlet
  {
       HttpSession hs=null;
        
         RequestDispatcher rd;
         int m,dd,yy;
    public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException,ServletException
     {
       rs.setContentType("text/html");
       PrintWriter pw=rs.getWriter();
       hs=rq.getSession(true);
       java.util.Date d = new java.util.Date();
           
        	  Format form = new SimpleDateFormat("MMM");
              String m=form.format(d);
        
   
   if(d.getDate()<10)
        dd =d.getDate();
       else
        dd =d.getDate();
      
       yy=(d.getYear()+1900);
       hs.setAttribute("dd",dd);
       hs.setAttribute("m",m);
       hs.setAttribute("yy",yy);
          rd= rq.getRequestDispatcher("compose.jsp");
                               rd.forward(rq,rs);
    
    pw.close();
     }
     
   
  }  
