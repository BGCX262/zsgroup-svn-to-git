package com.zswy.group.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * ext json树状菜单
 * @author zhangpeng
 * @date 2010.03.25
 * 
 */
@SuppressWarnings("unchecked")
public class TreeUtil {
	private static final Logger log = Logger.getLogger(TreeUtil.class);
	private static List list ,list1,list2,list3;
	private static JdbcTemplate jt;
	public static StringBuffer getExtTree(List results) throws Exception {
		StringBuffer sb = new StringBuffer("[");
		try {
			if (results != null) {
				if (results.size() > 0) {	
					for(int i=0;i<results.size();i++){
						Map map = (Map)results.get(i);
						sb.append("{");
						sb.append("id:").append("\"").append(map.get("id")).append("\",");
						sb.append("text:").append("\"").append(map.get("text")).append("\",");
						sb.append("href:").append("\"").append(map.get("href")).append("\"");
						String sql = "select id, parentId, text, number, leaf, href from navigate where parentId="+map.get("id");
						list = new ArrayList();
						list = jt.queryForList(sql);
						if(list != null && list.size()>0){
							sb.append(",");
							sb.append("children:");
							sb.append("[");
							for(int j=0;j<list.size();j++){
								Map map1 = (Map)list.get(j);
								sb.append("{");
								sb.append("id:").append("\"").append(map1.get("id")).append("\",");
								sb.append("text:").append("\"").append(map1.get("text")).append("\",");
								sb.append("href:").append("\"").append(map1.get("href")).append("\"");
								String sql2 = "select id, parentId, text, number, leaf, href from navigate where parentId="+map1.get("id");
								list1 = new ArrayList();
								list1 = jt.queryForList(sql2);
								if(list1 != null && list1.size()>0){
									sb.append(",");
									sb.append("children:");
									sb.append("[");
									for(int k=0;k<list1.size();k++){
										Map map2 = (Map)list1.get(k);
										sb.append("{");
										sb.append("id:").append("\"").append(map2.get("id")).append("\",");
										sb.append("text:").append("\"").append(map2.get("text")).append("\",");
										sb.append("href:").append("\"").append(map2.get("href")).append("\"");
										String sql3 = "select id, parentId, text, number, leaf, href from navigate where parentId="+map2.get("id");
										list2 = new ArrayList();
										list2 = jt.queryForList(sql3);
										if(list2 != null && list2.size()>0){
											sb.append(",");
											sb.append("children:");
											sb.append("[");
											for(int l=0;l<list2.size();l++){
												Map map3 = (Map)list2.get(l);
												sb.append("{");
												sb.append("id:").append("\"").append(map3.get("id")).append("\",");
												sb.append("text:").append("\"").append(map3.get("text")).append("\",");
												sb.append("href:").append("\"").append(map3.get("href")).append("\"");
												String sql4 = "select id, parentId, text, number, leaf, href from navigate where parentId="+map3.get("id");
												list3 = new ArrayList();
												list3 = jt.queryForList(sql4);
												if(list3 != null && list3.size()>0){
													sb.append(",");
													sb.append("children:");
													sb.append("[");
													for(int m=0;m<list3.size();m++){
														Map map4 = (Map)list3.get(l);
														sb.append("{");
														sb.append("id:").append("\"").append(map4.get("id")).append("\",");
														sb.append("text:").append("\"").append(map4.get("text")).append("\",");
														sb.append("href:").append("\"").append(map4.get("href")).append("\"");
														sb.append(",");
														sb.append("leaf:true");
														if(m == list3.size()-1)
															sb.append("}");
														else
															sb.append("},");
													}
													sb.append("]");
												}else{
													sb.append(",");
													sb.append("leaf:true");
												}
												
												if(l == list2.size()-1)
													sb.append("}");
												else
													sb.append("},");
											}
											sb.append("]");
										}else{
											sb.append(",");
											sb.append("leaf:true");
										}
										if(k == list1.size()-1)
											sb.append("}");
										else
											sb.append("},");
									}									
									sb.append("]");
								}else{
								sb.append(",");
								sb.append("leaf:true");
								}
								if(j == list.size()-1)
									sb.append("}");
								else
									sb.append("},");
							}
							sb.append("]");
						}else{
							sb.append(",");
							sb.append("leaf:true");
						}
							if(i == results.size()-1)
							sb.append("}");
						else
							sb.append("},");
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex);
		}
		sb.append("]");
		return sb;
	}
	
	public static void setJt(JdbcTemplate jt) {
		TreeUtil.jt = jt;
	}

	public DataSource getDataSource() {
		return jt.getDataSource();
	}
	
	public JdbcTemplate getJt() {
		return jt;
	}

}
