package com.niit.DAO;

import com.niit.model.ProfilePicture;

public interface ProfilePictureDAO {

	public boolean save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
