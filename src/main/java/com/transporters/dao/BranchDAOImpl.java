package com.transporters.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transporters.domain.Branch;

@Repository
public class BranchDAOImpl implements BranchDAO{

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
	public List<Branch> listAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Branch> branches = (List<Branch>) session.createCriteria(Branch.class).list();
		return branches;
	}

	@Override
	public Branch getById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Branch branch = (Branch) session.get(Branch.class, id);
		return branch;
	}

	@Override
	public Branch save(Branch domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		Serializable newId = session.save(domainObject);
		Branch insertedBranch = (Branch) session.get(Branch.class,newId);
		return insertedBranch;	
	}

	@Override
	public Branch update(Branch domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(domainObject);
		Branch insertedBranch = (Branch) session.get(Branch.class, domainObject.getId());
		return insertedBranch;	
	}

	@Override
	public boolean delete(Integer id) {
		try{
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(session.get(Branch.class, id));
		}
		catch(Exception ex){
			//TODO More descriptive exception and logging for error
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}
