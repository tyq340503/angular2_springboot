package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.example.demo.config.JwtFilter;

//@MapperScan("xxx.mapper")
//@MapperScan(basePackages = { "com.example.demo.dao" }, sqlSessionFactoryRef = "sqlSessionFactory")
@ComponentScan(basePackages={"com.example.demo","com.example.demo.controller","com.example.demo.dao","com.example.demo.service","com.example.demo.service.impl"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

public class BackendApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/rest/*");

		return registrationBean;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}
