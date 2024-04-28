package com.TaskDemo.Task;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@TestConfiguration
public class TestDataSourceConfig {

    @Bean
    public DataSource dataSource() {
        // Configure MySQL DataSource for testing
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/task_db");
        dataSource.setUsername("Springstudent");
        dataSource.setPassword("Springstudent07!");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        // Create JdbcTemplate bean and inject DataSource
        return new JdbcTemplate(dataSource);
    }
}
