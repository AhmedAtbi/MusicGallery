package com.musicgallery.metier;

import java.io.Serializable;

public class Album implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom;
	private int artiste;
	private int categorie;
	private String image;
	public Album() {
		
	}
	public Album(String nom, String image, int artiste, int categorie) {
		this.nom = nom;
		this.artiste = artiste;
		this.categorie = categorie;
		this.image = image;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", nom=" + nom + ", artiste=" + artiste + ", categorie=" + categorie
				+ ", image=" + image + "]";
	}
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
	public int getArtiste() {
		return artiste;
	}
	public void setArtiste(int artiste) {
		this.artiste = artiste;
	}
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}
