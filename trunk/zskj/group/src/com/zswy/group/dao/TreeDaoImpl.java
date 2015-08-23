package com.zswy.group.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.zswy.group.model.Navigate;

public class TreeDaoImpl  implements ITreeDao{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(TreeDaoImpl.class);

	private JdbcTemplate jt;
	@SuppressWarnings("unchecked")
	private List list = new ArrayList();
	
	@SuppressWarnings("unchecked")
	@Override
	public List getTree() throws DataAccessException {
		list = jt.queryForList("select id, parentId, text, number, leaf, href from navigate where parentId is null");
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List findChildRenTreeById(int id) throws DataAccessException {
		String sql = "select id, parentId, text, number, leaf, href from navigate where parentId="+id;
//		log.info(sql);
//		list = jt.queryForList(sql);
		 List list = (List) jt.query(sql, new ResultSetExtractor() {			 
				@Override
				public Object extractData(ResultSet rs) throws SQLException,
						DataAccessException {
					Navigate navigate = new Navigate();
					navigate.setId(rs.getInt("id"));
					navigate.setParentId(rs.getInt("parentId"));
					navigate.setText(rs.getString("text"));
					navigate.setNumber(rs.getInt("number"));
					navigate.setLeaf(rs.getInt("leaf"));
					navigate.setHref(rs.getString("href"));
					return navigate;
				}
			   });
			   return list;
	}
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public DataSource getDataSource() {
		return jt.getDataSource();
	}
	
	public JdbcTemplate getJt() {
		// TODO Auto-generated method stub
		return jt;
	}


	
}
