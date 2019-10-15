package com.daironh.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration(value = "configDS1")
@EnableTransactionManagement
public class DataSource1 {

	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "app.datasource.db1")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "tm1")
	@Autowired
	@Primary
	DataSourceTransactionManager tm1(@Qualifier("dataSource") DataSource datasource) {
		DataSourceTransactionManager txm = new DataSourceTransactionManager(datasource);
		return txm;
	}

}
