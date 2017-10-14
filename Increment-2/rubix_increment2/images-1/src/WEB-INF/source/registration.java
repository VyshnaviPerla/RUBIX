import java.sql.*;
import java.io.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.util.*;
import java.text.*;
import java.text.*;
public class registration extends GenericServlet
{
public static Connection dbconn;
public static Statement stmt;
public static Statement ps;
public static Statement ps1;
public static Statement ps2;
   PrintWriter pw=null;
 int j;
 public void service(ServletRequest rq, ServletResponse rs) throws IOException,ServletException
{
 try
 {
 Class.forName("oracle.jdbc.driver.OracleDriver");
 dbconn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
 stmt=dbconn.createStatement();
  Statement st=dbconn.createStatement();
    pw=rs.getWriter();
     
 RequestDispatcher rd;
          String uname=rq.getParameter("LoginName");
          String pass=rq.getParameter("Password");
          String question=rq.getParameter("question");
          String answer=rq.getParameter("answer");
          String nam=rq.getParameter("Name");
          String lnam=rq.getParameter("LName");
          String dob="";
           dob = rq.getParameter("D1");
           dob += "/"+rq.getParameter("D2");
           dob += "/"+rq.getParameter("D3");
              java.util.Date dd = new java.util.Date();
           Format form=new SimpleDateFormat("dd-MMM-yyyy");
           String gen=rq.getParameter("Gender");
          String prof=rq.getParameter("Profession");
          String ad=rq.getParameter("Address");
          String ci=rq.getParameter("City");
          String zip=rq.getParameter("zipcode");
          String coun=rq.getParameter("Country");
          String date1="08-APR-2007";
         pw.println(form.format(dd));
          ps=dbconn.createStatement();
   ps1=dbconn.createStatement();
   ps2=dbconn.createStatement();
   pw.println(date1);
   if(date1.equals(form.format(dd)))
         {
                    pw.println(date1);
               int p=1;
         }
       else
           {
                 
               pw.println("hi"+date1);
                date1=form.format(dd);
                  pw.println("hi2"+date1);
             ResultSet rse=ps.executeQuery("select LOGINID,DATEOFBIRTH from register");
             pw.println("hello");
           float x=0;
      while(rse.next())
       {   
        String user=rse.getString("LOGINID");       
        String cdate=rse.getString("DATEOFBIRTH");  
        java.util.Date d=new java.util.Date();
        Format form1=new SimpleDateFormat("dd-MMM-yyyy");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String rr[]=cdate.split(" ");
        java.util.Date rdate=(java.util.Date)formatter.parse(rr[0]);
        pw.println(rr[0]);
        pw.println("<br>"+form1.format(d));
        pw.println("select months_between('"+form1.format(d)+"','"+form1.format(rdate)+"') from register where loginid='"+user+"'");
        ResultSet rs1=ps2.executeQuery("select months_between('"+form1.format(d)+"','"+form1.format(formatter.parse(rr[0]))+"') from register where loginid='"+user+"'");
        pw.println("hdhdh111111111");
   		rs1.next();         
          x=rs1.getFloat(1);
		 pw.println(x);
	      if(x>=3)
           {
            int row=ps1.executeUpdate("delete from register where loginid='"+user+"'");
            pw.println("deleted");
           }
		}
}
        String sql="insert into register values ('"+uname+"','"+pass+"','"+question+"','"+answer+"','"+nam+"','"+lnam+"','"+dob+"','"+gen+"','"+prof+"','"+ad+"','"+ci+"','"+zip+"','"+coun+"','"+form.format(dd)+"','"+null+"','"+null+"')";
        try
        {          
            j= st.executeUpdate(sql);
         }
         catch(Exception e)
         {  
		 
               rd= rq.getRequestDispatcher("register1.html");
                               rd.forward(rq,rs); 
          }
           
             if(j==1)
             {
               rd= rq.getRequestDispatcher("register.html?='successfull'");
                               rd.forward(rq,rs); 
           
             }
stmt.close();
dbconn.close();

}

catch(Exception e)
{
 System.out.println(e);

}
}
}