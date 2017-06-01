package com.transporters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.transporters.domain.Driver;
import com.transporters.services.DriverService;

@Controller
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	DriverService driverService;

	public DriverService getDriverService() {
		return driverService;
	}

	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}

	@RequestMapping({"/","","/list"})
	public String list(Model model){
		model.addAttribute("drivers",driverService.listAll());
		return "driver/list";
	}

	@RequestMapping("/show/{id}")
	public String show(@PathVariable Integer id,Model model){
		model.addAttribute("driver",driverService.getById(id));
		return "driver/driverprofile";
	}
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute(new Driver());
		return "driver/form";
	}
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String addOrUpdate(Driver driver){
		Driver returnedDriver;
		if(driver.getId()==null){
			returnedDriver=driverService.save(driver);
		}
		else{returnedDriver=driverService.update(driver);}
		
		return "redirect:show/"+returnedDriver.getId();
	}
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id,Model model) {
		
		model.addAttribute("driver",driverService.getById(id));
		return "driver/form";
	}
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		driverService.delete(id);
		return "redirect:/driver/list";
	}
	
}
