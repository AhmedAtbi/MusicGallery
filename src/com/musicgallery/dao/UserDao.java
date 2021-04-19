package com.musicgallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.musicgallery.metier.User;

public class UserDao implements IUserDao{

	@Override
	public User ajoutUser(User user) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("INSERT INTO USER (EMAIL,PASSWORD,NOM,DATE_NAISSANCE,SEX,ROLE) VALUES (?,?,?,?,?,?)");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNom());
			ps.setString(4, user.getDate_naissance());
			ps.setString(5, user.getSex());
			
			ps.setString(6, "USER");
			ps.executeUpdate();
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM USER");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				user.setId(rs.getLong("MAXID"));
			}
			
			ps.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}

	@Override
	public List<User> userParMotCle(String mc) {
		List<User> user_array = new ArrayList<User>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM USER WHERE EMAIL LIKE ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong(1)); 
				user.setEmail(rs.getString(2)); 
				user.setPassword(rs.getString(3)); 
				user.setNom(rs.getString(4)); 
				user.setDate_naissance(rs.getString(5));
				user.setSex(rs.getString(6));
				user.setRole(rs.getString(7));
				
				user_array.add(user);
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user_array;
	}

	@Override
	public User getUser(int id) {
		Connection connection = SingletonConnection.getConnection();
		User user = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM USER WHERE ID LIKE ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getLong(1)); 
				user.setEmail(rs.getString(2)); 
				user.setPassword(rs.getString(3)); 
				user.setNom(rs.getString(4)); 
				user.setDate_naissance(rs.getString(5));
				user.setSex(rs.getString(6));
				user.setRole(rs.getString(7));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User updateUser(User user) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("UPDATE user SET email=?,password=?,nom=?,date_naissance=?,sex=?,role=? WHERE id=?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNom());
			ps.setString(4, user.getDate_naissance());
			ps.setString(5, user.getSex());
			ps.setString(6, user.getRole());
			ps.setLong(7, user.getId());
			ps.executeUpdate();
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM USER");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				user.setId(rs.getLong("MAXID"));
			}
			
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	

	@Override
	public int getUserId(String email) {
		int id = -1;
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT ID FROM USER WHERE EMAIL LIKE ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("ID"); 	 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	

	@Override
	public void deleteUser(Long id) {
		
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("DELETE FROM USER WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public int getUserID(String email) {
		
			Connection connection = SingletonConnection.getConnection();
			int id_user = -1;
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement("SELECT ID FROM USER WHERE EMAIL LIKE ?");
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					id_user = rs.getInt("ID");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return id_user;
		}
	}

	

