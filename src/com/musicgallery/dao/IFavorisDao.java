package com.musicgallery.dao;

import java.util.List;

import com.musicgallery.metier.Favoris;
import com.musicgallery.metier.Titre;

public interface IFavorisDao {
	
	public void ajoutFavoris(Titre titre,int id_user);
	public void deleteFavoris(Titre titre,int id_user);
	public List<Favoris> getFavoris(int id_user);
	public List<Favoris> getFavoris();
	
	

}
