package org.sample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class PSQLConnUtils {
 
 public static Connection getPSQLConnection()
         throws ClassNotFoundException, SQLException {
	 // Note: Change the connection parameters accordingly.
     String hostName = "localhost";
     String dbName = "UserDB";
     String userName = "postgres";
     String password = "postgres";
     return getPSQLConnection(hostName, dbName, userName, password);
 }
 
 public static Connection getPSQLConnection(String hostName, String dbName,
         String userName, String password) throws SQLException,
         ClassNotFoundException {
   
     Class.forName("org.postgresql.Driver");
 
     // URL Connection for MySQL:
     // Example: 
     // jdbc:mysql://localhost:3306/simplehr
     String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName;
 
     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
}