package com.myhotel.customerms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomermsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomermsApplication.class, args);
	}

}
