package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.model.UserDetail;
@Repository("userDAO")

public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean updateOnlineStatus(String status, UserDetail user)
	{
		try
		{
		user.setIsOnline(status);
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:" +e);
		return false;
		}	
	}
	
	@Transactional
	public boolean addUserDetail(UserDetail user) {
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:" +e);
		return false;
		}	
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserDetail> getAllUserDetails() {
	Session session=sessionFactory.openSession();
	List<UserDetail> user=(List<UserDetail>)session.createQuery("from UserDetail").list();
	session.close();
	return user;
	}

    @Transactional
	public UserDetail getUserDetails(String username) {
		Session session=sessionFactory.openSession();
		UserDetail user=(UserDetail)session.get(UserDetail.class,username);
		session.close();
		return user;
	}
    @Transactional
	public UserDetail getByEmail(String email) 
    {
			return (UserDetail)sessionFactory.getCurrentSession().get(UserDetail.class, email);
	}
    
    @Transactional
    public boolean checkLogin(UserDetail userDetail) {
	try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from User where email=:email and password=:paswrd");
			query.setParameter("email",userDetail.getEmailId());
			query.setParameter("paswrd",userDetail.getPassword());
			UserDetail user=(UserDetail)query.list().get(0);
			if(user==null)
			{
				return false;
			}
			else
			{
				return true;
			}
	     	}     catch(Exception e){
			    
	     		return false;
		}
	}
	}

