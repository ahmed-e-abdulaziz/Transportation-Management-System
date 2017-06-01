package com.transporters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transporters.dao.TruckDAO;
import com.transporters.domain.Truck;

@Service
@Transactional
public class TruckServiceImpl implements TruckService{

	@Autowired
	TruckDAO truckDAO;
	
	public TruckDAO getTruckDAO() {
		return truckDAO;
	}

	public void setTruckDAO(TruckDAO truckDAO) {
		this.truckDAO = truckDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	
	public List<Truck> listAll() {
		return (List<Truck>) truckDAO.listAll();
	}

	@Override
	public Truck getById(Integer id) {
		return truckDAO.getById(id);
	}

	@Override
	public Truck save(Truck domainObject) {
		return truckDAO.save(domainObject);
	}

	@Override
	public Truck update(Truck domainObject) {
		return truckDAO.update(domainObject);
	}

	@Override
	public boolean delete(Integer id) {
		return truckDAO.delete(id);
	}
	@Override
	public  List<Truck> listAvailable(){
		return truckDAO.availableTrucks();
	}
	@Override
	public List<Truck> listAvailableWithDriverTruck(Integer truckid){
		List<Truck> trucks=truckDAO.availableTrucks();
		trucks.add(truckDAO.getById(truckid));
		return trucks;
	}

	
}
