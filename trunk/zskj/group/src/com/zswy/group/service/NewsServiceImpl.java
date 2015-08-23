package com.zswy.group.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.zswy.group.dao.INewsDao;
import com.zswy.group.exp.ServiceException;
import com.zswy.group.util.IdUtils;
import com.zswy.group.util.Timer;

@SuppressWarnings("unused")
public class NewsServiceImpl implements INewsService {

	
	private static final Logger log = Logger.getLogger(NewsServiceImpl.class);
	private INewsDao dao;

	@SuppressWarnings("unchecked")
	private List list ;
	
	public void setDao(INewsDao dao) {
		this.dao = dao;
	}

	@Override
	public void addNewsClass(String lbName) throws ServiceException {
		dao.saveNewsClass(Timer.generateSysdate("3")+IdUtils.genSixNumId(), lbName);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List getAllNewsClass() throws ServiceException {
		
		return dao.findNewsClass();
	}

}
