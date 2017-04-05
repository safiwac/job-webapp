package com.job.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 * @author EL HAHY Zakaria
 */
@Configuration
@EnableJpaRepositories(basePackages = {"org.job.entity"},transactionManagerRef = "jpaTransactionManager")
@EnableTransactionManagement
public class PersistanceConfiguratione {

	@Autowired
	Environment env;
	
	@Bean
	@Autowired
	public EntityManagerFactory entityManagerFactory(DataSource dataSource,Properties jpaProperties){
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		HibernateJpaVendorAdapter hibernateAdpater = new HibernateJpaVendorAdapter();
		hibernateAdpater.setGenerateDdl(false);
		hibernateAdpater.setShowSql(false);
		hibernateAdpater.setDatabase(Database.MYSQL);
		entityManagerFactory.setJpaVendorAdapter(hibernateAdpater);
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setPackagesToScan(new String[]{"org.job.entity.model"});
		entityManagerFactory.setJpaProperties(jpaProperties());
		entityManagerFactory.setPersistenceUnitName("jobNow-entity");
		entityManagerFactory.afterPropertiesSet();
		//entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
		return entityManagerFactory.getObject();
		
	}
	
	
	
	@Bean(name = "jpaTransactionManager")
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory ){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setJpaDialect(new HibernateJpaDialect());
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
		
	}
	
	
	/**
	 * Properties
	 * @return
	 */
	@Bean
	public Properties jpaProperties(){
		Properties prop = new Properties();
//		prop.put("hibernate.hbm2ddl.auto", env.getProperty("hbm2ddl.auto",""));
//		prop.put("hibernate.show_sql", env.getProperty("show_sql"));
//		prop.put("hibernate.synonyms", env.getProperty("env.synonyme",""));
		return prop;
		
	}
}
