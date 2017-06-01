package com.transporters.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="Employee")
@PrimaryKeyJoinColumn(name="UID")  
public class Employee extends User {

	@Column(name="salary")
	private BigDecimal Salary;

	@ManyToOne
	@JoinColumn(name="BranchID",nullable=true)
	private Branch branch;	
	@ManyToOne
	@JoinColumn(name="ManagerID",nullable=true)
	@JsonBackReference 
	private Employee manager;
	
	public BigDecimal getSalary() {
		return Salary;
	}
	public void setSalary(BigDecimal salary) {
		Salary = salary;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}

	
}
