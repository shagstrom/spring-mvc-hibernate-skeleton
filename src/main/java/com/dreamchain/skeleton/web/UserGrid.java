package com.dreamchain.skeleton.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.dreamchain.skeleton.model.User;

public class UserGrid {
	
	@Valid
	private Map<Long, UserCommand> userMap = new LinkedHashMap<Long, UserCommand>();
	
	public UserGrid() {}
	
	public UserGrid(List<User> users) {
		for (User user : users)
			userMap.put(user.getId(), new UserCommand(user));
	}
	
	public List<User> getSelectedUsers() {
		List<User> users = new ArrayList<User>();
		for (UserCommand userCommand : userMap.values())
			if (userCommand.getSelected())
				users.add(userCommand.toUser());
		return users;
	}

	
	/* Annoying Getters and Setters start here */
	
	public Map<Long, UserCommand> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<Long, UserCommand> users) {
		this.userMap = users;
	}
	
}
