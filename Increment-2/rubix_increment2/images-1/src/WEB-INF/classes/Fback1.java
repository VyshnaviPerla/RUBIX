import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.lang.*;
public class Fback1 extends HttpServlet
{
        Connection con=null;
	Statement ps=null,ps1=null,ps2=null;	
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
			res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
	          HttpSession ses=req.getSession();
 		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
      pw.println("connection");
	    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		pw.println("before prep");
                ps=con.createStatement();
                ps1=con.createStatement();
                ps2=con.createStatement();
		pw.println("after prep");
ResultSet rs=ps.executeQuery("select USERNAME,CDATE from inbox1");
               int x=0;
while(rs.next())
{   
   String user=rs.getString("USERNAME");       
   String cdate=rs.getString("CDATE");  
   java.util.Date d=new java.util.Date();
   Format form=new SimpleDateFormat("dd-MMM-yyyy");
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
  String rr[]=cdate.split(" ");
java.util.Date rdate=(java.util.Date)formatter.parse(rr[0]);
   pw.println(rr[0]);
   pw.println("<br>"+form.format(d));
   pw.println("select months_between('"+form.format(d)+"','"+form.format(rdate)+"') from inbox1 ");

   ResultSet rs1=ps2.executeQuery("select months_between('"+form.format(d)+"','"+form.format(formatter.parse(rr[0]))+"') from inbox1");
   pw.println("hdhdh");
while(rs1.next())
{

             x=rs1.getInt(1);
               pw.println(x);
               if(x>8)
              {
            int row=ps1.executeUpdate("delete from register where loginid='"+user+"'");
              pw.println("deleted");
            con.commit();
}
  
}            
}
    
}	
   
		catch(ClassNotFoundException e)
		{
		pw.println("exception"+e);
		}
		catch(SQLException e)
		{
			pw.println("USER ID ALREADY EXISTS");	
			pw.println("TRY WITH DIFFERENT USER ID"+e.getMessage());
		}
		     	catch(Exception e)
		{
		pw.println("can't load driver"+e.getMessage());
		}
  }
}
