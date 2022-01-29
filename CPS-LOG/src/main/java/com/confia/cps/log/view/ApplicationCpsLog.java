package com.confia.cps.log.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({ 
	  "file:/opt/fuse/jboss-eap-7.2/cps-log-viewer.properties"
	})
public class ApplicationCpsLog extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCpsLog.class, args);
	}
	
	protected SpringApplicationBuilder configure( SpringApplicationBuilder builder ) {
		
		return builder.sources(ApplicationCpsLog.class);
	}
}
