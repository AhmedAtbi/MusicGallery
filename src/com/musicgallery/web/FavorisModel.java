package com.musicgallery.web;

import java.util.ArrayList;
import java.util.List;

import com.musicgallery.metier.Favoris;

public class FavorisModel {
	
	List<Favoris> modelFavoris = new ArrayList<Favoris>();

	public List<Favoris> getModelFavoris() {
		return modelFavoris;
	}

	public void setModelFavoris(List<Favoris> modelFavoris) {
		this.modelFavoris = modelFavoris;
	}

	public FavorisModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FavorisModel(List<Favoris> modelFavoris) {
		super();
		this.modelFavoris = modelFavoris;
	}
	
	

}
