package com.gcu.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WorkoutModel {
	
	@NotNull(message = "Workout name is a required field")
	@Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
	private String name;
	
	@NotNull(message = "Calories is a required field")
	@Min(value = 1, message = "Calories should not be less than 1")
	@Max(value = 2000, message = "No way you have a set that burns over 2000 calories")
	
	private int caloriesPerSet;
	@NotNull(message = "Time Per Set is a required field")
	@Size(min = 1, max = 32, message = "Time per Set must be between 1 and 32 characters")
	private String timePerSet;
	
	public WorkoutModel(String name, int calories, String setTime) {
		super();
		this.name = name;
		caloriesPerSet = calories;
		setTimePerSet(setTime);
		
	}
	
	public WorkoutModel() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCaloriesPerSet() {
		return caloriesPerSet;
	}
	public void setCaloriesPerSet(int calories) {
		caloriesPerSet = calories;
	}
	
	public String getTimePerSet() {
		return timePerSet;
	}
	public void setTimePerSet(String timePerSet) {
		this.timePerSet = timePerSet;
	}
	
	
}
