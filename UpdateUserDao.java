package org.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.sample.dto.User;
import org.sample.util.ConnectionUtils;

public class UpdateUserDao {

    public boolean updateUser(User userObj) throws ClassNotFoundException {
      
    	boolean rs = false;
        try {
        	Connection con=ConnectionUtils.getConnection();
		    PreparedStatement pst = con.prepareStatement("update public.user set first_name = ?,last_name= ?, email =?, username=?, password=? where email = ?;");
 
            pst.setString(1, userObj.getFirstName());
            pst.setString(2, userObj.getLastName());
            pst.setString(3, userObj.getEmail());
            pst.setString(4, userObj.getUsername());
            pst.setString(5, userObj.getPassword());
            pst.setString(6, userObj.getEmail());
//            pst.setInt(6,userObj.getId());
            
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            
            rs = pst.executeUpdate()>0;
            System.out.println("ram2");
            System.out.println(rs);

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