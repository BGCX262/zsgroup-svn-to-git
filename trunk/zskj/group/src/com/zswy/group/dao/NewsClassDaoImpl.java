package com.zswy.group.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zswy.group.model.NewsClass;

public class NewsClassDaoImpl implements INewsClassDao {
	
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(NewsClassDaoImpl.class);

	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public DataSource getDataSource() {
		return jt.getDataSource();
	}
	
	public JdbcTemplate getJt() {
		
		return jt;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List findNewsClass() throws DataAccessException {
		
		return null;
	}

	@Override
	public NewsClass findNewsClassByNewsId(String newsId)
			throws DataAccessException {
		
		return null;
	}

	@Override
	public void removeNewsClassByNewsId(String newsId)
			throws DataAccessException {
		

	}

	@Override
	public void saveNewsClass(String newsId, String lbName)
			throws DataAccessException {
		String sql = "insert into zs_newsclass(news_id,lb_name,create_date)values('"+newsId+"', '"+lbName+"', now())";
		jt.execute(sql);
	}

}
