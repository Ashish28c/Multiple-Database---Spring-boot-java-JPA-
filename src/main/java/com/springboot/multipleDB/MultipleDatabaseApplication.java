package com.springboot.multipleDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@SpringBootApplication
@RestController
public class MultipleDatabaseApplication {
	

	 private static final Logger logger = LogManager.getLogger(MultipleDatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MultipleDatabaseApplication.class, args);
		logger.error("An error occurred");
	}

}
