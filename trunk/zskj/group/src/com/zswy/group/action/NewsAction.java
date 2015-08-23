package com.zswy.group.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zswy.group.exp.ActionException;
import com.zswy.group.exp.ServiceException;
import com.zswy.group.model.NewsClass;
import com.zswy.group.service.INewsService;
import com.zswy.group.util.Constants;



@SuppressWarnings("serial")
public class NewsAction extends BaseAction {

	private static final Logger log = Logger.getLogger(NewsAction.class);
	private INewsService newsService;
	@SuppressWarnings("unchecked")
	private List list = new ArrayList();
	public String addNewsClass()throws ActionException{
		try {
			newsService.addNewsClass("新闻资讯");
		} catch (ServiceException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return Constants.WELCOME;
	}
	
	public String getNewsClass() throws ActionException{
		try {
			list = newsService.getAllNewsClass();
			getRequest().setAttribute("list", list);
		} catch (ServiceException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public String skipClass(){
		
		return Constants.CLASS;
	}
	
	public void setNewsClass(NewsClass newsClass) {
	}

	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}
	
	
}
