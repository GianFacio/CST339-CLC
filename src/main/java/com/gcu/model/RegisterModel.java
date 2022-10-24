package com.gcu.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterModel 
{
	@NotNull(message = "First name is a required field")
	@Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
	private String firstName;
	
	@NotNull(message = "Last name is a required field")
	@Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters")
	private String lastName;
	
	@Min(value = 1, message = "Age should not be less than 1")
	private int age;
	
	@Min(value = 1, message = "Weight should not be less than 1 pound")
	private int weight;
	
	@Min(value = 1, message = "Height should not be less than 1 inch")
	private int height;
	
	@NotNull(message = "Username is a required field")
	@Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters")
	private String username;

	@NotNull(message = "Password is a required field")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
	private String password;
	
	
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

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
}