package com.example.SpringPractice.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringPractice.Entity.Subscibe;
import com.example.SpringPractice.repo.SubScriberepo;

@RestController
public class SearchController {

	@Autowired
	SubScriberepo scriberepo;
	
	//search hander
	
	@GetMapping("/search/{email}")
	public ResponseEntity<List> search(@RequestParam String email,  Principal principal)
	{
		
		
		
		
		List<Subscibe> findByEmailContaining = this.scriberepo.findByEmail(email);
		
		System.out.println(scriberepo.findByEmail(email));
		
		return ResponseEntity.ok(findByEmailContaining);
		
		
		
	}
	
	
	
	
}
