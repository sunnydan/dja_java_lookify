package com.hilla.daniel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "redirect:/songs";
	}

}
