import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;

public class addressbook 
{
      
      
       int i=0,j=0;
       public static void main(String args[]) throws SQLException
        {
                
               try
               {
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
       
            Connection con=DriverManager.getConnection("jdbc:odbc:fasci","scott","tiger");
            
             
              Statement ps3=con.createStatement();
	     
              String qry3="create table addressbook(USERNAME VARCHAR2(50) NOT NULL,NICKNAME VARCHAR2(50) NOT NULL,DATEOFBIRTH DATE NOT NULL,EMAILID VARCHAR2(50) NOT NULL,ID NUMBER(20))";
               ps3.executeQuery(qry3);
              }

               catch(ClassNotFoundException e) 
               {
               }
               catch(SQLException e)
               {
                 
               }
                catch(Exception e)
              {
               }
 }
}
