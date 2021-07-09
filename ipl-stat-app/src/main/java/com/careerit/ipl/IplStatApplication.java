package com.careerit.ipl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class IplStatApplication {

		public static void main(String[] args) {
			SpringApplication.run(IplStatApplication.class, args);
		}
}
