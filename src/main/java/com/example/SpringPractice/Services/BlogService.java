package com.example.SpringPractice.Services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.example.SpringPractice.Entity.Blog;
import com.example.SpringPractice.Entity.Comments;
import com.example.SpringPractice.Entity.EmailDetails;
import com.example.SpringPractice.Entity.SendMailForBlogUpload;
import com.example.SpringPractice.Entity.Subscibe;
import com.example.SpringPractice.repo.BBlogServices;
import com.example.SpringPractice.repo.blogrepo;


@Service
public class BlogService  implements BBlogServices{
	@Autowired
 JavaMailSender javaMailSender;
	@Autowired
	blogrepo blogrepo;
	
	
	
public Optional<Blog> getCommentById(int id)
{
	return blogrepo.findById(id);

}

public void addBlog(Blog blog) {

	blogrepo.save(blog);
	
	
}

@Override
public String sendMailUpladBlog(SendMailForBlogUpload SendMailForBlogUpload) {
	
	
 MimeMessage mimeMessage = javaMailSender.createMimeMessage();
MimeMessageHelper mimeMessageHelper;

try {

    // Setting multipart as true for attachments to
    // be send
	
	Subscibe  subscibe = new Subscibe();

    mimeMessageHelper
        = new MimeMessageHelper(mimeMessage, true);
    mimeMessageHelper.setFrom(subscibe.getEmail());
    mimeMessageHelper.setTo("ashishcharde09@gmail.com");
   
    mimeMessageHelper.setSubject("Dear"+" "+subscibe.getEmail()+" "+"Post a New Blog");
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