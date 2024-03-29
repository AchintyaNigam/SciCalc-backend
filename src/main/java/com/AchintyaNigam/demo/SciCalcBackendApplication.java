package com.AchintyaNigam.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SciCalcBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SciCalcBackendApplication.class, args);
	}

}
