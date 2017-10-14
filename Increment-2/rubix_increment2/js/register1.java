import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.sql.*;

public class register1 
{
      
      
       int i=0,j=0;
       public static void main(String args[]) throws SQLException
        {
                
               try
               {
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
       
            Connection con=DriverManager.getConnection("jdbc:odbc:fasci","scott","tiger");
            
              Statement ps=con.createStatement();
              
	      String qry="create table register(LOGINID VARCHAR2(50) PRIMARY KEY,PASSWORD VARCHAR2(50) NOT NULL,QUESTION VARCHAR2(50) NOT NULL, ANSWER VARCHAR2(50) NOT NULL, NAME VARCHAR2(50) NOT NULL,LASTNAME VARCHAR2(50) NOT NULL,DATEOFBIRTH DATE NOT NULL,GENDER VARCHAR2(50) NOT NULL,PROFESSION VARCHAR2(50) NOT NULL,ADDRESS VARCHAR2(50) NOT NULL,CITY VARCHAR2(50) NOT NULL,ZIP VARCHAR2(50) NOT NULL,COUNTRY VARCHAR2(50) NOT NULL,CDATE DATE,DSTATUS VARCHAR2(50),DID VARCHAR2(50)";
             ps.executeQuery(qry);
              
             
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
