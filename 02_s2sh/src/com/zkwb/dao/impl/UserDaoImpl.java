package com.zkwb.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zkwb.dao.UserDao;
import com.zkwb.entity.User;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	public void save(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		
		session.close();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
