package org.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sample.dto.User;
import org.sample.util.ConnectionUtils;

public class UserLoginDao {

    public boolean loginUser(User userObj) throws ClassNotFoundException {
//    	ResultSet rs=null;
        try {
        	Connection con=ConnectionUtils.getConnection();
        	PreparedStatement pst = con.prepareStatement("SELECT * FROM public.user WHERE username = ? AND password = ?");
            pst.setString(1, userObj.getUsername());
            pst.setString(2, userObj.getPassword());
            
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs=pst.executeQuery();
            return rs.next();
//            if(rs.next()) return true;
//            else return false;
            

        } catch (SQLException e) {
            
            printSQLException(e);
        }
        return false;
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