package com.transporters.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transporters.dao.BranchDAO;
import com.transporters.dao.EmployeeDAO;
import com.transporters.dao.UTypeDAO;
import com.transporters.domain.Employee;
import com.transporters.domain.UType;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Autowired
	UTypeDAO uTypeDAO;
	
	@Autowired
	BranchDAO branchDAO;
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public UTypeDAO getUTypeDAO() {
		return uTypeDAO;
	}

	public void setUTypeDAO(UTypeDAO uTypeDAO) {
		this.uTypeDAO = uTypeDAO;
	}

	public BranchDAO getBranchDAO() {
		return branchDAO;
	}

	public void setBranchDAO(BranchDAO branchDAO) {
		this.branchDAO = branchDAO;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> listAll() {
		return (List<Employee>) this.employeeDAO.listAll();
	}

	@Override
	public Employee getById(Integer id) {
		return this.employeeDAO.getById(id);
	}

	@Override
	public Employee save(Employee domainObject) {
		domainObject.setBranch(branchDAO.getById(domainObject.getBranch().getId()));
		domainObject.setManager(employeeDAO.getById(domainObject.getManager().getId()));
		domainObject.setUtype(uTypeDAO.getById(domainObject.getUtype().getId()));
		domainObject.setSalary(new BigDecimal(0));
		return this.employeeDAO.save(domainObject);
	}

	@Override
	@Transactional
	public Employee update(Employee domainObject) {
		domainObject.setBranch(branchDAO.getById(domainObject.getBranch().getId()));
		domainObject.setManager(employeeDAO.getById(domainObject.getManager().getId()));
		domainObject.setUtype(uTypeDAO.getById(domainObject.getUtype().getId()));
		domainObject.setSalary(new BigDecimal(0));
		return this.employeeDAO.update(domainObject);
	}

	@Override
	public boolean delete(Integer id) {
		return this.employeeDAO.delete(id);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listAllCandidateBranchManager() {
		List<Employee> managers = (List<Employee>) this.employeeDAO.listAll();
		Iterator<Employee> managersIterator = managers.iterator();
		while (managersIterator.hasNext()) {
			Employee manager = managersIterator.next();
			if (manager.getUtype().getId() != uTypeDAO.getByName("OtherUser").getId()) {
				// System.out.println("BranchManager");
				System.out.println(manager.getUtype().getType());
				managersIterator.remove();
			}
		}
		return managers;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> listAllExcept(String[] uTypeName) {

		List<UType> execludedTypes = new ArrayList<>();
		for (int i = 0; i < uTypeName.length; i++) {
			execludedTypes.add(uTypeDAO.getByName(uTypeName[i]));
		}

		List<Employee> employees = (List<Employee>) this.employeeDAO.listAll();
		Iterator<Employee> employeesIterator = employees.iterator();
		while (employeesIterator.hasNext()) {
			Employee employee = employeesIterator.next();
			if (execludedTypes.contains(employee.getUtype())) {
				System.out.println(employee.getUtype().getType());
				employeesIterator.remove();
			}
		}

		return employees;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listOnly(String[] uTypeName) {
		List<UType> execludedTypes = new ArrayList<>();
		for (int i = 0; i < uTypeName.length; i++) {
			execludedTypes.add(uTypeDAO.getByName(uTypeName[i]));
		}

		List<Employee> employees = (List<Employee>) this.employeeDAO.listAll();
		Iterator<Employee> employeesIterator = employees.iterator();
		while (employeesIterator.hasNext()) {
			Employee employee = employeesIterator.next();
			if (!execludedTypes.contains(employee.getUtype())) {
				System.out.println(employee.getUtype().getType());
				employeesIterator.remove();
			}
		}
		return employees;
	}
	
	@Override
	public List<UType> listEmpTypes(){
		@SuppressWarnings("unchecked")
		List<UType> empTypes=(List<UType>) uTypeDAO.listAll();
		Iterator<UType> empIterator = empTypes.iterator();
		while(empIterator.hasNext()){
			UType empType = empIterator.next();
			if(empType.getType().equals("Admin")||empType.getType().equals("Customer")||empType.getType().equals("Driver")){
				empIterator.remove();
			}
		}
		return empTypes;
	}
	public List<UType> listEmpTypes(String[] execlusions){
		@SuppressWarnings("unchecked")
		List<UType> empTypes=(List<UType>) uTypeDAO.listAll();
		Iterator<UType> empIterator = empTypes.iterator();
		while(empIterator.hasNext()){
			UType empType = empIterator.next();
			if(empType.getType().equals("Admin")||empType.getType().equals("Customer")||Arrays.asList(execlusions).contains(empType.getType())){
				empIterator.remove();
			}
		} 
		return empTypes;
	}
}
