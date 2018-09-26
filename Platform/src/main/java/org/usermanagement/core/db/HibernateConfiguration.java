package org.usermanagement.core.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {
    @Autowired
    private Environment environment;
    @Value("classpath:oAuth2DLL.sql")
    private Resource oAuth2DDLScript;
    @Value("classpath:SchemaCreator.sql")
    private Resource schemaCreator;
    @Value("classpath:oAuth2DML.sql")
    private Resource oAuth2DMLScript;
    @Value("classpath:QuartzDDL.sql")
    private Resource quartzDDLScript;

    public HibernateConfiguration() {}

    @Bean
    @Autowired
    public DataSourceInitializer dataSourceInitializer(DataSource defaultDataSource, DatabasePopulator databasePopulator){
        System.out.print("datasource init");
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(defaultDataSource);
        initializer.setDatabasePopulator(databasePopulator);
        return initializer;
    }

    @Bean
    public DatabasePopulator databasePopulator(){
        ResourceDatabasePopulator dataPopulate = new ResourceDatabasePopulator();
        if ("create".equalsIgnoreCase(this.environment.getRequiredProperty("hibernate.hbm2ddl.auto")))
        {
            dataPopulate.addScript(this.schemaCreator);
            dataPopulate.addScript(this.oAuth2DDLScript);
            dataPopulate.addScript(this.quartzDDLScript);
            dataPopulate.addScript(this.oAuth2DMLScript);
        }
        return dataPopulate;
    }

    @Bean
    public LocalSessionFactoryBean defaultSessionFactory() {
        System.out.print("HIBERNATAE_LOADING_CALLED");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(defaultDataSource());
        sessionFactory.setPackagesToScan(new String[]{ "org.model.usermanagement", "org.model.workflow", "org.model.util" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource defaultDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("hibernate.connection.driver_class"));
        dataSource.setUrl(environment.getRequiredProperty("hibernate.connection.url"));
        dataSource.setUsername(environment.getRequiredProperty("hibernate.connection.username"));
        dataSource.setPassword(environment.getRequiredProperty("hibernate.connection.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.generate_statistics", environment.getRequiredProperty("hibernate.generate_statistics"));
        properties.put("hibernate.default_schema", environment.getRequiredProperty("hibernate.default_schema"));
        properties.put("hibernate.current_session_context_class", environment.getRequiredProperty("hibernate.current_session_context_class"));
        if ("create".equalsIgnoreCase(properties.getProperty("hibernate.hbm2ddl.auto"))) {
            properties.put("hibernate.hbm2ddl.import_files", environment.getRequiredProperty("hibernate.hbm2ddl.import_files"));
        }
        //properties.put("hibernate.connection.verifyServerCertificate", this.environment.getRequiredProperty("hibernate.connection.verifyServerCertificate"));
        //properties.put("hibernate.connection.useSSL", this.environment.getRequiredProperty("hibernate.connection.useSSL"));
        return properties;
    }

    @Bean
    @Autowired
    public Map<String, SessionFactory> sessionFactoryMap(@Qualifier("defaultSessionFactory") SessionFactory defaultSessionFactory) {
        Map<String, SessionFactory> sessionFactoryMap = new HashMap<String, SessionFactory>();
        sessionFactoryMap.put(HibernateUtils.DEFAULT, defaultSessionFactory);
        return sessionFactoryMap;
    }
}