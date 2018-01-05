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
	public boolean addUserDetail(UserDetail user) {
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:" +e);
		return false;
		}	
	}
    @Transactional
	public boolean updateOnlineStatus(String status, UserDetail user) {
		
		try{
			user.setStatus(status);
		sessionFactory.getCurrentSession().update(user);
			return true;
			
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:" +e);
		return false;
		}	
	}
	@Transactional
    public UserDetail getByEmail(String email) {
		String hql = "from UserDetail where email='" + email + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetail> list = query.list();

		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Transactional
	public List<UserDetail> getAllUserDetails() {
		Session session=sessionFactory.openSession();
		List<UserDetail> user=(List<UserDetail>)session.createQuery("from UserDetail").list();
		session.close();
		return user;
	}


    @Transactional
	public UserDetail getUserDetails(String username) {
    	String hql = "from UserDetail where username='" + username + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetail> list = query.list();

		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
    @Transactional
     public boolean checkLogin(String username, String password){
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from UserDetail as o where o.username=? and o.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,username);
		query.setParameter(1,password);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		session.close();
		return userFound;              
   }
}
