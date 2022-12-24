package com.example.SpringPractice.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringPractice.Entity.Blog;
import com.example.SpringPractice.Entity.User;
import com.example.SpringPractice.repo.userepo;



@Service
public class UserServices {

	@Autowired
	userepo userepo;
	
	public void addPhtoto(User user) {

		userepo.save(user);
		
		
	}


	public User getuserById(int id) {
		return    userepo.findById(id).get()  ;
	}

}
