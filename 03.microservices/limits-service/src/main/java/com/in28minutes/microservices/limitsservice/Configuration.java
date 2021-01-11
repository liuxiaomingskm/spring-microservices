package com.in28minutes.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
//ConigurationProperties is enough to register the bean, so component could be removed
//"limits-service"必须和application.properties中的key前缀一致，表明springboot会读取application.properties
//中所有前缀为limits-service的key-value pairs
public class Configuration {
	
	private int minimum;
	private int maximum;

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}

}
