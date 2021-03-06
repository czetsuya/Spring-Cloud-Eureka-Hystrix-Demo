package com.broodcamp.order.product.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class SpringCloudOrderProductApiApplication {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2) //
				.groupName("Product") //
				.select() //
				.apis(RequestHandlerSelectors.any()) //
				.paths(PathSelectors.any()) //
				.build() //
				.apiInfo(new ApiInfo("Product Services", "A set of product services", "1.0.0", "tos",
						new springfox.documentation.service.Contact("Edward P. Legaspi", "http://localhost", "license"),
						"licenseUrl", null));
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrderProductApiApplication.class, args);
	}
}
