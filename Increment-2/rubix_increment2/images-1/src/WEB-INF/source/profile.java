
 import java.sql.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.io.*;
 import java.util.*;

 public class profile extends HttpServlet
  { 
        Connection con=null; 
       Statement st=null;
       ResultSet rs2=null;
        HttpSession ses=null;
         RequestDispatcher rd;
        
            int j,k;
    public void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException,ServletException
     {
       PrintWriter pw=rs.getWriter();
       try
        { 
           Class.forName("oracle.jdbc.driver.OracleDriver");

con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");    pw.println("before prep");
               st=con.createStatement (); 
               pw.println("after prep");
          ses=rq.getSession();
          String pass=rq.getParameter("password");
          String nam=rq.getParameter("Name");
          String lnam=rq.getParameter("LName"); 
          String quest=rq.getParameter("Question");
          String answer1=rq.getParameter("Answer");
          String prof=rq.getParameter("proffession");
          String ad=rq.getParameter("Address");
          String ci=rq.getParameter("City");
          String zip=rq.getParameter("Zipcode");  
          String coun=rq.getParameter("country");
          String dirval=rq.getParameter("dir");
pw.println(dirval);
          String didval=rq.getParameter("dirid");
          String c="checked";
          rs.setContentType("text/html"); pw.println("hi ");
    if(dirval==null)
          {
           pw.println("hi ra7");          
           
String sql="update register set password='"+pass+"',question='"+quest+"',answer='"+answer1+"',name='"+nam+"',lastname='"+lnam+"',profession='"+prof+"',address='"+ad+"',city='"+ci+"',zip='"+zip+"',country='"+coun+"',dstatus='"+dirval+"',did='"+didval+"' where LOGINID='"+ses.getAttribute("user")+"'";
               j=st.executeUpdate(sql);
            }

else
{
 if(dirval.equals(c))
          {
           k=0;
           pw.println("hi ra1");
           rs2=st.executeQuery("select LOGINID from register");
           pw.println("hi ra2");
           while(rs2.next())
            {
                pw.println("hi ra3");
                if( didval.equals(rs2.getString("LOGINID"))) 
                 {
                     pw.println("hi ra4");
                     String sql="update register set password='"+pass
+"',question='"+quest+"',answer='"+answer1+"',name='"+nam+"',lastname='"+lnam+"',profession='"+prof+"',address='"+ad+"',city='"+ci+"',zip='"+zip+"',country='"+coun+"',dstatus='"+dirval+"',did='"+didval+"'  where LOGINID='"+ses.getAttribute("user")+"'";
                     pw.println("update register set password='"+pass+"',question='"+quest+"',answer='"+answer1+"',name='"+nam+"',lastname='"+lnam+"',profession='"+prof+"',address='"+ad+"',city='"+ci+"',zip='"+zip+"',country='"+coun+"',dstatus='"+dirval+"',did='"+didval+"'  where LOGINID='"+ses.getAttribute("user")+"'");  
                    k=st.executeUpdate(sql);
                    pw.println("updated"); 
                   pw.println(k);
                     if(k==1)
                     {   pw.println("hi ");
                      
                      rd= rq.getRequestDispatcher("welcomebodyp.html");
                    pw.println("hi1");
                             rd.forward(rq,rs);
 pw.println("hi2");
                         }
                     pw.println("hi ra5");
                }
           } 
          rs2.close();

            if((k==0))
             {
              pw.println("hi ra6");
              rd= rq.getRequestDispatcher("idnotexe.html");
                               rd.forward(rq,rs);
             }
        else
         {
          pw.print("enter");
         rd= rq.getRequestDispatcher("welcomebodyp.html");
                             rd.forward(rq,rs);
         }
         }
}              if((j==1))
             {
  pw.println("hi ra8");
                 rd= rq.getRequestDispatcher("welcomebodyp.html");
                             rd.forward(rq,rs);
             }
            
            con.close();
             st.close();
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
