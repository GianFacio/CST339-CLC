package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;


@Controller
@RequestMapping("")
public class MainController 
{
	@GetMapping("")
	public String display(Model model) 
	{
		model.addAttribute("title", "");
		return "index";
	}
	@PostMapping("/doRegister")
	public String doRegister(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model)
	{
		System.out.println(String.format("First name: %s Last name: %s Age: %s Weight: %s Height: %s Username: %s Password: %s", registerModel.getFirstName(), registerModel.getLastName(), registerModel.getAge(), registerModel.getWeight(), registerModel.getHeight(), registerModel.getUsername(), registerModel.getPassword()));
		
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "");
			return "register";
		}
		// display the Home view
		model.addAttribute("title", "");

		return "index";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		System.out.println(String.format("Username: %s Password: %s ", loginModel.getUsername(), loginModel.getPassword()));
		
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "");
			return "login";
		}
		// display the Home view
		model.addAttribute("title", "");

		return "home";
	}
}