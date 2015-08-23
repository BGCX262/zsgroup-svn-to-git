package com.zswy.group.model;

import java.util.Date;
/**
 * 
 * @author zhangpeng
 *
 */
@SuppressWarnings("serial")
public class News implements java.io.Serializable {

	private String id;
	private String newsId;
	private String title;
	private String slbt;
	private String name;
	private String imgPath;
	private String nrjy;
	private String content;
	private int clickCount;
	private int tjNews;
	private Date createDate;

	public News() {

	}

	public News(String newsId, String title, String slbt, String name,
			String imgPath, String nrjy, String content, int clickCount,
			int tjNews, Date createDate) {
		this.newsId = newsId;
		this.title = title;
		this.slbt = slbt;
		this.name = name;
		this.imgPath = imgPath;
		this.nrjy = nrjy;
		this.content = content;
		this.clickCount = clickCount;
		this.tjNews = tjNews;
		this.createDate = createDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlbt() {
		return slbt;
	}

	public void setSlbt(String slbt) {
		this.slbt = slbt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getNrjy() {
		return nrjy;
	}

	public void setNrjy(String nrjy) {
		this.nrjy = nrjy;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public int getTjNews() {
		return tjNews;
	}

	public void setTjNews(int tjNews) {
		this.tjNews = tjNews;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
