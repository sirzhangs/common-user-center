package com.sirzhangs.usercenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(produces= {"application/json;charset=UTF-8","application/x-www-form-urlencoded;charset=UTF-8"})
public class HomeController {
	
	@GetMapping("home")
	public String home(Model model) {
		model.addAttribute("name", "张三");
		return "index";
	}
	
	@GetMapping("login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("register")
	public String register(Model model) {
		return "register";
	}
	
	@GetMapping("goHome")
	public String goHome(Model model) {
		return "goHome";
	}
}
