package com.musicgallery.web;

import java.util.ArrayList;
import java.util.List;


import com.musicgallery.metier.User;

public class UserModel {
	private String motCle;
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	private List<User> users = new ArrayList<User>();
	public UserModel(String motCle, List<User> users) {
		super();
		this.motCle = motCle;
		this.users = users;
	}

}
