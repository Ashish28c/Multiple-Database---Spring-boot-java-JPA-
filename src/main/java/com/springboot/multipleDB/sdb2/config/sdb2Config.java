package com.springboot.multipleDB.sdb2.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		
				entityManagerFactoryRef = "SecondEmfBean",
				basePackages = {"com.springboot.multipleDB.sdb2.Repo"},
				transactionManagerRef = "SecondtransactionManager"
		
		
		)
public class sdb2Config {
	@Autowired
	private Environment environment;
	
	@Bean(name = "SecondDb")
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("db2.datasource.url"));
		dataSource.setDriverClassName(environment.getProperty("db2.datasource.driver-class-name"));
		dataSource.setUsername(environment.getProperty("db2.datasource.username"));
		dataSource.setPassword(environment.getProperty("db2.datasource.password"));
		return dataSource;
	}
	
	@Bean(name = "SecondEmfBean")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		
		AbstractJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(jpaVendorAdapter);
		
		Map<String, Object>props = new HashMap<>();
		props. put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect") ;
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");

		
		bean.setJpaPropertyMap(props);		
		bean.setPackagesToScan("com.springboot.multipleDB.sdb2.entities");
		return bean;
	}
	
	@Primary
	@Bean(name = "SecondtransactionManager")
	PlatformTransactionManager transactionManager() {
		
		JpaTransactionManager Manager = new JpaTransactionManager();
		Manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return Manager;
	}

}
