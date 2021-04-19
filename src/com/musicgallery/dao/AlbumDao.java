package com.musicgallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicgallery.metier.Album;


public class AlbumDao implements IAlbumDao{

	@Override
	public Album ajoutAlbum(Album album) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("INSERT INTO ALBUM (NOM,IMAGE,ID_ARTISTE,ID_CATEGORIE) VALUES (?,?,?,?)");
			ps.setString(1, album.getNom());
			ps.setString(2, album.getImage());
			ps.setInt(3, album.getArtiste());
			ps.setInt(4, album.getCategorie());
			
			
			ps.executeUpdate();
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM ALBUM");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				album.setId(rs.getLong("MAXID"));
			}
			
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return album;
	}

	@Override
	public List<Album> albumParMotCle(String mc) {
		List<Album> album_array = new ArrayList<Album>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM ALBUM WHERE NOM LIKE ? ORDER BY NOM ");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Album album = new Album();
				album.setId(rs.getLong(1)); 
				album.setNom(rs.getString(2)); 
				album.setImage(rs.getString(3)); 
				album.setArtiste(rs.getInt(4));
				album.setCategorie(rs.getInt(5));
				
				album_array.add(album);
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return album_array;
	}
	
	@Override
	public List<Album> afficheAlbum() {
		List<Album> album_array = new ArrayList<Album>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM ALBUM ORDER BY NOM");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Album album = new Album();
				album.setId(rs.getLong(1)); 
				album.setNom(rs.getString(2)); 
				album.setImage(rs.getString(3)); 
				album.setArtiste(rs.getInt(4));
				album.setCategorie(rs.getInt(5));
				
				album_array.add(album);
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return album_array;
	}

	@Override
	public Album getAlbum(Long id) {
		Connection connection = SingletonConnection.getConnection();
		Album album = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM ALBUM WHERE ID=? ORDER BY NOM");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				album = new Album();
				album.setId(rs.getLong(1)); 
				album.setNom(rs.getString(2)); 
				album.setImage(rs.getString(3)); 
				album.setArtiste(rs.getInt(4));
				album.setCategorie(rs.getInt(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return album;
	}

	@Override
	public Album updateAlbum(Album album) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("UPDATE ALBUM SET NOM=?,IMAGE=?,ID_ARTISTE=?,ID_CATEGORIE=? WHERE ID=?");
			ps.setString(1, album.getNom());
			ps.setString(2, album.getImage());
			ps.setInt(3, album.getArtiste());
			ps.setInt(4, album.getCategorie());
			ps.setLong(5, album.getId());
			ps.executeUpdate();
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM ALBUM");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				album.setId(rs.getLong("MAXID"));
			}
			
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return album;
	}

	@Override
	public void deleteAlbum(Long id) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("DELETE FROM ALBUM WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Override
	public List<Album> afficheAlbumParArtiste (int id_artiste){
		List<Album> album_array = new ArrayList<Album>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM ALBUM WHERE ID_ARTISTE=? ORDER BY NOM");
			ps.setInt(1, id_artiste);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Album album = new Album();
				album.setId(rs.getLong(1)); 
				album.setNom(rs.getString(2)); 
				album.setImage(rs.getString(3)); 
				album.setArtiste(rs.getInt(4));
				album.setCategorie(rs.getInt(5));
				
				album_array.add(album);
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return album_array;
	}
	
	@Override
	public String getAlbumNomById(Long id) {
		Connection connection = SingletonConnection.getConnection();
		String album = "";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT NOM FROM ALBUM WHERE ID=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				
				album = rs.getString(1); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return album;
	}
	
	
	
	
	@Override
	public List<Album> afficheAlbumParCategorie (int id_categorie){
		List<Album> album_array = new ArrayList<Album>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM ALBUM WHERE ID_CATEGORIE=?");
			ps.setInt(1,id_categorie);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Album album = new Album();
				album.setId(rs.getLong(1)); 
				album.setNom(rs.getString(2)); 
				album.setImage(rs.getString(3)); 
				album.setArtiste(rs.getInt(4));
				album.setCategorie(rs.getInt(5));
				
				album_array.add(album);
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return album_array;
	}




}
