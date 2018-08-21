package com.speruri.spring.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({ "com.speruri" })
@PropertySource("app.properties")
public class AppConfig {

//	public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}

}
