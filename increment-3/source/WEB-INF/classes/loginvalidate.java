import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
public class loginvalidate extends HttpServlet
{
       Connection con=null; 
       Statement ps=null;
       ResultSet rs=null;
          
     HttpSession ses=null;
 RequestDispatcher rd;
 int i=0,j=0;
       public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
       {
                       res.setContentType ("text/html");
               PrintWriter pw=res.getWriter();

               try
               {
                Class.forName("oracle.jdbc.driver.OracleDriver");
       pw.println ("connection");
           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
               pw.println("before prep");
               ps=con.createStatement ();
               pw.println("after prep"); 
	      ses=req.getSession(true);
               String s2=req.getParameter("T1");
               String s3=req.getParameter("T2");
 pw.println("s2"+s2+"s3"+s3);  
               String n[]=new String[20];
              String n1[]=new String[20];
               int p=0; 
               ResultSet rs=ps.executeQuery("select LOGINID,PASSWORD from register");
              pw.println(rs);
		 while(rs.next())
                       {

                                   String user=rs.getString("LOGINID");
pw.println("while"+user);             
                               if( s2.equals(user) && (s3.equals(rs.getString("PASSWORD"))))

                               {
pw.println("if");
                                     ses.setAttribute("user",user);
                                      java.util.Date d = new java.util.Date();
                                   Format form = new SimpleDateFormat("dd-");
                                   Format fm = new SimpleDateFormat("MMM");
                                  String dd=((String)fm.format(d)).toUpperCase();
                                      pw.println(dd);
                                String qry1="select  count(*) from addressbook where username='"+s2+"' and DATEOFBIRTH like '"+form.format(d)+dd+"%'";
                                pw.println(qry1);
                                ResultSet rset1 = ps.executeQuery(qry1);
                         
                                 if(rset1.next())
                                     j=rset1.getInt(1);
                                      pw.println(j);
                                 ses.setAttribute("k",j);
                                  
                         String qry="select  NICKNAME, DATEOFBIRTH from addressbook where username='"+s2+"' and DATEOFBIRTH like '"+form.format(d)+dd+"%'";
                 pw.println(qry);         
                           rset1 = ps.executeQuery(qry);
                        
                
                       while(rset1.next())
                         { 
                           n[i]=rset1.getString("NICKNAME");
                               ses.setAttribute("n1["+i+"]",n[i]);
                               
                                i++; 
                                 
                          }
                              
                          
                               rd= req.getRequestDispatcher("welcomeb.html");
                               rd.forward(req,res); 
                                p=1;
                            }  

                      }                     
                              if(p==0)
                             
                            {
                                                                  
                                 rd= req.getRequestDispatcher("invalidate.html");
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
