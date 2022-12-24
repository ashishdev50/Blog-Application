package com.example.SpringPractice.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table
public class Comments {

	@Id
	int Coid;
	String Name;
	String message;
 String useremail;
	/// many Comments to blog
	@ManyToOne
	Blog blog;

	
	
	
	
	
	
	
	
	
	

	public Comments(int coid, String name, String message, String useremail, Blog blog) {
		super();
		Coid = coid;
		Name = name;
		this.message = message;
		this.useremail = useremail;
		this.blog = blog;
	}

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public int getCoid() {
		return Coid;
	}

	public void setCoid(int coid) {
		Coid = coid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Comments [Coid=" + Coid + ", Name=" + Name + ", message=" + message + ", useremail=" + useremail
				+ ", blog=" + blog + "]";
	}

}
