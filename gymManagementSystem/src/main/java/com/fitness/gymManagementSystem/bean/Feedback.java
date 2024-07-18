package com.fitness.gymManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {
    
    @Id
    private Long id;
    private String name;
    private String email;
    private int rating;
    private String comments;
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(Long id, String name, String email, int rating, String comments) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.rating = rating;
		this.comments = comments;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
    
    
}
