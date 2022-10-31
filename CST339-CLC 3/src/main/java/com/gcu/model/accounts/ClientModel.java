package com.gcu.model.accounts;

import java.util.ArrayList;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gcu.model.GoalsModel;
import com.gcu.model.UserWorkoutModel;

public class ClientModel extends AccountModel
{
	@Min(value = 1, message = "Age should not be less than 1")
	private int age;
	
	@Min(value = 1, message = "Weight should not be less than 1 pound")
	private int weight;
	
	@Min(value = 1, message = "Height should not be less than 1 inch")
	private int height;
	
	private ArrayList<UserWorkoutModel> workouts = new ArrayList<UserWorkoutModel>();
	private ArrayList<GoalsModel> goals = new ArrayList<GoalsModel>();
	
	
	public ClientModel(
			@NotNull(message = "First name is a required field") @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters") String firstName,
			@NotNull(message = "Last name is a required field") @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters") String lastName,
			@Min(value = 1, message = "Age should not be less than 1") int age,
			@Min(value = 1, message = "Weight should not be less than 1 pound") int weight,
			@Min(value = 1, message = "Height should not be less than 1 inch") int height,
			@NotNull(message = "Username is a required field") @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters") String username,
			@NotNull(message = "Password is a required field") @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters") String password,
			int accountID) {
		super(username, password, firstName, lastName, accountID);
		this.age = age;
		this.weight = weight;
		this.height = height;
	
	}

	public ClientModel() {
		super();
		//Blank Client Model
	}

	public ArrayList<UserWorkoutModel> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(ArrayList<UserWorkoutModel> workouts) {
		this.workouts = workouts;
	}

	public ArrayList<GoalsModel> getGoals() {
		return goals;
	}

	public void setGoals(ArrayList<GoalsModel> goals) {
		this.goals = goals;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public int getWeight() 
	{
		return weight;
	}

	public void setWeight(int weight) 
	{
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}
}