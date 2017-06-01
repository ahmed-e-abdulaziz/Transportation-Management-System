package com.transporters.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="BRANCH")
public class Branch implements DomainObject{
	
	@Id
	@Column(name="BrID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToOne
	@JoinColumn(name="ManagerID",referencedColumnName="UID",nullable=true)
	@JsonBackReference 
	private Employee manager;
	
	@Column(name="phone")
	private String phoneLandline;
	
	@Column(name="mobile")
	private String phoneMobile;
	 
	@Column(name="latitude")
	private float latitude;
	
	@Column(name="longitude")
	private float longitude;
	
	@Column(name="maxOrdersPerDay")
	private Integer maxOrdersPerDay;
	 
	public Branch(){
		manager=new Employee();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneLandline() {
		return phoneLandline;
	}
	public void setPhoneLandline(String phoneLandline) {
		this.phoneLandline = phoneLandline;
	}
	public String getPhoneMobile() {
		return phoneMobile;
	}
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public Integer getMaxOrdersPerDay() {
		return maxOrdersPerDay;
	}
	public void setMaxOrdersPerDay(Integer maxOrdersPerDay) {
		this.maxOrdersPerDay = maxOrdersPerDay;
	}
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id=id;
	}
	
	
	
}
