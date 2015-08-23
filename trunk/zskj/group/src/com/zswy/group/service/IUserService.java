package com.zswy.group.service;

import com.zswy.group.exp.ServiceException;


/**
 * 通用服务组件
 * @author ZhangPeng
 *
 */
public interface IUserService {
	
	void addUser(String name)throws ServiceException;

}
