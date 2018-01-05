
package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.UserDAO;
import com.niit.model.UserDetail;

@RestController
public class UserController {


	@Autowired 
	UserDAO userDAO;
	
	
	@RequestMapping(value="/getAllUsers")
	public List <UserDetail> getAllUser(){
		return userDAO.getAllUserDetails();
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDetail userDetail){

		userDetail.setRole("user");
		if(userDAO.addUserDetail(userDetail))
		{
			
			return new ResponseEntity<UserDetail>(userDetail,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in registration",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
		@PostMapping("/login")
		public ResponseEntity<?> loginStatus(@RequestBody UserDetail userDetail,HttpSession session)
	{
			UserDetail user=userDAO.getUserDetails(userDetail.getUsername());
			//select * from UserDetails where username='';
			
			boolean userExists = userDAO.checkLogin(user.getUsername(), user.getPassword());
			
			
			
			System.out.println(userDetail.getUsername());
			
			System.out.print(userExists);
			
			if (userExists) 
			{
				userDAO.updateOnlineStatus("Y",user);
				session.setAttribute("username", user.getUsername());
				return new ResponseEntity<UserDetail>(user, HttpStatus.OK);
			} 
			else {
				Error error = new Error("unable to login user details");
				return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
		 
		}
	@GetMapping(value = "/logout/{username}")
	public ResponseEntity<String> loggingout(@PathVariable("username") String username) {
		UserDetail user = userDAO.getUserDetails(username);
		if (userDAO.updateOnlineStatus("N", user)) {
			return new ResponseEntity<String>("Successful logout", HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<String>("error in logout", HttpStatus.SERVICE_UNAVAILABLE);
		}
	
	}
}