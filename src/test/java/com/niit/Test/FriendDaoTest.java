
package com.niit.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


import com.niit.DAO.FriendDAO;
import com.niit.config.DbConfig;
import com.niit.model.Friend;
@Ignore
@ComponentScan("com.niit.*")
public class FriendDaoTest {
	
    static FriendDAO  friendDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("com.niit");
		context.refresh();

	    friendDAO=(FriendDAO)context.getBean("friendDAO");
	}

	
	@Test
	public void addFriendTest() {
		Friend friend = new Friend();
		friend.setFriendId(23);
		friend.setFriendname("sunil");
		friend.setUsername("sunny");
		friend.setStatus("R");
		assertTrue("Problem in Inserting friend",friendDAO.createFriend(friend));
	}

	@Ignore
	@Test
	public void getAllFriendRequest() {
		List<Friend> listFriends = friendDAO.getAllFriendRequest("sunil");
		assertNotNull("problem in list friends", listFriends);
		for (Friend friend : listFriends) {
			System.out.println("current username:::" + friend.getUsername());
			System.out.println("friend name::::" + friend.getFriendname());
			System.out.println("status::::" + friend.getStatus());
		}

	}

	@Ignore
	@Test
	public void getFriendId() {
		Friend friend = (Friend) friendDAO.getFriend(23);
		assertNotNull("error", friend);
		System.out.println("friend status::::" + friend.getStatus());
	}
	
	/*
	@Test
	public void getAllApprovedFriendTest() {
		List<Friend> listFriends = friendDAO.getApprovedFriends("sunil");
		assertNotNull("problem in listFriends", listFriends);
		for (Friend friend : listFriends) {
			System.out.println("current user name:::" + friend.getUsername());
			System.out.println("current friend name:" + friend.getFriendname());
			System.out.println("status:::" + friend.getStatus());
		}
	}
	*/
	@Ignore
	@Test
	public void approveFriendRequest()
	{
		Friend friend=friendDAO.getFriend(24);
		assertTrue("problem in approving",friendDAO.approveFriendRequest(friend));
	}
	
	@Ignore
	@Test
	public void rejectFriendRequest()
	{
		Friend friend=friendDAO.getFriend(5);
		assertTrue("problem in approving",friendDAO.rejectFriendRequest(friend));
	}
}