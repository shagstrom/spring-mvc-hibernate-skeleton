package com.dreamchain.skeleton.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(HomeController.URL)
public class HomeController {
	
	static final String URL = "/";

	@RequestMapping(method = RequestMethod.GET)
	public void get(Model model) {
	}
	
}