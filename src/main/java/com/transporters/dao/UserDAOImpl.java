package com.transporters.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transporters.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> listAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> users= (List<User>) session.createCriteria(User.class).list();
		return users;
	}

	@Override
	public User getById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	@Override
	public User save(User domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		Serializable newId = session.save(domainObject);
		User user = (User) session.get(User.class,newId);
		return user;	
	}

	@Override
	public User update(User domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domainObject);
		User savedUser = (User) session.get(User.class, domainObject.getId());
		return savedUser;
	}

	@Override
	public boolean delete(Integer id) {
		try{
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(session.get(User.class, id));
		}
		catch(Exception ex){
			//TODO More descriptive exception and logging for error
			ex.printStackTrace();
			return false;
		}
		return true;
	}
 

}
