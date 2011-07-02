package com.dreamchain.skeleton.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.dreamchain.skeleton.model.User;

public class UsersCommand {
	
	@Valid
	private List<UserCommand> userCommands = new ArrayList<UserCommand>();
	
	public UsersCommand() {}
	
	public UsersCommand(List<User> users) {
		for (User user : users)
			userCommands.add(new UserCommand(user));
	}
	
	public List<User> getSelectedUsers() {
		List<User> users = new ArrayList<User>();
		for (UserCommand userCommand : userCommands)
			if (userCommand.getSelected())
				users.add(userCommand.toUser());
		return users;
	}

	
	/* Annoying Getters and Setters start here */
	
	public List<UserCommand> getUserCommands() {
		return userCommands;
	}

	public void setUserCommands(List<UserCommand> users) {
		this.userCommands = users;
	}
	
}
