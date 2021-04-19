package com.musicgallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicgallery.metier.Artiste;


public class ArtisteDao implements IArtisteDao{

	@Override
	public Artiste ajoutArtiste(Artiste artiste) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("INSERT INTO ARTISTE (NOM,PAYS,IMAGE) VALUES (?,?,?)");
			ps.setString(1, artiste.getNom());
			ps.setString(2, artiste.getPays());
			ps.setString(3, artiste.getImage());
			ps.executeUpdate();
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM ARTISTE");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				artiste.setId(rs.getLong("MAXID"));
			}
			
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return artiste;
	}

	@Override
	public List<Artiste> artisteParMotCle(String mc) {
		List<Artiste> artiste_array = new ArrayList<Artiste>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM ARTISTE WHERE NOM LIKE ? ORDER BY NOM");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Artiste artiste = new Artiste();
				artiste.setId(rs.getLong(1)); 
				artiste.setNom(rs.getString(2)); 
				artiste.setPays(rs.getString(3)); 
				artiste.setImage(rs.getString(4)); 
				artiste_array.add(artiste);
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return artiste_array;
	}

	@Override
	public Artiste getArtiste(Long id) {
		Connection connection = SingletonConnection.getConnection();
		Artiste artiste = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM ARTISTE WHERE ID=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				artiste = new Artiste();
				artiste.setId(rs.getLong(1)); 
				artiste.setNom(rs.getString(2)); 
				artiste.setPays(rs.getString(3)); 
				artiste.setImage(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artiste;
	}
	public String getArtisteNomById(Long id) {
		Connection connection = SingletonConnection.getConnection();
		String artiste = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT NOM FROM ARTISTE WHERE ID=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				
				artiste = rs.getString(1); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artiste;
	}

	@Override
	public Artiste updateArtiste(Artiste artiste) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("UPDATE ARTISTE SET NOM=?,PAYS=?,IMAGE=? WHERE ID=?");
			ps.setString(1, artiste.getNom());
			ps.setString(2, artiste.getPays());
			ps.setString(3, artiste.getImage());
			ps.setLong(4, artiste.getId());
			ps.executeUpdate();
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM ARTISTE");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				artiste.setId(rs.getLong("MAXID"));
			}
			
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return artiste;
	}

	@Override
	public void deleteArtiste(Long id) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("DELETE FROM ARTISTE WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public List<Artiste> artisteAffiche() {
		List<Artiste> artiste_array = new ArrayList<Artiste>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM ARTISTE ORDER BY NOM");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Artiste artiste = new Artiste();
				artiste.setId(rs.getLong(1)); 
				artiste.setNom(rs.getString(2)); 
				artiste.setPays(rs.getString(3)); 
				artiste.setImage(rs.getString(4));
				artiste_array.add(artiste);
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return artiste_array;
	}

}
