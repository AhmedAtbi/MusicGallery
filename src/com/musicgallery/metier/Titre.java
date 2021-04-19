package com.musicgallery.metier;

import java.io.Serializable;

public class Titre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom;
	private Long artiste;
	private Long categorie;
	private String duree;
	private Long album;
	private String url;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getArtiste() {
		return artiste;
	}
	public void setArtiste(Long artiste) {
		this.artiste = artiste;
	}
	public Long getCategorie() {
		return categorie;
	}
	public void setCategorie(Long categorie) {
		this.categorie = categorie;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public Long getAlbum() {
		return album;
	}
	public void setAlbum(Long album) {
		this.album = album;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Titre() {
		
	}
	
	
	@Override
	public String toString() {
		return "Titre [id=" + id + ", nom=" + nom + ", artiste=" + artiste + ", categorie=" + categorie + ", duree="
				+ duree + ", album=" + album + ", url=" + url + "]";
	}
	public Titre( String nom, String duree, String url, Long artiste, Long categorie,Long album) {
		super();
		
		this.nom = nom;
		this.artiste = artiste;
		this.categorie = categorie;
		this.duree = duree;
		this.album = album;
		this.url = url;
	}

}
