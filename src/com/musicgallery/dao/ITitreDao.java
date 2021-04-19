package com.musicgallery.dao;

import java.util.List;

import com.musicgallery.metier.Titre;

public interface ITitreDao {
	
	public Titre ajoutTitre(Titre titre);
	public List<Titre> titreParMotCle(String mc);
	public Titre getTitre(int id);
	public Titre updateTitre(Titre titre);
	public void deleteTitre(int id);
	
	public List<Titre> afficheTitre();
	List<Titre> afficheTitreParCategorie(int id_categorie);
	List<Titre> afficheTitreParArtiste(int id_categorie);
	List<Titre> afficheTitreParAlbum(int id_album);

}
