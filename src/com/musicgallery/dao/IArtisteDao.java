package com.musicgallery.dao;

import java.util.List;

import com.musicgallery.metier.Artiste;


public interface IArtisteDao {
	
	public Artiste ajoutArtiste(Artiste artiste);
	public List<Artiste> artisteParMotCle(String mc);
	public Artiste getArtiste(Long id);
	public List<Artiste> artisteAffiche();
	public Artiste updateArtiste(Artiste artiste);
	public void deleteArtiste(Long id);
	

}
