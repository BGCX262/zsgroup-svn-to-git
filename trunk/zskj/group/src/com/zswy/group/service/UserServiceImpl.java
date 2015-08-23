package com.zswy.group.service;

import com.zswy.group.dao.IUserDao;
import com.zswy.group.exp.ServiceException;


public class UserServiceImpl implements IUserService {

	private IUserDao dao;

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	@Override
	public void addUser(String name) throws ServiceException {
		
			dao.addUser(name);
	}

	
}
