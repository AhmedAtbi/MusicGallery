package com.musicgallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.musicgallery.metier.Favoris;
import com.musicgallery.metier.Titre;

public class FavorisDao implements IFavorisDao{

	@Override
	public void ajoutFavoris(Titre titre, int id_user) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("INSERT INTO FAVORIS (ID_TITRE,ID_USER) VALUES (?,?)");
			ps.setLong(1, titre.getId());
			ps.setLong(2, id_user);
			ps.executeUpdate();	
			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@Override
	public void deleteFavoris(Titre titre, int id_user) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("DELETE FROM FAVORIS WHERE ID_TITRE=? AND ID_USER=?");
			ps.setLong(1, titre.getId());
			ps.setLong(2, id_user);
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Favoris> getFavoris(int id_user) {
		List<Favoris> favoris_array = new ArrayList<Favoris>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM FAVORIS WHERE ID_USER=?");
			ps.setInt(1, id_user);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Favoris favoris = new Favoris();
				favoris.setId(rs.getInt("ID")); 
				favoris.setId_user(rs.getInt("ID_TITRE")); 
				favoris.setId_titre(rs.getInt("ID_USER")); 


				favoris_array.add(favoris);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return favoris_array;
	}

	@Override
	public List<Favoris> getFavoris() {
		List<Favoris> favoris_array = new ArrayList<Favoris>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM FAVORIS");
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Favoris favoris = new Favoris();
				favoris.setId(rs.getInt("ID")); 
				favoris.setId_user(rs.getInt("ID_USER")); 
				favoris.setId_titre(rs.getInt("ID_TITRE")); 


				favoris_array.add(favoris);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return favoris_array;
	}

}
