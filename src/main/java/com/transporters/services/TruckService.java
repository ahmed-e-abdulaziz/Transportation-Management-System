package com.transporters.services;

import java.util.List;

import com.transporters.domain.Truck;

public interface TruckService extends CRUDService<Truck> {

	List<Truck> listAvailable();

	List<Truck> listAvailableWithDriverTruck(Integer truckid);
 
}
