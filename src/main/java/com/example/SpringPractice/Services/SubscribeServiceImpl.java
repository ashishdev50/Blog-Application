package com.example.SpringPractice.Services;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.example.SpringPractice.Entity.Subscibe;
import com.example.SpringPractice.repo.SubscibeService;
@Service
public class SubscribeServiceImpl implements SubscibeService{
	@Autowired
	private JavaMailSender javaMailSender;

	
	
	
	@Override
	public String sendSubscribtions(Subscibe subscibe) {
		 MimeMessage mimeMessage
        = javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper;

    try {
    	
        // Setting multipart as true for attachments to
        // be send
        mimeMessageHelper
            = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(subscibe.getEmail());
    mimeMessageHelper.setTo("ashishcharde09@gmail.com");
        mimeMessageHelper.setText("Thank you!");
        mimeMessageHelper.setSubject( subscibe.getEmail() +" "+" Subscribed to your blog");
    

        // Sending the mail
        javaMailSender.send(mimeMessage);
        return "Mail sent Successfully";
    }

    // Catch block to handle MessagingException
    catch (MessagingException e) {

        // Display message when exception occurred
        return "Error while sending mail!!!";
    }
		
	}
	

}
