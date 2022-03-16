// package com.code.springsecurity;

// import javax.sql.DataSource;

// import com.mchange.v2.c3p0.ComboPooledDataSource;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.env.Environment;

// @Configuration
// public class DataSourceConfig {
//     @Autowired
//     private Environment env;

//     // define bean for security datasource
//     @Bean
//     public DataSource securityDataSource() {
//         ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

//         // set database connection props
//         securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
//         securityDataSource.setUser(env.getProperty("jdbc.user"));
//         securityDataSource.setPassword(env.getProperty("jdbc.password"));

//         // set connection pool props
//         securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
//         securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
//         securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
//         securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

//         return securityDataSource;
//     }

//     // helper method to read env and convert to int
//     private int getIntProperty(String propName) {
//         String propVal = env.getProperty(propName);

//         // conveting to int
//         int intProp = Integer.parseInt(propVal);

//         return intProp;
//     }
// }