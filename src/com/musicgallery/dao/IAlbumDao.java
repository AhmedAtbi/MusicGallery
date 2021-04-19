package com.musicgallery.dao;

import java.util.List;

import com.musicgallery.metier.Album;

public interface IAlbumDao {
	
	public Album ajoutAlbum(Album album);
	public List<Album> albumParMotCle(String mc);
	public Album getAlbum(Long id);
	public Album updateAlbum(Album album);
	public void deleteAlbum(Long id);
	public String getAlbumNomById(Long id);
	public List<Album> afficheAlbum();
	List<Album> afficheAlbumParArtiste(int id_artiste);
	List<Album> afficheAlbumParCategorie(int id_categorie);

}
