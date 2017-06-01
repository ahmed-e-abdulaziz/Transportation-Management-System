package com.transporters.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transporters.domain.Truck;

@Repository
public class TruckDAOImpl implements TruckDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Truck> listAll() {
		Session session=this.sessionFactory.getCurrentSession();
		List<Truck> trucks = (List<Truck>) session.createCriteria(Truck.class).list();
		return trucks;
	}

	@Override
	public Truck getById(Integer id) {
		Session session=this.sessionFactory.getCurrentSession();
		Truck truck = (Truck) session.get(Truck.class, id);
		return truck;
	}

	@Override
	public Truck save(Truck domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		Integer enteredTruckId = (Integer) session.save(domainObject);
		Truck enteredTruck =  (Truck) session.get(Truck.class,enteredTruckId);
		return enteredTruck;
	}

	@Override
	public Truck update(Truck domainObject) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domainObject);
		Truck updatedTruck = (Truck) session.get(Truck.class, domainObject.getId());
		return updatedTruck;
	}

	@Override
	public boolean delete(Integer id) {
		try{
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(session.get(Truck.class, id));
		}
		catch(Exception ex){
			//TODO More descriptive exception and logging for error
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Truck> availableTrucks(){
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Truck as t where t not in (select truck from Driver)");
		List<Truck> availableTrucks = query.list();
		
		return availableTrucks;
	}
}
