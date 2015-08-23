package com.zswy.group.action;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zswy.group.exp.ServiceException;
import com.zswy.group.service.ITreeService;
import com.zswy.group.util.Constants;
import com.zswy.group.util.ResponseUtil;
/**
 * 系统初始化
 * @author zhangpeng
 *
 */
public class SysAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3159638780517818305L;
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(SysAction.class);
	private ITreeService treeService;
	@SuppressWarnings("unchecked")
	private List list = new ArrayList();
	
	
	public String extMan(){
		return Constants.WELCOME;
	}
	
	public String getTree() throws ServiceException{
		list = treeService.getTree();
		ResponseUtil.transportExtTree(getResponse(),list);
		return  null;
		
	}
	
	public void setTreeService(ITreeService treeService) {
		this.treeService = treeService;
	}
}
