package com.zswy.group.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
@SuppressWarnings("unchecked")
public interface ITreeDao {
	
	public List getTree()throws DataAccessException;
	
	public List findChildRenTreeById(int id)throws DataAccessException;
}
