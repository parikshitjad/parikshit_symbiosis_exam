package com.task.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.voter.voterJpa.model.Voter;
import com.voter.voterJpa.service.VoterServices;

import jakarta.validation.Valid;

	@Controller
	public class DashboardController {

	    @Autowired
	    private VoterServices voterservices;

	    @GetMapping("/voterlist")
	    public String getVoterList(Model model) {
	        List<Voter> voterList = voterservices.voterList();
	        model.addAttribute("voters", voterList);
	        return "voters";
	    }

	    @PostMapping("/voter/delete")
	    public String getDelete(@RequestParam("id") int id, Model model) {
	        voterservices.deleteByID(id);
	        String deleteMessage = "Voter Successfully Deleted With Id: " + id;
	        model.addAttribute("message", deleteMessage);
	        List<Voter> voterList = voterservices.voterList();
	        model.addAttribute("voters", voterList);
	        return "voters";
	    }

	    @GetMapping("/voter/edit")
	    public String getEdit(@RequestParam("id") int id, Model model) {
	        System.out.println("check");
	    	Voter voter = voterservices.findByID(id);
	        System.out.println(voter.getVoterName());
	        model.addAttribute("voter", voter);
	       
	        return "updateform";  
	    }
	    @PostMapping("/saveupdate")
	    public String getUpdate(@Valid @ModelAttribute("voter") Voter voter,BindingResult bindResult) {
	    	if(bindResult.hasErrors()) {
	    		return "updateform";
	    	}
	    	voterservices.updateVoter(voter);
			return "redirect:/voterlist";
	    	
	    }

	}
