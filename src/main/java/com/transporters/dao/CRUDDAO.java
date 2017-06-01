package com.transporters.dao;

import java.util.List;

import org.hibernate.SessionFactory;

public interface CRUDDAO<T> {
	
	public SessionFactory getSessionFactory();
	public void setSessionFactory(SessionFactory sessionFactory);
	
	List<?> listAll();
	
	T getById(Integer id);
	
	T save(T domainObject);
	
	T update(T domainObject);
	
	boolean delete(Integer id);
}
