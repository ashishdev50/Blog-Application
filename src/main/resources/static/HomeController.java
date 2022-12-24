package com.example.SpringPractice.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SpringPractice.Entity.User;
import com.example.SpringPractice.repo.userepo;





@Controller
public class HomeController {

@Autowired
userepo userepo;
	@GetMapping("/signin")
	public String login(@ModelAttribute User user, BindingResult bindingResult, Model model) {
		
		model.addAttribute("users", userepo.findAll());
System.out.println(userepo.findAll().get(0).getName());
		//System.out.println(	model.addAttribute("user", new User().getName()));
		return "index";
	}

	
	

}