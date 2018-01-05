
package com.niit.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.ForumDAO;

import com.niit.model.Forum;
import com.niit.model.UserDetail;

@RestController
public class ForumController {
	
	@Autowired
	private ForumDAO forumDAO;
	
	@PostMapping(value="/insertForum")
	public ResponseEntity<String> insertForum(@RequestBody Forum forum,HttpSession session)
	{
		//UserDetail userDetail=(UserDetail)Session.getAttribute("üser");
		
		//forum.setUserId(userDetail.getUser_Id());
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("A");
		if(forumDAO.addForum(forum)){
			return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Exception arised",HttpStatus.SERVICE_UNAVAILABLE);
	    }
	}
	
	@RequestMapping(value="/getAllForums")
	public ResponseEntity<ArrayList<Forum>> getAllForums()
	{
		ArrayList listForums = (ArrayList)forumDAO.getAllForums();
		return new ResponseEntity<ArrayList<Forum>>(listForums,HttpStatus.OK);
	}
	
	 @GetMapping("/deleteForum/{forumId}")
	 public ResponseEntity<String> deleteForum(@PathVariable("forumId") int forumId) {
		Forum tempforum = forumDAO.getForum(forumId);
		System.out.println("deletion in forum");
		if (forumDAO.deleteForum(tempforum)) 
		{			
			return new ResponseEntity<String>("forum deleted", HttpStatus.OK);
		} 
		else
		{
			return new ResponseEntity<String>("problem deleting forum", HttpStatus.METHOD_FAILURE);
		}
	}
	@PostMapping(value="/updateForum")
	public ResponseEntity<String> updateForum(@RequestBody Forum forum)
	{
		Forum tempForum=forumDAO.getForum(forum.getForumId());
		
		tempForum.setForumName(forum.getForumName());
		tempForum.setForumContent(forum.getForumContent());
		
		if(forumDAO.updateForum(tempForum))	
		{
			return new ResponseEntity<String>("forum updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("problem in updating forum",HttpStatus.METHOD_FAILURE);
		}
		
	}
	
}