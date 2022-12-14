package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	@GetMapping("")
	public String display(Model model) 
	{
		model.addAttribute("title", "");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
}
