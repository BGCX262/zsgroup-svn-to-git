package com.zswy.group.test.buildhtml;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
/**
 * DoneNews.java://通过JDBC接口类操作数据库
 * @author Administrator
 *
 */
public class DoneNews {
	@SuppressWarnings("unchecked")
	public Vector getAllNews() {
		Vector vNews = new Vector();
		String sql = "SELECT * FROM news";
		TouchDatabase tdata = new TouchDatabase();
		ResultSet rs = tdata.doSelect(sql);
		try {
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getString("id"));
				news.setTitle(rs.getString("title"));
				news.setPath(rs.getString("path"));
				news.setContent(rs.getString("content"));
				news.setAddtime(rs.getString("addtime"));
				vNews.addElement(news);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return vNews;
	}

	public boolean addNews(News news) {
		boolean success = false;
		if (news != null) {
			String sql = "INSERT news (title,path,content) VALUES('"
					+ news.getTitle() + "','" + news.getPath() + "','"
					+ news.getContent() + "')";
			TouchDatabase tdata = new TouchDatabase();
			success = (0 != tdata.doUpdate(sql));
		}
		return success;
	}

}
