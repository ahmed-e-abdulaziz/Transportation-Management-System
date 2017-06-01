package com.transporters.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="truckstatus")
public class TruckStatus implements DomainObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idtruckstatus")
	private Integer id;
	@Column(name="statusType")
	private String type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
