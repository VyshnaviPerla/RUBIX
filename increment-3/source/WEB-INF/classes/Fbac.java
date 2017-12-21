import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.lang.*;
public class Fbac extends HttpServlet
{
        Connection con=null;
	Statement ps=null,ps1=null,ps2=null;	
	ResultSet rs=null,rs1=null;
	
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
		RequestDispatcher rr;	
               
                java.util.Date d=new java.util.Date();
		Format form=new SimpleDateFormat("dd-MMM-yyyy");
		pw.println(""+form.format(d));
        	ResultSet rs=ps.executeQuery("select cdate from inbox1");
                pw.println("query executed");
		float x=0;
	  	while(rs.next())
{   pw.println(""+x);
                 String cdate=rs.getString("cdate");
		String sdate=form.format(d);
pw.println(""+sdate);
pw.println("select months_between('"+form.format(d)+"','"+cdate+"') from inbox1 ");
ResultSet rs1=ps2.executeQuery("select months_between('"+form.format(d)+"','"+cdate+"') from inbox1");
pw.println("query 2 executed");
while(rs1.next())
{
		pw.println("while in");
    	 	x=Float.parseFloat(rs1.getString("months_between('"+form.format(d)+"','"+cdate+"')"));
		pw.println(""+x);
               if(x>=1.0)
              {
            int row=ps1.executeUpdate("delete from register where f_date='mano'");
            con.commit();
}
 }  
}            

       
                rr= req.getRequestDispatcher("home.html");
               rr.forward(req,res);
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