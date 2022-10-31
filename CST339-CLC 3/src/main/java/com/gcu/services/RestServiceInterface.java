package com.gcu.services;

import java.util.List;

import com.gcu.model.UserWorkoutModel;
import com.gcu.model.WorkoutModel;
import com.gcu.model.accounts.AccountModel;
import com.gcu.model.accounts.ClientModel;
import com.gcu.model.accounts.TrainerModel;

public interface RestServiceInterface {

	public List<WorkoutModel> getWorkouts();
	
	public List<ClientModel> getClients();
	
	public void addClient(ClientModel client);
	
	public void addTrainer(TrainerModel trainer);
	
	public void addWorkout(WorkoutModel workout);
	
	public ClientModel getClient(int clientID);
	
	public AccountModel getAccountByID(int accountID);
	
	public AccountModel getAccountByLogin(String username, String password);
	
	public UserWorkoutModel makeWorkout(String name, int percent, String status);
}
