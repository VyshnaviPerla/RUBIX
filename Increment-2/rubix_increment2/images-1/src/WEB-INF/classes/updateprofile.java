 import java.sql.*;
 import javax.servlet.*;
  import javax.servlet.http.*;
 import java.io.*;
 import java.util.*;

 public class updateprofile extends HttpServlet
  {
     Connection con=null; 
       Statement ps=null;
       ResultSet rs=null;
     HttpSession ses=null;
 RequestDispatcher rd;
       public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
       {
                       res.setContentType ("text/html");
               PrintWriter pw=res.getWriter();

               try
               {
               Class.forName("oracle.jdbc.driver.OracleDriver");

con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");pw.println("before prep");
               ps=con.createStatement ();
               pw.println("after prep");
          	ses=req.getSession();
          
               int p=0; 
              ResultSet rs=ps.executeQuery("select * from register where LOGINID='"+ses.getAttribute("user")+"'");
               while(rs.next())
                       {
                              String ques=rs.getString("QUESTION");
                              String ans=rs.getString("ANSWER");
                              String name=rs.getString("NAME");
                              String lname=rs.getString("LASTNAME");
                              String dob=rs.getString("DATEOFBIRTH");
                              String g=rs.getString("GENDER");
                              String pro=rs.getString("Profession");
                              String add=rs.getString("ADDRESS");
                              String city=rs.getString("CITY");
                              String z=rs.getString("ZIP");
                              String cou=rs.getString("COUNTRY");
                              //String dirval1=rs.getString("DSTATUS");
                                                            
                              //String didval1=rs.getString("DID");
                         
                          req.setAttribute("ques",ques);   
                              req.setAttribute("ans",ans); 
                              req.setAttribute("name",name);  
                              req.setAttribute("lname",lname);
                              req.setAttribute("dob",dob);
                              req.setAttribute("g",g);
                              req.setAttribute("pro",pro);
                              req.setAttribute("add",add);
                              req.setAttribute("city",city);
                              req.setAttribute("z",z);
                              req.setAttribute("cou",cou);
                          //    req.setAttribute("dirval",dirval1);
                            //   req.setAttribute("didval",didval1);
                           
                         RequestDispatcher rd=req.getRequestDispatcher("updateprofile.jsp");
				rd.forward(req,res);
 
                              
                            }  

                      }  
            	catch(Exception e)
		{
			e.printStackTrace();
		pw.println("can't load driver"+e.getMessage());
		}

}
}

        