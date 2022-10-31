package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.services.HardCodedRestService;
import com.gcu.services.RestServiceInterface;


@Configuration
public class SpringConfig {

	@Bean(name="trainerRestService")
	public RestServiceInterface getOrdersBusiness()
	{
		return new HardCodedRestService();
	}
	
}
