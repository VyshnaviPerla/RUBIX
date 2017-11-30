import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class passwordvalidate extends HttpServlet
{
       Connection con=null; 
       Statement ps=null;
       ResultSet rs=null;
    HttpSession s=null;
       public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
       {
                       res.setContentType ("text/html");
               PrintWriter pw=res.getWriter();

               try
               {
               Class.forName("oracle.jdbc.driver.OracleDriver");

con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");pw.println("before prep");
               ps=con.createStatement ();
               pw.println("after prep");
              s=req.getSession(true);
              RequestDispatcher rd;
               String user=req.getParameter("login");
               String q=req.getParameter("Question");
               String a=req.getParameter("Answer");
           
               int p=0; 
               ResultSet rs=ps.executeQuery("select * from register where LOGINID='"+user+"'");
               while(rs.next())
                       {
             
                               if( q.equals(rs.getString("QUESTION")) && (a.equals(rs.getString("ANSWER"))))

                               {
                            
                                    s.setAttribute("name",user);
                               rd= req.getRequestDispatcher("updatepassword1.html");
                               rd.forward(req,res); 
                                p=1;
                            }  

                      }                     
                              if(p==0)
                             
                           {
                                                                  
                                 rd=req.getRequestDispatcher("password.html");
                                  rd.forward(req,res); 
                               }

                
               }

               catch(ClassNotFoundException e) 
               {
               pw.println("exception"+e);
               }
               catch(SQLException e)
               {
                       pw.println("exception"+e);
               }
                catch(Exception e)
               {
               pw.println("can't load driver"+e.getMessage());
               }
 }
}
