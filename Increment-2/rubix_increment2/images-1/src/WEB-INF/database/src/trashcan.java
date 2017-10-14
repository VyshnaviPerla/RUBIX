import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;

public class trashcan
{
      
      
       int i=0,j=0;
       public static void main(String args[]) throws SQLException
        {
                
               try
               {
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
       
            Connection con=DriverManager.getConnection("jdbc:odbc:fasci","scott","tiger");
            
              
              Statement ps2=con.createStatement();
             
              String qry2="create table trashcan(USERNAME VARCHAR2(50) NOT NULL,FROMID VARCHAR2(50) NOT NULL,SUBJECT VARCHAR2(50) NOT NULL,DATE1 DATE NOT NULL,MESSAGE LONG  NOT NULL,STATUS VARCHAR2(20) NOT NULL,MAILID NUMBER(20) NOT NULL,TIME DATE NOT NULL,DATEOFDELIVERY DATE NOT NULL)";
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
