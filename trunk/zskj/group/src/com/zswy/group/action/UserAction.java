package com.zswy.group.action;

import org.apache.log4j.Logger;

import com.zswy.group.exp.ActionException;
import com.zswy.group.exp.ServiceException;
import com.zswy.group.model.User;
import com.zswy.group.service.IUserService;

public class UserAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2922831550061029109L;
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(UserAction.class);
	@SuppressWarnings("unused")
	private User user;
	private IUserService userService;
	
	public String register()throws ActionException{
		try {		
			userService.addUser("张三");
		} catch (ServiceException e) {
		e.printStackTrace();
		}
		return "success";
	}
	
	public String test1()throws ActionException{
		System.out.println("test1方法。。。");
		return "success";
	}
	
	public String test2()throws ActionException{
		System.out.println("test2方法。。。");
		return "success";
	}
	
	public String add()throws ActionException{
		System.out.println("添加方法。。。");
		return "success";
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
