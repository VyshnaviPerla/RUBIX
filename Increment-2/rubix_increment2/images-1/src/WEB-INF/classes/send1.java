import java.sql.*;
import java.io.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.util.*;
import java.text.*;
public class send1 extends HttpServlet
{
public static Connection dbconn;
public static Statement stmt;
  HttpSession ses=null;
 RequestDispatcher rd;
     ResultSet rs1=null;

 int j=0;
String d1;
 int p;
 public void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException,ServletException
{
 try
 {
     PrintWriter pw=rs.getWriter();
 Class.forName("oracle.jdbc.driver.OracleDriver");
 
 dbconn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");

 
 
 	ses=rq.getSession();
  
  Statement st=dbconn.createStatement();


           String a1 = rq.getParameter("toaddress");
            String a2 = rq.getParameter("subject");
            String a3 = rq.getParameter("message");
            String dod_d = rq.getParameter("D1");
            String dod_m = rq.getParameter("D2");
            String dod_y = rq.getParameter("D3");
           String dob="";
           dob = rq.getParameter("D1");
           dob += "/"+rq.getParameter("D2");
           dob += "/"+rq.getParameter("D3");
           java.util.Date d = new java.util.Date();
           Format form=new SimpleDateFormat("dd-MMM-yyyy");
        	  Format f= new SimpleDateFormat("dd.MM.yyyy:HH:mm:ss");
	  	
	String ex="checked";
           String u="unread";
          String id="id.nextval";

          rs1=st.executeQuery("select * from register");
           while(rs1.next())
            {
                   
                 if( a1.equals(rs1.getString("LOGINID"))) 
                 {
                         
                  /*  if(ex.equals(rs1.getString("DSTATUS")))
                    {
                      a1=rs1.getString("DID");
             
                     }*/
                  String sql="insert into inbox values ('"+a1+"','"+ses.getAttribute("user")+"','"+a2+"','"+form.format(d)+"','"+a3+"','"+u+"',"+id+",to_date('"+f.format(d)+"','DD.MM.YYYY:HH24:MI:SS'),'"+dob+"')";
                    System.out.println(sql);
					st.executeUpdate(sql);
                       j=1;
                     rd= rq.getRequestDispatcher("welcomebodys.html");
                               rd.forward(rq,rs); 
               }
                  j=0;     
            }
           if(j==0)
          {
                 
                rd= rq.getRequestDispatcher("composes.jsp");
                               rd.forward(rq,rs); 
     }

stmt.close();
dbconn.close();


}

catch(Exception e)
{
	e.printStackTrace();
 System.out.println(e.getMessage());

}
}
}