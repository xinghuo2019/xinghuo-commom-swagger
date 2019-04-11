package com.xinghuo.swagger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMVCConfig extends WebMvcConfigurationSupport{
	
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		super.addResourceHandlers(registry);
	}
	
	public void configureDefaultServletHadling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}
	
}
