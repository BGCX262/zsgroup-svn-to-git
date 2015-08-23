package com.zswy.group.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements IUserDao {
	
	private static final Logger log = Logger.getLogger(UserDaoImpl.class);

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
	
	@Override
	public void addUser(String name) throws DataAccessException {
		log.info("姓名:"+name);
		System.out.println("数据源。。。"+jt.getDataSource());
		for(int i=0;i<10000;i++){
			jt.execute("insert into customer(name)values('"+name+"')");
		}
	
		
	}
	

}
