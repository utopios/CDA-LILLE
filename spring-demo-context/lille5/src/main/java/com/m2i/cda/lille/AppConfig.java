package com.m2i.cda.lille;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.m2i.cda.lille.controller","com.m2i.cda.lille.service","com.m2i.cda.lille.entity"})
public class AppConfig {
}
