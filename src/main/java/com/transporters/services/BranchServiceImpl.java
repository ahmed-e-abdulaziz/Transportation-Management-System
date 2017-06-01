package com.transporters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transporters.dao.BranchDAO;
import com.transporters.dao.UTypeDAO;
import com.transporters.dao.EmployeeDAO;
import com.transporters.domain.Branch;
import com.transporters.domain.UType;
import com.transporters.domain.Employee;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	BranchDAO branchDAO;

	@Autowired
	EmployeeDAO employeeDAO;

	@Autowired
	UTypeDAO uTypeDAO;

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public BranchDAO getBranchDAO() {
		return branchDAO;
	}

	public void setBranchDAO(BranchDAO branchDAO) {
		this.branchDAO = branchDAO;
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
	public List<Branch> listAll() {
		return (List<Branch>) branchDAO.listAll();
	}

	@Override
	@Transactional
	public Branch getById(Integer id) {
		return branchDAO.getById(id);
	}

	@Override
	@Transactional
	public Branch save(Branch domainObject) {
		UType branchManagerType = uTypeDAO.getByName("BranchManager");
		Employee choosenManager = employeeDAO.getById(domainObject.getManager().getId());
		choosenManager.setBranch(domainObject);
		choosenManager.setUtype(branchManagerType);
		
		
		domainObject.setManager(choosenManager);
		Branch savedBranch = branchDAO.save(domainObject);
		
		employeeDAO.save(choosenManager);
		return savedBranch;
	}

	@Override
	@Transactional
	public Branch update(Branch domainObject) {
		//Update old manager branch manager type to Other
		UType otherUType = uTypeDAO.getByName("OtherUser");
		Employee oldManager = branchDAO.getById(domainObject.getId()).getManager();
		oldManager.setUtype(otherUType);
		
		//Get the new manager from database and set it to the branch to fill its attribute
		Employee choosenManager = employeeDAO.getById(domainObject.getManager().getId());
		
		//Set the new manager type to Branch Manager
		UType branchManagerType = uTypeDAO.getByName("BranchManager");
		choosenManager.setUtype(branchManagerType);
		
		//Update the Branch with the new Manager
		domainObject.setManager(choosenManager);
		choosenManager.setBranch(domainObject);
		oldManager.setBranch(domainObject);

		choosenManager = employeeDAO.update(choosenManager);
		employeeDAO.update(oldManager);
		domainObject.setManager(choosenManager);
		Branch updatedBranch = branchDAO.update(domainObject);
		return updatedBranch;
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		UType otherUType = uTypeDAO.getByName("Other");
		Employee managerToBeOtherEmployee=employeeDAO.getById(branchDAO.getById(id).getManager().getId());
		managerToBeOtherEmployee.setUtype(otherUType);
		boolean resultStatus=branchDAO.delete(id);
		managerToBeOtherEmployee.setBranch(branchDAO.getById(1));
		return resultStatus;
	}
}
