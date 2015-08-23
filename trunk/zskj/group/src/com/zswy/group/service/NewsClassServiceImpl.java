package com.zswy.group.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zswy.group.dao.INewsClassDao;
import com.zswy.group.exp.ServiceException;
import com.zswy.group.util.IdUtils;
import com.zswy.group.util.Timer;
@SuppressWarnings("unchecked")
public class NewsClassServiceImpl implements INewsClassService {

	
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(NewsClassServiceImpl.class);
	private INewsClassDao dao;
	@SuppressWarnings("unused")
	private List list = new ArrayList();
	

	public void setDao(INewsClassDao dao) {
		this.dao = dao;
	}



	@Override
	public void addNewsClass(String lbName) throws ServiceException {
		dao.saveNewsClass(Timer.generateSysdate("3")+IdUtils.genSixNumId(), lbName);
	}


	@Override
	public List getAllNewsClass() throws ServiceException {
		
		return dao.findNewsClass();
	}

}
