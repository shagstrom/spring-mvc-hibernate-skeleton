package com.dreamchain.skeleton.web;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.dreamchain.skeleton.model.User;

public class UserCommand {

	private Long id;

	@NotEmpty
	private String name;

	@Email
	private String email;

	@NotEmpty
	private String address;
	
	private Boolean selected = false;
	
	public UserCommand() {}

	public UserCommand(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		address = user.getAddress();
	}

	public User toUser() {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setAddress(address);
		return user;
	}
	

	/* Annoying Getters and Setters start here */
	
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

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getSelected() {
		return selected;
	}
	
	public void setSelected(Boolean changed) {
		this.selected = changed;
	}
	
}