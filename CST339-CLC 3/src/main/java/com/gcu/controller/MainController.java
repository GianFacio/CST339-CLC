package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.accounts.AccountModel;
import com.gcu.model.accounts.ClientModel;
import com.gcu.model.accounts.TrainerModel;
import com.gcu.services.RestServiceInterface;


@Controller
@RequestMapping("")
public class MainController 
{
	
	@Autowired
	private RestServiceInterface service;
	
	@GetMapping("")
	public String display(Model model) 
	{
		model.addAttribute("title", "");
		return "index";
	}
	
	//Display the login page that any user can use to log in
	@GetMapping("/login")
	public String displayLogin(Model model) 
	{
		model.addAttribute("title", "");
		model.addAttribute("accountModel", new AccountModel());
		model.addAttribute("failedLogin", false);
		return "login";
	}
	
	
	@PostMapping("/doRegisterClient")
	public String doRegisterClient(@Valid ClientModel clientModel, BindingResult bindingResult, Model model)
	{
		System.out.println(String.format("First name: %s Last name: %s Age: %s Weight: %s Height: "
				+ "%s Username: %s Password: %s", clientModel.getFirstName(), clientModel.getLastName(), clientModel.getAge(), clientModel.getWeight(), 
				clientModel.getHeight(), clientModel.getUsername(), clientModel.getPassword()));
		
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "");
			return "registerClient";
		}
		// display the Home view

		model.addAttribute("client", clientModel);
		service.addClient(clientModel);
		return "clientHome";
	}
	
	// Post mapping to confirm the inputs added to the trainer profile 
	@PostMapping("/doRegisterTrainer")
	public String doRegisterTrainer(@Valid TrainerModel trainerModel, BindingResult bindingResult, Model model)
	{
		System.out.println(String.format("First name: %s Last name: %s Employee ID: Username: %s Password: %s", 
				trainerModel.getFirstName(), trainerModel.getLastName(), trainerModel.getTrainerID(), trainerModel.getUsername(), trainerModel.getPassword()));
		
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			return "registerTrainer";
		}
		// display the Home view
		service.addTrainer(trainerModel);
		return "trainer";
	}
	
	
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid AccountModel accountModel, BindingResult bindingResult, Model model)
	{
		//If the username or password is not valid, show errors and ask to try again
		if(bindingResult.hasFieldErrors("password") || bindingResult.hasFieldErrors("username"))
		{
			model.addAttribute("failedLogin", true);
			System.out.println(bindingResult.toString());
			return "login";
		}
		
		//Find the account in the database and return the view according to the account type
		AccountModel foundAccount = service.getAccountByLogin(accountModel.getUsername(), accountModel.getPassword());
		if(foundAccount instanceof ClientModel)
		{
			model.addAttribute("client", foundAccount);
			return "clientHome";
		}
		
		if(foundAccount instanceof TrainerModel)
		{
			return "trainer";
		}
		//Return the failed login page if no account was found with a valid username and password
		model.addAttribute("failedLogin", true);
		return "login";
	}
}