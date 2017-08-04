package com.pkaleta.todoapp.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
/**
 * 
 * @author pkaleta
 *
 * Spring config class. Define scan packages, beans definition right here.
 */

@Configuration
@ComponentScan(basePackages = "com.pkaleta.todoapp")
public class AppConfig {
 
}