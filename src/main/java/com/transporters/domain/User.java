package com.transporters.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="USER")
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements DomainObject {
	
	@Id
	@Column(name="UID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="FirstName")
	private String firstName;

	@Column(name="LastName")
	private String lastName;

	@Column(name="MiddleName")
	private String middleName;

	@Column(name="Email")
	private String email;

	@Column(name="Password")
	private String password;
	
	@Column(name="DateOfBirth")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateOfBirth;

	@Column(name="RegisterationDate")
	private Date joinDate=new Date();

	@Embedded
	private Address address=new Address();
	
	@Column(name="Phone")
	private String phoneLandline;

	@Column(name="Mobile")
	private String phoneMobile;
	
	@Column(name="Photo")
	private String imageUrl="C:\\imageRepo\\1.jpg";
	
	@ManyToOne(optional=false)	
	@JoinColumn(name="usertype")
	private UType utype;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
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
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public UType getUtype() {
		return utype;
	}
	public void setUtype(UType utype) {
		this.utype = utype;
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
