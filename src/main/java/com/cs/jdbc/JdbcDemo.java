package com.cs.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDemo {
  
  @Autowired
  JdbcTemplate jdbcTemplate;
  
  public void execute() throws Exception
  {
    final String SELECT_ALL = "select * from employee";
    
    List<Employee> employees = jdbcTemplate.query(SELECT_ALL, new EmployeeMapper());
    for (Employee employee : employees) {
      System.out.println(employee.getFirstName());
    }
  }
}
