package com.zswy.group.service;

import java.util.ArrayList;
import java.util.List;

import com.zswy.group.dao.ITreeDao;
import com.zswy.group.exp.ServiceException;

public class TreeServiceImpl implements ITreeService {
	private ITreeDao dao;
	@SuppressWarnings("unchecked")
	private List list = new ArrayList();
	
	@SuppressWarnings("unchecked")
	@Override
	public List getTree() throws ServiceException {
		list = dao.getTree();
		return list;
	}
	
	public void setDao(ITreeDao dao) {
		this.dao = dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getChildRenTree(int id) throws ServiceException {
		System.out.println(id+"===="+dao.getTree());
		return dao.findChildRenTreeById(id);
	}
}
