package com.cjc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@EnableWebMvc
@ComponentScan(basePackages= {"com.cjc.model"
				,"com.cjc.service",
				"com.cjc.dao","com.cjc.config","com.cjc.controller",})
public class WebConfig extends WebMvcConfigurerAdapter
{
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		//resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/jsp/");///WebContent/jsp
		resolver.setSuffix(".jsp");
		
		
		return resolver;
	}

}
