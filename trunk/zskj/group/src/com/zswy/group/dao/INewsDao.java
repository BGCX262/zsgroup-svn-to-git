package com.zswy.group.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.zswy.group.model.NewsClass;

/**
 * 新闻类别
 * @author zhangpeng
 *
 */
public interface INewsDao {
	/**
	 * 添加新闻类别
	 * @param newsId
	 * @param lbName
	 * @throws DataAccessException
	 */
	public void saveNewsClass(String newsId, String lbName)throws DataAccessException;
	
	/**
	 * 查找新闻类别
	 * @param newsId
	 * @return
	 * @throws DataAccessException
	 */
	public NewsClass findNewsClassByNewsId(String newsId)throws DataAccessException;
	
	/**
	 * 删除一条新闻类别
	 * @param newsId
	 * @throws DataAccessException
	 */
	public void removeNewsClassByNewsId(String newsId)throws DataAccessException;
	
	/**
	 * 查找全部类别
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public List findNewsClass()throws DataAccessException;
}
