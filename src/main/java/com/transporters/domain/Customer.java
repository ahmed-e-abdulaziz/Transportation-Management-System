package com.transporters.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="customer")
@PrimaryKeyJoinColumn(name="UID")  
public class Customer extends User {
	
	@Column(name="CREDIT")
	private BigDecimal credit=new BigDecimal(0);

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	
	
}
