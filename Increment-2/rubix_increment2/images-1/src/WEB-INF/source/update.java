
 import java.sql.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.io.*;
 import java.util.*;

 public class update extends HttpServlet
  {
      Connection con=null; 
           Statement ps=null;
            ResultSet rs=null;
           HttpSession s=null;
    public void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException,ServletException
     {
           
       
       try
        {
          
                  Class.forName("oracle.jdbc.driver.OracleDriver");

con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager"); ps=con.createStatement ();
                
                  String pass=rq.getParameter("password");
                    RequestDispatcher rd;
                   s=rq.getSession();
             String sql="update register set password='"+pass+"' where LOGINID='"+s.getAttribute("name")+"'";
            int j=ps.executeUpdate(sql);
             if(j==1)
             {
                 rd= rq.getRequestDispatcher("home1.html");
                               rd.forward(rq,rs); 
             }
            con.close();
             ps.close();
        }
       catch(Exception e)
       {
          
       }
     }
  }
