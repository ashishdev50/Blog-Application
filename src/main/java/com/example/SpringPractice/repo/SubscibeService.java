package com.example.SpringPractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringPractice.Entity.EmailDetails;
import com.example.SpringPractice.Entity.Subscibe;
@Repository
public interface SubscibeService  {
	// Method
    // To send a simple email
    String sendSubscribtions(Subscibe  subscibe);
 
    
}
