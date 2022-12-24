package com.example.SpringPractice.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class User {

	@Id
	int id;
	String name;
	String Address;
	String Phoneno;
	String email;
	String image;
	String linkdin;
	String insta;
	String facebook;
	String tweeter;
	String summary;
	String abouttitle;
	String aboutdecription;
	String aboutphoto;

	
	
	
	
	
	
	
	
	
	
	
	
	public String getAbouttitle() {
		return abouttitle;
	}

	public void setAbouttitle(String abouttitle) {
		this.abouttitle = abouttitle;
	}

	public String getAboutdecription() {
		return aboutdecription;
	}

	public void setAboutdecription(String aboutdecription) {
		this.aboutdecription = aboutdecription;
	}

	public String getAboutphoto() {
		return aboutphoto;
	}

	public void setAboutphoto(String aboutphoto) {
		this.aboutphoto = aboutphoto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getLinkdin() {
		return linkdin;
	}

	public void setLinkdin(String linkdin) {
		this.linkdin = linkdin;
	}

	public String getInsta() {
		return insta;
	}

	public void setInsta(String insta) {
		this.insta = insta;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTweeter() {
		return tweeter;
	}

	public void setTweeter(String tweeter) {
		this.tweeter = tweeter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhoneno() {
		return Phoneno;
	}

	public void setPhoneno(String phoneno) {
		Phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String address, String phoneno, String email, String image, String linkdin,
			String insta, String facebook, String tweeter, String summary, String abouttitle, String aboutdecription,
			String aboutphoto) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
		Phoneno = phoneno;
		this.email = email;
		this.image = image;
		this.linkdin = linkdin;
		this.insta = insta;
		this.facebook = facebook;
		this.tweeter = tweeter;
		this.summary = summary;
		this.abouttitle = abouttitle;
		this.aboutdecription = aboutdecription;
		this.aboutphoto = aboutphoto;
	}


}
