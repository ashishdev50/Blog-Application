package com.example.SpringPractice.repo;

import com.example.SpringPractice.Entity.Comments;


public interface CCommentServicess {

	 
    // Method
    // To send an email with attachment
    String sendMailWithComments(Comments comments);
}
