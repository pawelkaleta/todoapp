package com.pkaleta.todoapp.cfg;


import java.util.Properties;
 
import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 

/**
 * 
 * @author pkaleta
 *
 * Hibernate configuration. Define sessions, data source streams, and hibernate framework properties, transactions managers right here.
 * Also this class is using PropertySource annotation to define settings in additional file, that are used by this class. 
 */

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.pkaleta.todoapp.cfg" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {
 
	/**
	 * this interface is used to resolve Properties mechanism 
	 */
    @Autowired
    private Environment environment;
 
    /**
     * Create sessionFactory, that's used in ORM to make operations on the db, by Tables and Entities defined in model package
     * @return SessionFactory Bean
     * @see org.springframework.orm.hibernate5.LocalSessionFactoryBean#LocalSessionFactoryBean()
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.pkaleta.todoapp.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    
    }
     
    
    /**
     * Create data source using DataSource interface to get connection to the db
     * @return dataSource
     * @see javax.sql.DataSource
     * @see org.springframework.jdbc.datasource.DriverManagerDataSource#DriverManagerDataSource()
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
       
        return dataSource;
    }
    
     /**
      * Get properties from resource application.properties and create Properties object based on the file 
      * @return properties
      * @see java.util.Properties#Properties()
      */
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;        
    }
     
    /**
     *  Create manager of transactions
     * @param s SessionFactory object
     * @return TransactionalManager
     * @see org.springframework.orm.hibernate5.HibernateTransactionManager#HibernateTransactionManager()
     */
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
}