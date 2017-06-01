package com.transporters.services;

import java.util.List;

import com.transporters.domain.Employee;
import com.transporters.domain.UType;

public interface EmployeeService extends CRUDService<Employee> {
	
	List<Employee> listAllCandidateBranchManager();
 
	List<Employee> listAllExcept(String[] uTypeName);

	List<Employee> listOnly(String[] uTypeName);

	List<UType> listEmpTypes();
	
	List<UType> listEmpTypes(String[] execlusions);
}
