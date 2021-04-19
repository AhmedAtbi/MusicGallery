package com.musicgallery.web;

import java.util.ArrayList;
import java.util.List;

import com.musicgallery.metier.Artiste;



public class ArtisteModel {
	
	private String motCle;
	private List<Artiste> artistes = new ArrayList<Artiste>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Artiste> getArtistes() {
		return artistes;
	}
	public void setArtistes(List<Artiste> artistes) {
		this.artistes = artistes;
	}
	public ArtisteModel(String motCle, List<Artiste> artistes) {
		super();
		this.motCle = motCle;
		this.artistes = artistes;
	}
	public ArtisteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
