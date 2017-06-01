package com.transporters.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRUCK")
public class Truck implements DomainObject {

	@Id
	@Column(name="TID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="Plate")
	private String plate;
	
	@ManyToOne
	@JoinColumn(name="Status")
	private TruckStatus status;
	@Column(name="MaxWeight")
	private Integer maxWeight;
	@Column(name="MaxLength")
	private Integer maxLength;
	@Column(name="MaxWidth")
	private Integer maxWidth;
	@Column(name="MaxHeight")
	private Integer maxHeight;
	
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public TruckStatus getStatus() {
		return status;
	}
	public void setStatus(TruckStatus status) {
		this.status = status;
	}
	public Integer getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(Integer maxWeight) {
		this.maxWeight = maxWeight;
	}
	public Integer getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	public Integer getMaxWidth() {
		return maxWidth;
	}
	public void setMaxWidth(Integer maxWidth) {
		this.maxWidth = maxWidth;
	}
	public Integer getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(Integer maxHeight) {
		this.maxHeight = maxHeight;
	}

}
