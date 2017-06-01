package com.transporters.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transporters.domain.Customer;
 
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
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
	public List<Customer> listAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customers = session.createCriteria(Customer.class).list();
		return customers;
	}

	@Override
	public Customer getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;
	}

	@Override
	public Customer save(Customer domainObject) {
		Session session = sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(domainObject);
		Customer insertedCustomer = (Customer) session.get(Customer.class,id);
		return insertedCustomer;
	}

	@Override
	public Customer update(Customer domainObject) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(domainObject);
		Customer updatedCustomer = (Customer) session.get(Customer.class, domainObject.getId());
		return updatedCustomer;
	}

	@Override
	public boolean delete(Integer id) {
		try{
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(session.get(Customer.class, id));
		}
		catch(Exception ex){
			//TODO More descriptive exception and logging for error
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}
