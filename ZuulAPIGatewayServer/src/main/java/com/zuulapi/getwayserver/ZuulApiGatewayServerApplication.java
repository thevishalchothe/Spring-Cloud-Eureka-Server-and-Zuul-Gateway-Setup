package com.zuulapi.getwayserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		
	    final Logger logger = LoggerFactory.getLogger(ZuulApiGatewayServerApplication.class);
        
	    System.out.println("Zuul API Gateway Server is getting Started!");

		SpringApplication.run(ZuulApiGatewayServerApplication.class, args);
		
        logger.info("Zuul API Gateway Server is up and running!");

	}

}
