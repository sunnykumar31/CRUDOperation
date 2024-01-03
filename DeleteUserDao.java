package org.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.sample.util.ConnectionUtils;

public class DeleteUserDao {

	public Boolean deleteUser(int id) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        
        // Step 1: Establishing a Connection
		boolean rowdelete=false;
        try {
        	Connection con= ConnectionUtils.getConnection();
        	PreparedStatement preparedStatement = con.prepareStatement("delete from public.user where id=?;");
        	preparedStatement.setInt(1,id);
            rowdelete = preparedStatement.executeUpdate()>0;
//            System.out.println(rowdelete);
//            System.out.println("lakshman");

            
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowdelete;
    }

}