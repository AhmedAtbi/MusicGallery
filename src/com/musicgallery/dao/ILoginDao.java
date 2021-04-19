package com.musicgallery.dao;

import com.musicgallery.metier.User;

public interface ILoginDao {
	public boolean validate(User user);

	public boolean is_role_user(User user);

}
