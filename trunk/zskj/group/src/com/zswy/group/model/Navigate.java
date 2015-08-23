package com.zswy.group.model;
/**
 * 树菜单导航
 * @author peter
 *
 */
@SuppressWarnings("serial")
public class Navigate implements java.io.Serializable {
	private int id;
	private int parentId;
	private String text;
	private int number;
	private int leaf;
	private String href;

	public Navigate() {

	}

	public Navigate(int parendId, String text, int number, int leaf, String href) {
		this.parentId = parendId;
		this.text = text;
		this.number = number;
		this.leaf = leaf;
		this.href = href;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}



	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getLeaf() {
		return leaf;
	}

	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}



}
