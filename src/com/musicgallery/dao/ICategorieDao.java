package com.musicgallery.dao;

import java.util.List;


import com.musicgallery.metier.Categorie;

public interface ICategorieDao {
	public Categorie ajoutCategorie(Categorie categorie);
	public List<Categorie> categorieParMotCle(String mc);
	public List<Categorie> categorieAffiche();
	public Categorie getCategorie(Long id);
	public Categorie updateCategorie(Categorie Categorie);
	public void deleteCategorie(Long id);

}
