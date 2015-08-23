package com.zswy.group.model;

import java.util.Date;

/**
 * 
 * @author zhangpeng
 * 
 */
@SuppressWarnings("serial")
public class NewsClass implements java.io.Serializable {
	private String newsId;
	private String lbName;
	private Date createDate;

	public NewsClass() {

	}

	public NewsClass(String lbName, Date createDate) {
		this.lbName = lbName;
		this.createDate = createDate;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getLbName() {
		return lbName;
	}

	public void setLbName(String lbName) {
		this.lbName = lbName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
}
