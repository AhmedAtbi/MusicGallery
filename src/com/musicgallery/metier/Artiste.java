package com.musicgallery.metier;

public class Artiste {
	
	private Long id;
	private String nom;
	private String pays;
	private String image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Artiste(Long id,String nom, String pays,String image) {
		super();
		this.id = id;
		this.nom = nom;
		this.pays = pays;
		this.image = image;
	}
	
	
	public Artiste(String nom, String pays,String image) {
		super();
		this.nom = nom;
		this.pays = pays;
	}
	@Override
	public String toString() {
		return "Artiste [id=" + id + ", nom=" + nom + ", pays=" + pays + "]";
	}
	public Artiste() {
		
	}
	public Artiste(String nom, String pays) {
		
		this.nom = nom;
		this.pays = pays;
	}
	

}
