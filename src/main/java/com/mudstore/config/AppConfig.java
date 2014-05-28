package com.mudstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@EnableWebMvc
@ComponentScan(basePackages={"com.mudstore.controller","com.mudstore.service"})
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public VelocityConfigurer getVelocityConfig(){
		VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
		velocityConfigurer.setResourceLoaderPath("/WEB-INF/Views");
		return velocityConfigurer;
	}
	
	@Bean
	public VelocityViewResolver getVelocityViewResolver(){
		VelocityViewResolver velocityViewResolver = new VelocityViewResolver();
		velocityViewResolver.setPrefix("");
		velocityViewResolver.setSuffix(".vm");
		return velocityViewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}
	
	
}
