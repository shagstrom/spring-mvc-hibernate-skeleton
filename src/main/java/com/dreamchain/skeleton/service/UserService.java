package com.dreamchain.skeleton.service;

import java.util.List;

import com.dreamchain.skeleton.model.User;

public interface UserService {
	
	User get(Long id);
	void save(User user);
	void delete(User user);
	List<User> findAll();
	void saveAll(List<User> users);
	
}
