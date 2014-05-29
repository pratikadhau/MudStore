package com.mudstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import com.mudstore.config.intercerptor.BasicInterceptor;

@EnableWebMvc
@ComponentScan(basePackages={"com.mudstore.controller","com.mudstore.service","com.mudstore.rest.controller"})
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
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new BasicInterceptor());
	}
	
}
