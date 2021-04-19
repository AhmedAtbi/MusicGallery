package com.musicgallery.dao;

import com.musicgallery.metier.Artiste;
import com.musicgallery.metier.Categorie;

public class TestDao {
	

	public static void main(String[] args) {
		CategorieDao daoCat = new CategorieDao();
		ArtisteDao daoArt = new ArtisteDao();
		
		Categorie categorie1 = daoCat.ajoutCategorie(new Categorie ("Metal","Hard rock"));
		Artiste artiste1 = daoArt.ajoutArtiste(new Artiste ("HEDI","HABOUBA"));
		
		System.out.println(categorie1.toString());
		System.out.println(artiste1.toString());

		
		
		
	}

}
