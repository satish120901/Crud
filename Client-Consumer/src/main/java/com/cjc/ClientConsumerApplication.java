package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientConsumerApplication.class, args);
	}
    @Bean
	//@LoadBalanced
	public RestTemplate rt() {
		RestTemplate rt=new RestTemplate();
		return rt;
	}
}
