package com.daironh.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration(value = "configDS2")
public class DataSource2 {

	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "app.datasource.db2")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "tm2")
	@Autowired
	DataSourceTransactionManager tm1(@Qualifier("dataSource2") DataSource datasource) {
		DataSourceTransactionManager txm = new DataSourceTransactionManager(datasource);
		return txm;
	}
}
