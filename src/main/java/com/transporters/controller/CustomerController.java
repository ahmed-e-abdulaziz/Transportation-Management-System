package com.transporters.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.transporters.domain.Customer;
import com.transporters.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = { "/register", "/form" }, method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/form";
	}

	@RequestMapping({"/list","","/"})
	public String list(Model model) {
		model.addAttribute("customers", customerService.listAll());
		return "customer/list";
	}

	@RequestMapping("/show/{id}")
	public String show(@PathVariable Integer id, Model model) {
		model.addAttribute("customer", customerService.getById(id));
		return "customer/customerprofile";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String addOrUpdate(Customer customer) {
		Customer returnedCustomer;
		if (customer.getId() == null) {
			returnedCustomer = customerService.save(customer);
		} else {
			returnedCustomer = customerService.update(customer);
		}
		return "redirect:show/" + returnedCustomer.getId();
	}
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id,Model model) {
		
		model.addAttribute("customer",customerService.getById(id));
		return "customer/form";
	}
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		customerService.delete(id);
		return "redirect:/customer/list";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
