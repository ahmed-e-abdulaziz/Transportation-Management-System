package com.transporters.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transporters.dao.BranchDAO;
import com.transporters.dao.DriverDAO;
import com.transporters.dao.EmployeeDAO;
import com.transporters.dao.TruckDAO;
import com.transporters.dao.UTypeDAO;
import com.transporters.domain.Driver;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverDAO driverDAO;

	@Autowired
	UTypeDAO uTypeDAO;

	@Autowired
	TruckDAO truckDAO;
	
	@Autowired
	BranchDAO branchDAO;
		
	@Autowired
	EmployeeDAO employeeDAO;
	public DriverDAO getDriverDAO() {
		return driverDAO;
	}

	public void setDriverDAO(DriverDAO driverDAO) {
		this.driverDAO = driverDAO;
	}
	
	public UTypeDAO getUTypeDAO() {
		return uTypeDAO;
	}

	public void setUTypeDAO(UTypeDAO uTypeDAO) {
		this.uTypeDAO = uTypeDAO;
	}

	public TruckDAO getTruckDAO() {
		return truckDAO;
	}

	public void setTruckDAO(TruckDAO truckDAO) {
		this.truckDAO = truckDAO;
	}

	public BranchDAO getBranchDAO() {
		return branchDAO;
	}

	public void setBranchDAO(BranchDAO branchDAO) {
		this.branchDAO = branchDAO;
	}
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<?> listAll() {
		return driverDAO.listAll();
	}

	@Override
	@Transactional
	public Driver getById(Integer id) {
		return driverDAO.getById(id);
	}

	@Override
	@Transactional
	public Driver save(Driver domainObject) {
		domainObject.setBranch(branchDAO.getById(domainObject.getBranch().getId()));
		domainObject.setTruck(truckDAO.getById(domainObject.getTruck().getId()));
		domainObject.setManager(employeeDAO.getById(domainObject.getManager().getId()));
		domainObject.setUtype(uTypeDAO.getByName("Driver"));
		domainObject.setSalary(new BigDecimal(0));
		return driverDAO.save(domainObject);
	}

	@Override
	@Transactional
	public Driver update(Driver domainObject) {
		domainObject.setBranch(branchDAO.getById(domainObject.getBranch().getId()));
		domainObject.setTruck(truckDAO.getById(domainObject.getTruck().getId()));
		domainObject.setManager(employeeDAO.getById(domainObject.getManager().getId()));
		domainObject.setUtype(uTypeDAO.getByName("Driver"));
		domainObject.setSalary(new BigDecimal(0));
		return driverDAO.update(domainObject);
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		return driverDAO.delete(id);
	}

}
