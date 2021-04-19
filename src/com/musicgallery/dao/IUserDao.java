package com.musicgallery.dao;

import java.util.List;



import com.musicgallery.metier.User;

public interface IUserDao {
	
	
	public User ajoutUser(User user);
	public List<User> userParMotCle(String mc);
	public User getUser(int id);
	public User updateUser(User user);
	public void deleteUser(Long id);
	public int getUserId(String email);
	public int getUserID(String email);

}
