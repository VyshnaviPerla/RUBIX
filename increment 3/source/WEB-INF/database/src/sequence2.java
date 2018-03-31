import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;

public class sequence2
{
      
      
       int i=0,j=0;
       public static void main(String args[]) throws SQLException
        {
                
               try
               {
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
       
            Connection con=DriverManager.getConnection("jdbc:odbc:fasci","scott","tiger");
            
              
              Statement ps2=con.createStatement();
             
              String qry2="create sequence no start with 1 increment by 1";
               ps2.executeQuery(qry2);
              
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
