package com.transporters.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EType")
public class EType implements DomainObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ETID")
	private Integer id;
	@Column(name="type")
	private String type;
	@Column(name="responsibilities")
	private String responsibilities;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id=id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

}
