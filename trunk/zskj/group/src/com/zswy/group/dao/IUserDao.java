package com.zswy.group.dao;

import org.springframework.dao.DataAccessException;

public interface IUserDao {
	
	public void addUser(String name)throws DataAccessException;
	
}
