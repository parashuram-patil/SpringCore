package com.cs.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfig {
  
  @Autowired
  private Environment env;
  
  @Bean
  public BasicDataSource getDataSource()
  {
    BasicDataSource dataSource = new BasicDataSource();
    //getOracleDataSource(dataSource);
    getPostgreDataSource(dataSource);
    return dataSource;
  }

  private void getPostgreDataSource(BasicDataSource dataSource)
  {
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/camundadb");
    dataSource.setUsername("admin");
    dataSource.setPassword("pass@123");
  }
  
  private void getOracleDataSource(BasicDataSource dataSource)
  {
    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
    dataSource.setUsername("system");
    dataSource.setPassword("psp");
  }
  
  @Bean
  public JdbcTemplate jdbcTemplate()
  {
    return new JdbcTemplate(getDataSource());
  }
  
  @Bean(name = "transactionManager")
  public PlatformTransactionManager txManager()
  {
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(
        getDataSource());
    return transactionManager;
  }
}
