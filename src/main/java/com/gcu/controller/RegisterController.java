package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.RegisterModel;

@Controller
@RequestMapping("/register")
public class RegisterController 
{
	@GetMapping("")
	public String display(Model model) 
	{
		model.addAttribute("title", "");
		model.addAttribute("registerModel", new RegisterModel());
		return "register";
	}
}
