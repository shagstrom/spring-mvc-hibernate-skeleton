package com.dreamchain.skeleton.service;

import com.dreamchain.skeleton.model.User;
import com.dreamchain.skeleton.web.UserCommand;
import com.dreamchain.skeleton.web.UserGrid;

public interface UserService {
	
	User get(Long id);
	
	void save(UserCommand userCommand);
	
	void delete(User user);
	
	UserGrid findAll();
	
	void saveAll(UserGrid userGrid);

	void updateWithAll(UserGrid userGrid);
	
}
