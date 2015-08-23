package com.zswy.group.service;

import java.util.List;

import com.zswy.group.exp.ServiceException;

@SuppressWarnings("unchecked")
public interface ITreeService {
	
	public List getTree()throws ServiceException;
	
	public List getChildRenTree(int id)throws ServiceException;
}
