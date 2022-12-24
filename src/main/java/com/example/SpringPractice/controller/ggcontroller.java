package com.example.SpringPractice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.SpringPractice.Entity.EmailDetails;
import com.example.SpringPractice.repo.EmailService;




@Controller
public class ggcontroller {
	
	@Autowired
	EmailService emailService;
	

	
	@GetMapping("/")
	public String postex()
	{
		
		
		return "ex";
	}
	
	@PostMapping("/postex")
	public String postex(@ModelAttribute EmailDetails details)
	{
		

		emailService.sendMailWithAttachment(details);
		System.out.println(details);
		return "redirect:/";
	}

	
	
	
	
	
	
	
	
	
	
}
