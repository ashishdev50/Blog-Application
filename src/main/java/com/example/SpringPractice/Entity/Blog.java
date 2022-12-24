package com.example.SpringPractice.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Blog {
	@Id
	int id;
	String blogname;
	String blogdecription;
	String blogimages;
	

	
	
	
	
	 ///many Comments
	 @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
	 List<Comments> commList = new ArrayList<>();
	
	
	
	
	public List<Comments> getCommList() {
		return commList;
	}
	public void setCommList(List<Comments> commList) {
		this.commList = commList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBlogname() {
		return blogname;
	}
	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	public String getBlogdecription() {
		return blogdecription;
	}
	public void setBlogdecription(String blogdecription) {
		this.blogdecription = blogdecription;
	}
	
	
	public String getBlogimages() {
		return blogimages;
	}
	public void setBlogimages(String blogimages) {
		this.blogimages = blogimages;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(int id, String blogname, String blogdecription, String blogimages, List<Comments> commList) {
		super();
		this.id = id;
		this.blogname = blogname;
		this.blogdecription = blogdecription;
		this.blogimages = blogimages;
		this.commList = commList;
	}
	
	

}
