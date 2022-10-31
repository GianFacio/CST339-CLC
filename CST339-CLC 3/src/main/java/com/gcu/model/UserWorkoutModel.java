package com.gcu.model;

public class UserWorkoutModel extends WorkoutModel {

	private int completion;
	private String Status;
	
	public UserWorkoutModel(String name, int calories, String setTime, int completion, String status) {
		super(name, calories, setTime);
		this.completion = completion;
		Status = status;
	}
	
	public int getCompletion() {
		return completion;
	}
	public void setCompletion(int completion) {
		this.completion = completion;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
}
