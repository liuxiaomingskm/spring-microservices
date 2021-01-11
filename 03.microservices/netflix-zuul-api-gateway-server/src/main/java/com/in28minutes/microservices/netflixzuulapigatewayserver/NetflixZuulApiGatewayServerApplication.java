package com.in28minutes.microservices.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
//put the following annotation on the Zuul Server
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
	// create Sampler for requests to be traceable
	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
}

/* 为了能够成功拦截request 需要更改url为
 * http://localhost:8765/{application name}/{URL}
 * i.e
 * application name是currency-service,正常访问的url是http://hocalhost:8000/currency-exchange-service/from/EUR/to/INR
 * 8000是该server的端口， 8761是Zuul的端口
 * 需要更改url为http://localhost:8765/currency-exchange-service/currency-exchange-service/from/EUR/to/INR
 * 
 */
