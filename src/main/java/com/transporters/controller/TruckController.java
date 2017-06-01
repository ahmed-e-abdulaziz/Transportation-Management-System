package com.transporters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.transporters.domain.Truck;
import com.transporters.services.TruckService;

@Controller
@RequestMapping("/truck")
public class TruckController {

	@Autowired
	TruckService truckService;

	public TruckService getTruckService() {
		return truckService;
	}

	public void setTruckService(TruckService truckService) {
		this.truckService = truckService;
	}

	@RequestMapping({"","/","/list"})
	@SuppressWarnings("unchecked")
	public String list(Model model){
		List<Truck> trucks = (List<Truck>) this.truckService.listAll();
		model.addAttribute("trucks",trucks);
		return "truck/list";
	}
	@RequestMapping("/show/{id}")
	public String show(@PathVariable Integer id,Model model){
		Truck truck = this.truckService.getById(id);
		model.addAttribute("truck",truck);
		return "truck/truckinfo";
	}
	@RequestMapping(value={"/form"},method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("truck",new Truck());
		return "truck/form";
	}
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String addOrUpdate(Truck truck){
		Truck returnedTruck;
		if(truck.getId()==null){returnedTruck=truckService.save(truck);}
		else{returnedTruck=truckService.update(truck);}
		return "redirect:show/"+returnedTruck.getId();
	}
	@RequestMapping(value="/edit/{id}")
	public String edit(@PathVariable Integer id,Model model){
		model.addAttribute("truck",truckService.getById(id));
		return "truck/form";
	}
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable Integer id){
		truckService.delete(id);
		return "redirect:list/";
	}
	@RequestMapping(value="/list/json/available/{truckid}",produces="application/json")
	public @ResponseBody List<Truck> availableTrucksWithDriverTruck(@PathVariable Integer truckid){
		List<Truck> availableTrucks=null;
		if(truckid>0){
		availableTrucks=truckService.listAvailableWithDriverTruck(truckid);
				}
		return availableTrucks;
	}
	@RequestMapping(value="/list/json/available",produces="application/json")
	public @ResponseBody List<Truck> availableTrucks(){
		List<Truck> availableTrucks=truckService.listAvailable();
		return availableTrucks;
	}
}
