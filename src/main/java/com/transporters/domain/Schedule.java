package com.transporters.domain;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component 
public class Schedule {
	
	//TODO Remember to add a table for this in the database, and change the schedule one in the database to ACTUALSCHEDULE
	private List<Branch> branches;
	private List<String> statuses;
	private Order order;
	private List<Date> beginDates;
	private List<Date> expectedEndDate;
	
	public List<Branch> getBranches() {
		return branches;
	}
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	public List<String> getStatuses() {
		return statuses;
	}
	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Date> getBeginDates() {
		return beginDates; 
	}
	public void setBeginDates(List<Date> beginDates) {
		this.beginDates = beginDates;
	}
	public List<Date> getExpectedEndDate() {
		return expectedEndDate;
	}
	public void setExpectedEndDate(List<Date> expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}
	
	
}
