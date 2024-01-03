package org.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sample.dto.User;
import org.sample.util.ConnectionUtils;

public class AllUserDao {

	public List<User> selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try {
        	Connection con= ConnectionUtils.getConnection();
        	PreparedStatement preparedStatement = con.prepareStatement("SELECT * from public.user");
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            
            // Step 4: Process the ResultSet object.

            while (rs.next()) {
            	int id=Integer.parseInt(rs.getString("id"));
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password= rs.getString("password");
                String date=rs.getString("regdate");
//                System.out.println("DAo"+id+firstName+lastName+email+username+password);
                users.add(new User(id,firstName, lastName, email, username, password,date));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return users;
    }

}