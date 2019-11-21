package com.restservice.restfulwebservices;

import com.restservice.restfulwebservices.listener.ApiDiscoveryListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.ServletContextListener;
import java.util.Locale;

@Configuration
@SpringBootApplication
public class RestfulWebservicesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebservicesApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> listenerRegistrationBean() {
		ServletListenerRegistrationBean<ServletContextListener> bean =
				new ServletListenerRegistrationBean<>();
		bean.setListener(new ApiDiscoveryListener());
		return bean;

	}

}
