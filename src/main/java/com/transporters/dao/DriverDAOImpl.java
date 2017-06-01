package com.transporters.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transporters.domain.Driver;

@Repository
public class DriverDAOImpl implements DriverDAO {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Driver> listAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Driver> drivers= (List<Driver>) session.createCriteria(Driver.class).list();
		return drivers;
	}

	@Override
	public Driver getById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Driver driver = (Driver) session.get(Driver.class, id);
		return driver;
	}

	@Override
	public Driver save(Driver domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		Integer newId = (Integer) session.save(domainObject);
		Driver returnedDriver = (Driver) session.get(Driver.class, newId);
		return returnedDriver;
	}

	@Override
	public Driver update(Driver domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domainObject);
		Driver returnedDriver = (Driver) session.get(Driver.class, domainObject.getId());
		return returnedDriver;
	}

	@Override
	public boolean delete(Integer id) {
		try{
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(session.get(Driver.class, id));
		}
		catch(Exception ex){
			//TODO More descriptive exception and logging for error
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}
