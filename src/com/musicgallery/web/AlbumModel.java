package com.musicgallery.web;

import java.util.ArrayList;
import java.util.List;

import com.musicgallery.metier.Album;

public class AlbumModel {

	private String motCle;
	private List<Album> albums = new ArrayList<Album>();
	public AlbumModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlbumModel(String motCle, List<Album> albums) {
		super();
		this.motCle = motCle;
		this.albums = albums;
	}
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
}
