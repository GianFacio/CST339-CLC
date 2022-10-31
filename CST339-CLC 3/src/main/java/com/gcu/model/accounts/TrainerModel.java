package com.gcu.model.accounts;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TrainerModel extends AccountModel
{
	private int trainerID;

	public int getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}

	public TrainerModel(
			@NotNull(message = "Username is a required field") @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters") String username,
			@NotNull(message = "Password is a required field") @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters") String password,
			@NotNull(message = "First name is a required field") @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters") String firstName,
			@NotNull(message = "Last name is a required field") @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters") String lastName,
			int trainerID,
			int accountID) {
		super(username, password, firstName, lastName, accountID);
		this.trainerID = trainerID;
	}
	
	public TrainerModel() {}
	
}
