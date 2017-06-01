package com.transporters.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="DRIVER")
@PrimaryKeyJoinColumn(name="UID")  
public class Driver extends Employee{
	
	@ManyToOne
	@JoinColumn(name="TruckID")
	private Truck truck;

	@Column(name="DrivingCard")
	private String drivingCard;
	
	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public String getDrivingCard() {
		return drivingCard;
	}

	public void setDrivingCard(String drivingCard) {
		this.drivingCard = drivingCard;
	}
}
