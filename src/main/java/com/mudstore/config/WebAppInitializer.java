package com.mudstore.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(AppConfig.class);
		addDispatcherServlet(servletContext, mvcContext);
		addJerseyServlet(servletContext);
	}

	private void addJerseyServlet(ServletContext servletContext) {
		ServletRegistration.Dynamic jerseyServlet = servletContext.addServlet("jersey",new SpringServlet());
		jerseyServlet.setInitParameter("com.sun.jersey.config.property.packages", "com.mudstore.rest.controller");
		jerseyServlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
		jerseyServlet.addMapping("/rest/*");
		jerseyServlet.setLoadOnStartup(1);
	}

	private void addDispatcherServlet(ServletContext servletContext,
			AnnotationConfigWebApplicationContext mvcContext) {
		ServletRegistration.Dynamic appServlet = servletContext.addServlet(
				"dispatcher", new DispatcherServlet(mvcContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
	}

}
