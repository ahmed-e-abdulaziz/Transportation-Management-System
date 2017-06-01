package com.transporters.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transporters.domain.Employee;
 
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

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
	public List<Employee> listAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employees = (List<Employee>) session.createCriteria(Employee.class).list();
		return employees;
	}

	@Override
	public Employee getById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;
	}

	@Override
	public Employee save(Employee domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		Serializable newId = session.save(domainObject);
		Employee insertedEmployee = (Employee) session.get(Employee.class,newId);
		return insertedEmployee;	
	}

	@Override
	public Employee update(Employee domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domainObject);
		Employee insertedEmployee = (Employee) session.get(Employee.class, domainObject.getId());
		return insertedEmployee;	
	}

	@Override
	public boolean delete(Integer id) {
		try{
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(session.get(Employee.class, id));
		}
		catch(Exception ex){
			//TODO More descriptive exception and logging for error
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}
