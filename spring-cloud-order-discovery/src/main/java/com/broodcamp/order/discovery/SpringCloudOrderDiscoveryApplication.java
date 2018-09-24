package com.broodcamp.order.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudOrderDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrderDiscoveryApplication.class, args);
	}
}
