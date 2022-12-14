package com.gcu.services;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.UserWorkoutModel;
import com.gcu.model.WorkoutModel;
import com.gcu.model.accounts.AccountModel;
import com.gcu.model.accounts.ClientModel;
import com.gcu.model.accounts.TrainerModel;

public class HardCodedRestService implements RestServiceInterface {

	private List<WorkoutModel> workouts = new ArrayList<WorkoutModel>();
	private List<ClientModel> clients = new ArrayList<ClientModel>();
	private List<TrainerModel> trainers = new ArrayList<TrainerModel>();
	
	public HardCodedRestService()
	{
		workouts.add(new WorkoutModel("Lunges", 50, "1:00"));
		
		ClientModel testClient = new ClientModel("Testing", "Testing", 20, 100, 100, "Something", "Another Thing", 1);
		testClient.getWorkouts().add(new UserWorkoutModel("Lunges", 50, "1:00", 0, "incomplete"));
		
		clients.add(testClient);
		clients.add(new ClientModel("Example", "Example", 10, 10, 10, "Test", "Test", 2));
		clients.add(new ClientModel("Example2", "Example2", 10, 10, 10, "Test2", "Test2", 3));
		clients.add(new ClientModel("Example3", "Example3", 10, 10, 10, "Test3", "Test3", 4));
		clients.add(new ClientModel("Example4", "Example4", 10, 10, 10, "Test4", "Test4", 5));
		
		trainers.add(new TrainerModel("Trainer1", "Trainer1", "Trainer1", "Trainer1", 1, 6));
		
	}
	
	@Override
	public List<WorkoutModel> getWorkouts() {
		return workouts;
	}

	@Override
	public List<ClientModel> getClients() {
		return clients;
	}

	@Override
	public void addClient(ClientModel client) {
		clients.add(client);
		
	}

	@Override
	public void addWorkout(WorkoutModel workout) {
		workouts.add(workout);
		
	}

	@Override
	public ClientModel getClient(int clientID) {
		
		for(ClientModel client: clients)
		{
			if(client.getAccountID() == clientID)
			{
				return client;
			}
		}
		System.out.println("Unable to find Client with Client ID of " + clientID);
		return null;
		
	}

	@Override
	public AccountModel getAccountByID(int accountID) {
		
		for(ClientModel client: clients)
		{
			if(client.getAccountID() == accountID)
			{
				return client;
			}
		}
		
		for(TrainerModel trainer: trainers)
		{
			if(trainer.getAccountID() == accountID)
			{
				return  trainer;
			}
		}
		System.out.println("Unable to find Account with Account ID of " + accountID);
		
		return null;
	}
	
	@Override
	public AccountModel getAccountByLogin(String Username, String Password) {
		
		for(ClientModel client: clients)
		{
			if(client.getUsername().equals(Username))
				if(client.getPassword().equals(Password))
					return client;
		}
		
		for(TrainerModel trainer: trainers)
		{
			if(trainer.getUsername().equals(Username))
				if(trainer.getPassword().equals(Password))
					return  trainer;
		}
		System.out.println("Unable to find Account with Username of " + Username);
		
		return null;
	}
	
	@Override
	public UserWorkoutModel makeWorkout(String name, int percent, String status) {
		
		for(WorkoutModel workout: workouts)
		{
			if(workout.getName().equals(name))
			{
				return new UserWorkoutModel(workout.getName(), workout.getCaloriesPerSet(), workout.getTimePerSet(), percent, status);
			}
		}
		
		return null;
	}

	@Override
	public void addTrainer(TrainerModel trainer) {
		trainers.add(trainer);
	}

}
