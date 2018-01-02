package com.niit.DAO;

import java.util.List;


import com.niit.model.UserDetail;

public interface UserDAO {
	
	public boolean addUserDetail(UserDetail user);
	public boolean updateOnlineStatus(String status, UserDetail user);
	public UserDetail getByEmail(String email);
	public List<UserDetail> getAllUserDetails();
	public UserDetail getUserDetails(String username);
	public boolean checkLogin (UserDetail userDetail);
	

}
