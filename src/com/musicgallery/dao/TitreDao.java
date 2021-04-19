package com.musicgallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.musicgallery.metier.Titre;

public class TitreDao implements ITitreDao{

	@Override
	public Titre ajoutTitre(Titre titre) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("INSERT INTO TITRE (NOM,DUREE,URL,ID_CATEGORIE,ID_ARTISTE,ID_ALBUM) VALUES (?,?,?,?,?,?)");
			ps.setString(1, titre.getNom());
			ps.setString(2, titre.getDuree());
			ps.setString(3, titre.getUrl());
			ps.setLong(5, titre.getArtiste());
			ps.setLong(4, titre.getCategorie());
			ps.setLong(6, titre.getAlbum());


			ps.executeUpdate();
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM TITRE");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				titre.setId(rs.getLong("MAXID"));
			}

			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return titre;
	}

	@Override
	public List<Titre> titreParMotCle(String mc) {
		List<Titre> titre_array = new ArrayList<Titre>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM ALBUM WHERE NOM LIKE ? ORDER BY NOM");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Titre titre = new Titre();
				titre.setId(rs.getLong("ID")); 
				titre.setNom(rs.getString("NOM")); 
				titre.setDuree(rs.getString("DUREE")); 
				titre.setUrl(rs.getString("URL")); 
				titre.setArtiste(rs.getLong("ID_ARTISTE"));
				titre.setCategorie(rs.getLong("ID_CATEGORIE"));
				titre_array.add(titre);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titre_array;
	}



	@Override
	public List<Titre> afficheTitre() {
		List<Titre> titre_array = new ArrayList<Titre>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM TITRE ORDER BY NOM");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Titre titre = new Titre();
				titre.setId(rs.getLong("ID")); 
				titre.setNom(rs.getString("NOM")); 
				titre.setDuree(rs.getString("DUREE")); 
				titre.setUrl(rs.getString("URL")); 
				titre.setArtiste(rs.getLong("ID_ARTISTE"));
				titre.setCategorie(rs.getLong("ID_CATEGORIE"));
				titre.setAlbum(rs.getLong("ID_ALBUM"));
				titre_array.add(titre);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titre_array;
	}

	@Override
	public List<Titre> afficheTitreParCategorie (int id_categorie){
		List<Titre> titre_array = new ArrayList<Titre>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM TITRE WHERE ID_CATEGORIE=?");
			ps.setInt(1, id_categorie);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Titre titre = new Titre();
				titre.setId(rs.getLong("ID")); 
				titre.setNom(rs.getString("NOM")); 
				titre.setDuree(rs.getString("DUREE")); 
				titre.setUrl(rs.getString("URL")); 
				titre.setArtiste(rs.getLong("ID_ARTISTE"));
				titre.setCategorie(rs.getLong("ID_CATEGORIE"));
				titre_array.add(titre);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titre_array;
	}

	
	@Override
	public List<Titre> afficheTitreParArtiste (int id_categorie){
		List<Titre> titre_array = new ArrayList<Titre>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM TITRE WHERE ID_CATEGORIE=?");
			ps.setInt(1, id_categorie);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Titre titre = new Titre();
				titre.setId(rs.getLong("ID")); 
				titre.setNom(rs.getString("NOM")); 
				titre.setDuree(rs.getString("DUREE")); 
				titre.setUrl(rs.getString("URL")); 
				titre.setArtiste(rs.getLong("ID_ARTISTE"));
				titre.setCategorie(rs.getLong("ID_CATEGORIE"));
				titre_array.add(titre);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titre_array;
	}

	
	@Override
	public List<Titre> afficheTitreParAlbum (int id_album){
		List<Titre> titre_array = new ArrayList<Titre>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM TITRE WHERE ID_ARTISTE=?");
			ps.setInt(1, id_album);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Titre titre = new Titre();
				titre.setId(rs.getLong("ID")); 
				titre.setNom(rs.getString("NOM")); 
				titre.setDuree(rs.getString("DUREE")); 
				titre.setUrl(rs.getString("URL")); 
				titre.setArtiste(rs.getLong("ID_ARTISTE"));
				titre.setCategorie(rs.getLong("ID_CATEGORIE"));
				titre_array.add(titre);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titre_array;


	}

	@Override
	public Titre getTitre(int id) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		Titre titre = null;
		try {

			ps = connection.prepareStatement("SELECT * FROM TITRE WHERE ID=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				titre = new Titre();
				titre.setId(rs.getLong("ID")); 
				titre.setNom(rs.getString("NOM")); 
				titre.setDuree(rs.getString("DUREE")); 
				titre.setUrl(rs.getString("URL")); 
				titre.setArtiste(rs.getLong("ID_ARTISTE"));
				titre.setCategorie(rs.getLong("ID_CATEGORIE"));


			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titre;

	}

	@Override
	public Titre updateTitre(Titre titre) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("UPDATE TITRE SET NOM=?,DUREE=?,URL=?,ID_CATEGORIE=?,ID_ARTISTE=?,ID_ALBUM=? WHERE ID=?");
			ps.setString(1, titre.getNom());
			ps.setString(2, titre.getDuree());
			ps.setString(3, titre.getUrl());
			ps.setLong(4, titre.getCategorie());
			ps.setLong(5, titre.getArtiste());
			ps.setLong(6, titre.getAlbum());
			ps.setLong(7, titre.getId());


			ps.executeUpdate();
			PreparedStatement ps1 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM TITRE");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				titre.setId(rs.getLong("MAXID"));
			}

			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return titre;
	}

	@Override
	public void deleteTitre(int id) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("DELETE FROM TITRE WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}
