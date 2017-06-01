package com.transporters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.transporters.domain.Employee;
import com.transporters.domain.UType;
import com.transporters.services.EmployeeService;

@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable Integer id,Model model){
		model.addAttribute("employee",employeeService.getById(id));
		return "employee/employeeprofile";
	}
	
	@RequestMapping({"","/","/list"})
	public String list(Model model){
		model.addAttribute("employees", employeeService.listAll());
		return "employee/list";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("employee",new Employee());
		return "employee/form";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String addOrUpdate(Employee employee){
		Employee returnedEmployee;
		if(employee.getId()==null){
			returnedEmployee=employeeService.save(employee);
		}
		else{
			returnedEmployee=employeeService.update(employee);
		}
		return "redirect:show/"+returnedEmployee.getId();
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Integer id,Model model){
		model.addAttribute("employee",employeeService.getById(id));
		return "employee/form";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		employeeService.delete(id);
		return "redirect:/employee/list";
	}
		
	@RequestMapping(value="/list/{condition}/{types}",produces="application/json")
	public @ResponseBody List<Employee> listAllConditionalJSON(@PathVariable String condition,@PathVariable String[] types){
		 
		List<Employee> employees=null;
		System.out.println(types);
		if(condition.equals("except")){
		employees=this.employeeService.listAllExcept(types);
		}
		else{
			if(condition.equals("only")){
				employees=this.employeeService.listOnly(types);
			}
		}
		for(Employee employee:employees){
			System.out.println(employee.getUtype().getType());
		}
		return employees;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/list",produces="application/json")
	public @ResponseBody List<Employee> listAllJSON(){
		List<Employee> employees;
		employees=(List<Employee>) this.employeeService.listAll();
		for(Employee employee:employees){
			System.out.println(employee.getUtype().getType());
		}
		return employees;
	}
	
	@RequestMapping(value="/types",produces="application/json")
	public @ResponseBody List<UType> listEmployeeTypes(){
		return employeeService.listEmpTypes();
	}
	
	@RequestMapping(value="/types/except/{execlusions}",produces="application/json")
	public @ResponseBody List<UType> listEmployeeTypes(@PathVariable String[] execlusions){
		return employeeService.listEmpTypes(execlusions);
	}
	
	
}
