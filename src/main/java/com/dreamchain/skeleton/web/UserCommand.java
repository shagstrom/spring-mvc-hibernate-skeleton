package com.dreamchain.skeleton.web;

import com.dreamchain.skeleton.model.User;

public class UserCommand extends User {

	private static final long serialVersionUID = -4686811929329857418L;

	private Boolean selected = false;
	
	public UserCommand() {}

	public UserCommand(User user) {
		setId(user.getId());
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
		setEmail(user.getEmail());
		setAddress(user.getAddress());
	}

	public User toUser() {
		User user = new User();
		user.setId(getId());
		user.setFirstName(getFirstName());
		user.setLastName(getLastName());
		user.setEmail(getEmail());
		user.setAddress(getAddress());
		return user;
	}
	

	/* Annoying Getters and Setters start here */
	
	public Boolean getSelected() {
		return selected;
	}
	
	public void setSelected(Boolean changed) {
		this.selected = changed;
	}
	
}