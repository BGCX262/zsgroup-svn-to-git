package com.zswy.group.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public interface IDBDao {
	
	public DataSource getDataSource();

	public JdbcTemplate getJt();
	
}
