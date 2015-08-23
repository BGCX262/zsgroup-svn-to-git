package com.zswy.group.dao;


import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 用户数据层
 * @author ZhangPeng
 * @date 2010.03.27
 */

public class DBDaoImpl implements IDBDao {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(DBDaoImpl.class);

	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public DataSource getDataSource() {
		return jt.getDataSource();
	}
	
	public JdbcTemplate getJt() {
		// TODO Auto-generated method stub
		return jt;
	}

	
	
}
