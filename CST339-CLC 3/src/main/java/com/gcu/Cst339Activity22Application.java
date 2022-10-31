package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Cst339Activity22Application 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(Cst339Activity22Application.class, args);
	}

}
