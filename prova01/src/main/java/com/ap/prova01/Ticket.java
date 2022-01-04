package com.ap.prova01;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {
	private @Id @GeneratedValue Long id;
	private String title;
	private String content;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	Ticket(){}

	public Ticket(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
}
