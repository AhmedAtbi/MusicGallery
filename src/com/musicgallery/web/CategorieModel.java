package com.musicgallery.web;

import java.util.ArrayList;
import java.util.List;

import com.musicgallery.metier.Categorie;

public class CategorieModel {
	
	private String motCle;
	private List<Categorie> categories = new ArrayList<Categorie>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Categorie> getCategories() {
		return categories;
	}
	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	public CategorieModel(String motCle, List<Categorie> categories) {
		super();
		this.motCle = motCle;
		this.categories = categories;
	}
	public CategorieModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
