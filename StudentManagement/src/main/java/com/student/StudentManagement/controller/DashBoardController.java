package com.student.StudentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.StudentManagement.model.Student;
import com.student.StudentManagement.services.StudentServices;

import jakarta.validation.Valid;

public class DashBoardController {

	 @Autowired
	    private StudentServices studentservices;

	    @GetMapping("/studentlist")
	    public String getVoterList(Model model) {
	        List<Student> studentList = studentservices.studentList();
	        Object studentList1 = null;
			model.addAttribute("students", studentList1);
	        return "students";
	    }

	    @PostMapping("/student/delete")
	    public String getDelete(@RequestParam("id") int id, Model model) {
	        studentservices.deleteByID(id);
	        String deleteMessage = "Student Successfully Deleted With Id: " + id;
	        model.addAttribute("message", deleteMessage);
	        List<Student> studentList = studentservices.studentList();
	        model.addAttribute("students", studentList);
	        return "students";
	    }

	    @GetMapping("/student/edit")
	    public String getEdit(@RequestParam("id") int id, Model model) {
	        System.out.println("check");
	    	Student student = studentservices.findByID(id);
	        System.out.println(student.getStudentName());
	        model.addAttribute("student", student);
	       
	        return "updateform";  
	    }
	    @PostMapping("/saveupdate")
	    public String getUpdate(@Valid @ModelAttribute("student") Student voter,BindingResult bindResult) {
	    	if(bindResult.hasErrors()) {
	    		return "updateform";
	    	}
			Object student = null;
			studentservices.updateStudent(student);
			return "redirect:/studentlist";
	    	
	    }

	}


