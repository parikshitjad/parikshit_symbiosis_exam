package com.employee.EmployeeDirectory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.EmployeeDirectory.model.Employee;
import com.employee.EmployeeDirectory.services.EmployeeServices;

import jakarta.validation.Valid;

@Controller
public class LoginController {

	@Autowired
	private EmployeeServices employeeServcices;
	
	@Autowired
	private EmployeeServices employeeservice;
	
	@GetMapping("/employeelogin")
	public String getLogin(Model model) {
		model.addAttribute("employeehome", new Object());
		return "employeehome";
	}
	
	@PostMapping("/employeeloginstatus")
	public String getlogstatus(@Valid @ModelAttribute("employeehome") Employee employeehome, BindingResult bindResult,Model model) {
		if(bindResult.hasErrors()) {
			return "employeehome";
		}
		
		List<Employee> dbemployeeList = employeeservice.employeeList();
		boolean found = false;
		
		for (Employee dbv : dbemployeeList) {
			if(dbv.getName().equals(employeehome.getName())&&dbv.getPassword().equals(employeehome.getPassword())) {
				found=true;
            }
		}
		if(found) {
			return "employeedashboard";
		}
		else {
			model.addAttribute("error","Incorrect username or password");
			return "employeehome";
		}
	}
}