package com.transporters.dao;

import java.util.List;

import com.transporters.domain.Truck;

public interface TruckDAO extends CRUDDAO<Truck> {

	List<Truck> availableTrucks();

}
