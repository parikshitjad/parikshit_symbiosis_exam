package com.task.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.voter.voterJpa.model.Admin;
import com.voter.voterJpa.model.adminHome;
import com.voter.voterJpa.service.AdminServices;

import jakarta.validation.Valid;

	@Controller
	@Transactional
	public class AdminLoginController {
		@Autowired
		private AdminServices adminservices;
		@GetMapping("/adminlogin")
		public String getLogin(Model model) {
			model.addAttribute("adminhome",new adminHome());
			return "adminhome";
			
		}
		@PostMapping("/adminloginstatus")
		public String getlogstatus(@Valid @ModelAttribute("adminhome") adminHome adminhome,BindingResult bindResult,Model model) {
			if(bindResult.hasErrors()) {
				return "adminhome";
			}

	        List<Admin> dbadminList = adminservices.adminList();
	        boolean found = false;
			
			for (Admin dbv : dbadminList) {
				if(dbv.getUsername().equals(adminhome.getUsername())&&dbv.getPassword().equals(adminhome.getPassword())) {
					found=true;
	            }
			}
			if(found) {
				return "admindashboard";
			}
			else {
				model.addAttribute("error", "Incorrect username or password");
	            return "adminhome"; 
			}
		}
		

	}

