package com.transporters.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transporters.dao.CustomerDAO;
import com.transporters.dao.UTypeDAO;
import com.transporters.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	UTypeDAO uTypeDAO;
	
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	public UTypeDAO getUTypeDAO() {
		return uTypeDAO;
	}

	public void setUTypeDAO(UTypeDAO uTypeDAO) {
		this.uTypeDAO = uTypeDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Customer>listAll() {
		return (List<Customer>) this.customerDAO.listAll();
	}

	@Override
	@Transactional
	public Customer getById(Integer id) {
		return this.customerDAO.getById(id);
	}

	@Override
	@Transactional
	public Customer save(Customer domainObject) {
		domainObject.setCredit(new BigDecimal(0));
		domainObject.setJoinDate(new Date());
		domainObject.setUtype(uTypeDAO.getByName("Customer"));
		domainObject.setImageUrl("C:\\imageRepo\\1.jpg");
		return this.customerDAO.save(domainObject);
	}

	@Override
	@Transactional
	public Customer update(Customer domainObject) {
		Customer originalCustomer = customerDAO.getById(domainObject.getId());
		domainObject.setCredit(originalCustomer.getCredit());
		domainObject.setJoinDate(originalCustomer.getJoinDate());
		domainObject.setUtype(originalCustomer.getUtype());
		domainObject.setImageUrl(originalCustomer.getImageUrl());
		originalCustomer=domainObject;
		return this.customerDAO.update(domainObject);
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		return this.customerDAO.delete(id);
	}

}
