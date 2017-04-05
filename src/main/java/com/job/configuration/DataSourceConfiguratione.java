package com.job.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/*
 * @author EL HAHY Zakaria
 */

@Configuration
public class DataSourceConfiguratione {
	
	@Autowired
	private Environment env;

	
	@Bean
	@Autowired
    public DataSource dataSource(HikariConfig configuration){
		HikariDataSource dataSource = new HikariDataSource(configuration);
    	return dataSource;
    }
	
	@Bean
	public HikariConfig configuration() throws SQLException{
		HikariConfig config = new HikariConfig();
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
		config.setDataSource(dataSource);
		return config; 	
	}

}
