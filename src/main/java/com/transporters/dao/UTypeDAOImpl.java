package com.transporters.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transporters.domain.UType;

@Repository
public class UTypeDAOImpl implements UTypeDAO {

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
	public List<UType> listAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UType> etype = session.createCriteria(UType.class).list();
		return etype;
	}

	@Override
	public UType getById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		UType eType=(UType) session.get(UType.class,id);
		return eType;
	}
	
	@Override
	public UType getByName(String type) {
		String branchManagerType=type;
		Session session = this.sessionFactory.getCurrentSession();
		UType uType=(UType) session.createCriteria(UType.class).add(Restrictions.eq("type",branchManagerType)).uniqueResult();
		return uType;
	}
	
	@Override
	public UType save(UType domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		Integer newId = (Integer) session.save(domainObject);
		UType insertedEType = (UType) session.get(UType.class, newId);
		return insertedEType;
	}

	@Override
	public UType update(UType domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domainObject);
		UType insertedEType = (UType) session.get(UType.class, domainObject.getId());
		return insertedEType;
	}

	@Override
	public boolean delete(Integer id) {
		try{
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(session.get(UType.class, id));
		}
		catch(Exception ex){
			//TODO More descriptive exception and logging for error
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}
