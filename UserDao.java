package org.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.sample.dto.User;
import org.sample.util.ConnectionUtils;

public class UserDao {

    public int registerUser(User userObj) throws ClassNotFoundException {
      
    	int rs=0;
        try {
        	Connection con=ConnectionUtils.getConnection();
		    PreparedStatement pst = con.prepareStatement("INSERT INTO \"user\" (first_name, last_name, email, username, password, regdate) VALUES (?, ?, ?, ?, ?, CURRENT_DATE)");
 
            pst.setString(1, userObj.getFirstName());
            pst.setString(2, userObj.getLastName());
            pst.setString(3, userObj.getEmail());
            pst.setString(4, userObj.getUsername());
            pst.setString(5, userObj.getPassword());
            
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            
            rs = pst.executeUpdate();

        } catch (SQLException e) {
            
            printSQLException(e);
        }
        return rs;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}