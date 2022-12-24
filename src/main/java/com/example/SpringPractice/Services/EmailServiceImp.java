package com.example.SpringPractice.Services;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.SpringPractice.Entity.EmailDetails;
import com.example.SpringPractice.repo.EmailService;

@Service
public class EmailServiceImp implements EmailService{
	@Autowired
	private JavaMailSender javaMailSender;
	@Override
	public String sendSimpleMail(EmailDetails details) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendMailWithAttachment(EmailDetails details) {
		// Creating a mime message
        MimeMessage mimeMessage
            = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(details.getRecipient() +"Ahhhh");
            mimeMessageHelper.setTo("ashishcharde09@gmail.com");
            mimeMessageHelper.setText(details.getName());
            mimeMessageHelper.setText(details.getRecipient().toUpperCase() +" " +details.getMsgBody());
            mimeMessageHelper.setSubject(details.getSubject());
 
        
 
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
