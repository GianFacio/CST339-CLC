package com.gcu.model.accounts;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountModel {

	@NotNull(message = "Username is a required field")
	@Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters")
	private String username;
	@NotNull(message = "Password is a required field")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
	private String password;
	
	@NotNull(message = "First name is a required field")
	@Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
	private String firstName;
	
	@NotNull(message = "Last name is a required field")
	@Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters")
	private String lastName;
	
	private int accountID;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public AccountModel(
			@NotNull(message = "Username is a required field") @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters") String username,
			@NotNull(message = "Password is a required field") @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters") String password,
			@NotNull(message = "First name is a required field") @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters") String firstName,
			@NotNull(message = "Last name is a required field") @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters") String lastName,
			int accountID) {
		super();
		this.accountID = accountID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public AccountModel() {}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
}
