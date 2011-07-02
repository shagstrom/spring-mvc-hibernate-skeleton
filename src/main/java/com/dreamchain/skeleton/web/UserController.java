package com.dreamchain.skeleton.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dreamchain.skeleton.service.UserService;

@Controller
@RequestMapping(UserController.URL)
public class UserController {

	static final String URL = "/user";
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired private UserService userService;

	@ModelAttribute("userCommand")
	public UserCommand populateUserCommand() {
		return new UserCommand();
	}
	
	@ModelAttribute("usersCommand")
	public UsersCommand populateUsersCommand() {
		return new UsersCommand(userService.findAll());
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void get(Model model) {
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(Model model, @Valid UserCommand userCommand, BindingResult result) {
		if (result.hasErrors()) {
			logger.info("Validation failed");
			return URL;
		}
		userService.save(userCommand.toUser());
		return "redirect:" + URL;
	}
	
	@RequestMapping(method = RequestMethod.POST, params="_method=put")
	public String put(Model model, @Valid UsersCommand usersCommand, BindingResult result) {
		if (result.hasErrors()) {
			return URL;
		}
		userService.saveAll(usersCommand.getSelectedUsers());
		return "redirect:" + URL;
	}
	
}
