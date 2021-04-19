package com.musicgallery.metier;

import java.io.Serializable;


public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String email,password,nom,sex,role,date_naissance;
	
	
	
	
	public User() {
		
	}
	public User(String email, String password, String nom, String sex, String date_naissance,String role) {
		super();
		this.role=role;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.sex = sex;
		this.date_naissance = date_naissance;
	}
	
	
	public User(String email, String password, String nom, String sex, String date_naissance) {
		super();
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.sex = sex;
		this.date_naissance = date_naissance;
	}
	public User(Long id, String email, String password, String nom, String sex, String date_naissance) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.sex = sex;
		this.date_naissance = date_naissance;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	

}
