package com.desarrollo.taller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TallerApplication {

	public static final Logger LOGGER = LoggerFactory.getLogger(TallerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TallerApplication.class, args);
	}

}
