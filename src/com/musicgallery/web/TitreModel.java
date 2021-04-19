package com.musicgallery.web;

import java.util.ArrayList;
import java.util.List;

import com.musicgallery.metier.Titre;

public class TitreModel {
	private String motCle;
	public TitreModel(String motCle, List<Titre> titres) {
		super();
		this.motCle = motCle;
		this.titres = titres;
	}
	public TitreModel() {
		// TODO Auto-generated constructor stub
	}
	private List<Titre> titres = new ArrayList<Titre>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Titre> getTitres() {
		return titres;
	}
	public void setTitres(List<Titre> titres) {
		this.titres = titres;
	}

}
