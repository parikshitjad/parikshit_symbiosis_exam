package com.employee.EmployeeDirectory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.EmployeeDirectory.model.Employee;
import com.employee.EmployeeDirectory.services.EmployeeServices;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class EmployeeController {
	@Autowired
	private EmployeeServices employeeservice;
	@GetMapping("/registerEmployee")
	public String regiStudent(Model model) {
	    model.addAttribute("employee",new Employee());
		return "employeeregistration";
	
	}
	@PostMapping("/employeestatus")
	public String getStatus(@Valid @ModelAttribute("employee") Employee student,BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "employeeregisteration";
		}
		employeeservice.saveRegistered(student);
		return "redirect:/employeelogin";
	}
}
	

