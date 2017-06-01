package com.transporters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.transporters.domain.Branch;
import com.transporters.services.BranchGraphService;
import com.transporters.services.BranchService;

@Controller
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@Autowired
	BranchGraphService branchGraphService;
	
	public BranchService getBranchService() {
		return branchService;
	}

	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}
	
	public BranchGraphService getBranchGraphService() {
		return branchGraphService;
	}

	public void setBranchGraphService(BranchGraphService branchGraphService) {
		this.branchGraphService = branchGraphService;
	}

	@RequestMapping("/show/{id}")
	public String show(@PathVariable Integer id,Model model){
		model.addAttribute("branch",branchService.getById(id));
		return "branch/branchinfo";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model) {
		Branch branch = new Branch();
		model.addAttribute(branch);
		return "branch/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String addOrUpdate(Branch branch) {
		Branch returnedBranch;
		if(branch.getId()==null){
			returnedBranch=branchService.save(branch);
			}
		else{
			returnedBranch=branchService.update(branch);
			}
		return "redirect:show/"+returnedBranch.getId();
	}

	@RequestMapping(value={"/list","/",""})
	public String list(Model model) {
		model.addAttribute("branches",branchService.listAll());
		return "branch/list";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Integer id,Model model){
		model.addAttribute("branch",branchService.getById(id));
		return "branch/form";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,Model model){
		//TODO handle if branch was not deleted
		branchService.delete(id);
		return "redirect:/branch/list";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value={"/list/json"},produces="application/json")
	public @ResponseBody List<Branch> listBranchJSON(Model model) {
		return (List<Branch>) branchService.listAll();
	}
	
	@RequestMapping("/test")
	public String test(){
		branchGraphService.createGraph();
		return "index";
	}
}
