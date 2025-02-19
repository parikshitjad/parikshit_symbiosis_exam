package com.task.TaskManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.voter.voterJpa.model.Admin;
import com.voter.voterJpa.service.AdminServices;

import jakarta.validation.Valid;


	@Controller
	@Transactional
	public class AdminController {
		@Autowired
		private AdminServices adminservice;
		@GetMapping("/registerAdmin")
		public String regiAdmin(Model model) {
			model.addAttribute("admin",new Admin());
			return "adminregisteration";
			
		}
		@PostMapping("/adminstatus")
		public String getStatus(@Valid @ModelAttribute("admin") Admin admin,BindingResult bindResult) {
			if(bindResult.hasErrors()) {
				return "adminregisteration";
			}
			adminservice.saveRegistered(admin);
			return "redirect:/adminlogin";
			
		}

	}

