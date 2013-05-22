package com.dreamchain.skeleton.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
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
	
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public void get(Model model, @ModelAttribute UserCommand userCommand) {
		model.addAttribute("userGrid", userService.findAll());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(Model model, @Valid UserCommand userCommand, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("userGrid", userService.findAll());
			return URL;
		}
		PasswordEncoder passwordEncoder = new StandardPasswordEncoder();
		userCommand.setPassword(passwordEncoder.encode(userCommand.getPassword()));
		userService.save(userCommand);
		
		return "redirect:" + URL;
	}
	
	@RequestMapping(method = RequestMethod.POST, params="_method=put")
	public String put(Model model, @Valid UserGrid userGrid, BindingResult result) {
		if (result.hasErrors()) {
			userService.updateWithAll(userGrid);
			return URL;
		}
		userService.saveAll(userGrid);
		return "redirect:" + URL;
	}
	
}
