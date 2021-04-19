package com.musicgallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.musicgallery.metier.User;

public class LoginDao implements ILoginDao{

	@Override
	public boolean validate(User user){
        boolean status = false;

        	Connection connection = SingletonConnection.getConnection();
        	 PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement("select * from user where email = ? and password = ? ");
				 preparedStatement.setString(1, user.getEmail());
                 preparedStatement.setString(2, user.getPassword());

                 System.out.println(preparedStatement);
                 ResultSet rs = preparedStatement.executeQuery();
                 status = rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
                

            
             return status;
         }
	
	@Override
	public boolean is_role_user(User user){
        

        	Connection connection = SingletonConnection.getConnection();
        	 PreparedStatement preparedStatement;
        	 String role = "";
			try {
				preparedStatement = connection.prepareStatement("select role from user where email = ? and password = ? ");
				 preparedStatement.setString(1, user.getEmail());
                 preparedStatement.setString(2, user.getPassword());

                 System.out.println(preparedStatement);
                 ResultSet rs = preparedStatement.executeQuery();
                if (rs.next())
                {
                	 role = rs.getString("role");
                }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
             return role.equals("USER");
         }


}

