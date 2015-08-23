package com.zswy.group.service;

import java.util.List;

import com.zswy.group.exp.ServiceException;

@SuppressWarnings("unchecked")
public interface INewsService {
	
	public void addNewsClass(String lbName)throws ServiceException;
	
	public List getAllNewsClass()throws ServiceException;
}
