package com.musicgallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicgallery.metier.Categorie;

public class CategorieDao implements ICategorieDao{

	@Override
	public Categorie ajoutCategorie(Categorie categorie) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("INSERT INTO CATEGORIE (NOM,DESCRIPTION) VALUES (?,?)");
			ps.setString(1, categorie.getNom());
			ps.setString(2, categorie.getDescription());
			ps.executeUpdate();
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM CATEGORIE");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				categorie.setId(rs.getLong("MAXID"));
			}
			
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categorie;
	}

	
	
	public String getCategorieNomById(Long id) {
		Connection connection = SingletonConnection.getConnection();
		String categorie = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT NOM FROM CATEGORIE WHERE ID=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				
				categorie = rs.getString(1); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorie;
	}
	
	
	@Override
	public List<Categorie> categorieParMotCle(String mc) {
		List<Categorie> categorie_array = new ArrayList<Categorie>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM CATEGORIE WHERE NOM LIKE ? ORDER BY NOM");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Categorie cat = new Categorie();
				cat.setId(rs.getLong(1)); 
				cat.setNom(rs.getString(2)); 
				cat.setDescription(rs.getString(3)); 
				categorie_array.add(cat);
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return categorie_array;
	}
	
	
	public List<Categorie> categorieAffiche() {
		List<Categorie> categorie_array = new ArrayList<Categorie>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM CATEGORIE ORDER BY NOM");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Categorie cat = new Categorie();
				cat.setId(rs.getLong(1)); 
				cat.setNom(rs.getString(2)); 
				cat.setDescription(rs.getString(3)); 
				categorie_array.add(cat);
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return categorie_array;
	}

	@Override
	public Categorie getCategorie(Long id) {
		
		Connection connection = SingletonConnection.getConnection();
		Categorie cat = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM CATEGORIE WHERE ID = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cat = new Categorie();
				cat.setId(rs.getLong(1)); 
				cat.setNom(rs.getString(2)); 
				cat.setDescription(rs.getString(3)); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("UPDATE CATEGORIE SET NOM=?,DESCRIPTION=? WHERE ID=?");
			ps.setString(1, categorie.getNom());
			ps.setString(2, categorie.getDescription());
			ps.setLong(3, categorie.getId());
			ps.executeUpdate();
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM CATEGORIE");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				categorie.setId(rs.getLong("MAXID"));
			}
			
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categorie;
	}

	@Override
	public void deleteCategorie(Long id) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("DELETE FROM CATEGORIE WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
