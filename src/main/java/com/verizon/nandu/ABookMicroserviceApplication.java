package com.verizon.nandu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class ABookMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ABookMicroserviceApplication.class, args);
	}


	@Bean
	RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
