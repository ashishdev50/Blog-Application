package com.example.SpringPractice.repo;

import org.springframework.stereotype.Repository;

import com.example.SpringPractice.Entity.EmailDetails;
@Repository
public interface EmailService {
	// Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
