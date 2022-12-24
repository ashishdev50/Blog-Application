package com.example.SpringPractice.Services;



import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.example.SpringPractice.Entity.Comments;
import com.example.SpringPractice.repo.CCommentServicess;
import com.example.SpringPractice.repo.CommentRepo;


@Service
public class CommentServices  implements CCommentServicess{
@Autowired
CommentRepo commentRepo;
@Autowired
private JavaMailSender javaMailSender;
//public List<Product> getAllProductsByCategoriesId(int id)
//{
//	return productsRepo.findAllByCategory_Id(id);
//}

public List<Comments> getCommentsByPostId(int id)
{
	return commentRepo.findAllByBlog_Id(id);
}


public void addommment(Comments comments) {

   commentRepo.save(comments);
	
	
}


@Override
public String sendMailWithComments(Comments comments) {
	
    MimeMessage mimeMessage
    = javaMailSender.createMimeMessage();
MimeMessageHelper mimeMessageHelper;

try {

    // Setting multipart as true for attachments to
    // be send
    mimeMessageHelper
        = new MimeMessageHelper(mimeMessage, true);
    mimeMessageHelper.setFrom(comments.getUseremail());
    mimeMessageHelper.setTo("ashishcharde09@gmail.com");
    mimeMessageHelper.setText(comments.getName() +"  " +comments.getMessage());
  mimeMessage.setDescription(comments.getName());
    mimeMessageHelper.setSubject(comments.getUseremail() +" " +"is Comments to Your Blog");



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
