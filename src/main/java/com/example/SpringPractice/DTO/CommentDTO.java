package com.example.SpringPractice.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class CommentDTO {

	int id;
	String Content;
	String namee;
	String userMaill;
 int blogId;
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public CommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNamee() {
		return namee;
	}
	public void setNamee(String namee) {
		this.namee = namee;
	}
	public String getUserMaill() {
		return userMaill;
	}
	public void setUserMaill(String userMaill) {
		this.userMaill = userMaill;
	}
	public CommentDTO(int id, String content, String namee, String userMaill, int blogId) {
		super();
		this.id = id;
		Content = content;
		this.namee = namee;
		this.userMaill = userMaill;
		this.blogId = blogId;
	}

	
	
	
	
}
