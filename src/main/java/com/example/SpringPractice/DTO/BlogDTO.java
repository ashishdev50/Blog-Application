package com.example.SpringPractice.DTO;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class BlogDTO {
	String imagename;

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public BlogDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogDTO(String imagename) {
		super();
		this.imagename = imagename;
	}
	
	

}
