package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.UserWorkoutModel;
import com.gcu.model.WorkoutModel;
import com.gcu.model.accounts.ClientModel;
import com.gcu.services.RestServiceInterface;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	private RestServiceInterface service;
	
	//Home Controller for Trainer view
	@GetMapping("")
	public String displayHome()
	{
		return "trainer";
	}
	
	//Displays the list of clients for trainers to view
	@GetMapping("/clients")
	public String displayClients(Model model)
	{
		model.addAttribute("clients", service.getClients());
		return "clientsList";
	}
	
	//Displays the workouts for a specific client
	@GetMapping("/clients/view/{id}")
	public String viewClientWorkouts(Model model, @PathVariable int id)
	{
		ClientModel client = service.getClient(id);
		
		if(client == null)
		{
			return displayClients(model);
		}
		
		model.addAttribute("client", client);
		return "clientWorkouts";
	}
	
	//Edit the list of workouts a client has
	@GetMapping("/clients/edit/{id}")
	public String addClientWorkouts(Model model, @PathVariable int id)
	{
		ClientModel client = service.getClient(id);
		
		if(client == null)
		{
			return displayClients(model);
		}
		
		model.addAttribute("client", client);
		model.addAttribute("workouts", service.getWorkouts());
		return "addWorkout";
	}
	
	//Adds workout to a client with client ID of ID and workoutn name of name
	@GetMapping("/clients/addWorkout/{id}/{name}")
	public String addClientWorkouts(Model model, @PathVariable int id, @PathVariable String name)
	{
		ClientModel client = service.getClient(id);
		UserWorkoutModel workout = service.makeWorkout(name, 0, "incomplete");
		if(client == null || workout == null)
		{
			return displayClients(model);
		}
		
		client.getWorkouts().add(workout);
		
		model.addAttribute("client", client);
		model.addAttribute("workouts", service.getWorkouts());
		return "addWorkout";
	}
	
	//displays all the workouts available
	@GetMapping("/workouts")
	public String viewWorkouts(Model model)
	{
		model.addAttribute("workouts", service.getWorkouts());
		return "workoutsList";
	}
	
	//Allows trainer to add new workout to list of available workouts
	@GetMapping("/workouts/add")
	public String newWorkout(Model model)
	{
		model.addAttribute("workoutModel", new WorkoutModel());
		return "newWorkout";
	}
	
	//Takes in workout and adds to avilable workouts if valid
	@PostMapping("/workouts/add")
	public String addWorkout(@Valid WorkoutModel workout,BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			return "newWorkout";
		}
		
		service.addWorkout(workout);
		model.addAttribute("workouts", service.getWorkouts());
		return "workoutsList";
	}
	
	
	
}
