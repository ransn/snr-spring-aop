package com.snr.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * This SpringBootApplication annotation includes below annotations:
 * @SpringBootConfiguration - Tags the class as a root configuration source
 * @EnableAutoConfiguration - Instructs spring to automatically add beans based dependencies in
 * your class path.
 * @ComponentScan - Directs spring to look for components @Service, @Repository, @RestController
 */
public class SnrSpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnrSpringAopApplication.class, args);
	}

}
