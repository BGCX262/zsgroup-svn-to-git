package com.zswy.group.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author zhangpeng
 * 
 */
public class BaseAction extends ActionSupport implements ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5651802329612754236L;
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private HttpServletResponse response;
	
	/**
	 * 获得request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 获得response
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 获得session
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 获得servlet上下文
	 * 
	 * @return
	 */
	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public String getRealyPath(String path) {
		return getServletContext().getRealPath(path);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getContextPath() {

		return getRequest().getContextPath();
	}
	
	public void setServletResponse(HttpServletResponse response) {
		
		this.response = response;
	}
}
