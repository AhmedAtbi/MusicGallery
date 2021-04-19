package com.musicgallery.metier;

public class Favoris {
	
	private int id,id_titre,id_user;

	public Favoris(int id_user,int id_titre) {
		super();
		this.id_titre = id_titre;
		this.id_user = id_user;
	}

	public Favoris() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_titre() {
		return id_titre;
	}

	public void setId_titre(int id_titre) {
		this.id_titre = id_titre;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

}
