package com.vinodh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:nocvue-database-app-context.xml"})
public class BeansLoaderConfig {
	
}
