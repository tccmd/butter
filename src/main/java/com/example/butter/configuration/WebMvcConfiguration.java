package com.example.butter.configuration;

// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.butter.interceptor.LoggerInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new LoggerInterceptor());
	}

	// @Bean
    // public StandardServletMultipartResolver multipartResolver2(){
    //     return new StandardServletMultipartResolver();
    // }

	// @Bean
	// public StandardServletMultipartResolver multipartResolver(){
	// 	StandardServletMultipartResolver commonsMultipartResolver = new StandardServletMultipartResolver();
	// 	return commonsMultipartResolver;
	// }
}
