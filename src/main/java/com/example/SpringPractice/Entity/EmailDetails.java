package com.example.SpringPractice.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class EmailDetails {
	@Id
	private int id;
	private String name;
	  private String recipient;
	    private String msgBody;
	    private String subject;
	    private String attachment;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRecipient() {
			return recipient;
		}
		public void setRecipient(String recipient) {
			this.recipient = recipient;
		}
		public String getMsgBody() {
			return msgBody;
		}
		public void setMsgBody(String msgBody) {
			this.msgBody = msgBody;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getAttachment() {
			return attachment;
		}
		public void setAttachment(String attachment) {
			this.attachment = attachment;
		}
		public EmailDetails() {
			super();
			// TODO Auto-generated constructor stub
		}
		public EmailDetails(int id, String name, String recipient, String msgBody, String subject, String attachment) {
			super();
			this.id = id;
			this.name = name;
			this.recipient = recipient;
			this.msgBody = msgBody;
			this.subject = subject;
			this.attachment = attachment;
		}
		@Override
		public String toString() {
			return "EmailDetails [id=" + id + ", name=" + name + ", recipient=" + recipient + ", msgBody=" + msgBody
					+ ", subject=" + subject + ", attachment=" + attachment + "]";
		}

	    
	    
}
