package com.careerit.learnspringboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

//@Configuration
@PropertySource(value = "classpath:db.properties")
public class AppConfig {
	
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.url}")
	private String url;
	@Value("${db.driver}")
	private String driver;
	
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = DataSourceBuilder
				.create()
				.driverClassName(driver)
				.url(url)
				.username(username)
				.password(password)
				.build();
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
