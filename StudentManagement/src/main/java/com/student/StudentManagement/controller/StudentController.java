package com.student.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.services.StudentServices;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class StudentController {
	@Autowired
	private StudentServices studentservice;
	@GetMapping("/registerStudent")
	public String regiStudent(Model model) {
	    model.addAttribute("student",new Student());
		return "studentregistration";
	
	}
	@PostMapping("/studentstatus")
	public String getStatus(@Valid @ModelAttribute("student") Student student,BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "studentregisteration";
		}
		studentservice.saveRegistered(student);
		return "redirect:/studentlogin";
	}
}