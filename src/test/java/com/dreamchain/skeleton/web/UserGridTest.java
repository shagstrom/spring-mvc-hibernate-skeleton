package com.dreamchain.skeleton.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Test;

import com.dreamchain.skeleton.model.User;

public class UserGridTest {
	
	@Test
	public void two_valid_users_should_not_have_violations() {

		List<User> users = new ArrayList<User>();

		users.add(new User());
		users.get(0).setName("name1");
		users.get(0).setPassword("XXX");
		users.get(0).setEmail("name1@domain.net");
		users.get(0).setAddress("address1");

		users.add(new User());
		users.get(1).setName("name2");
		users.get(1).setPassword("XXX");
		users.get(1).setEmail("name2@domain.net");
		users.get(1).setAddress("address2");

		UserGrid userGrid = new UserGrid(users);
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UserGrid>> violations = validator.validate(userGrid); 
		Assert.assertTrue(violations.isEmpty());
	
	}

	@Test
	public void invalid_email_should_have_violations() {

		List<User> users = new ArrayList<User>();

		users.add(new User());
		users.get(0).setName("name1");
		users.get(0).setPassword("XXX");
		users.get(0).setEmail("Invalid Email!!!!");
		users.get(0).setAddress("address1");

		UserGrid usersCommand = new UserGrid(users);
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UserGrid>> violations = validator.validate(usersCommand);
		Assert.assertFalse(violations.isEmpty());
		for (ConstraintViolation<UserGrid> violation : violations) {
			Assert.assertEquals("not a well-formed email address", violation.getMessage());
		}
	
	}

	
}
