package com.zswy.group.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 2010.04.11
 * @author zhangpeng
 * EXT与STRUTS整合使用工具类
 * 返回JSON、XML格式 用于 ext grid
 */
public class ExtHelper {
	/**
	 * 通过list生成XML数据
	 * @param recordTotal 记录总数,不一定与beanList中的记录数相等
	 * @param beanList 包含bean对象的list
	 * @return 生成的XML数据
	 */
	@SuppressWarnings("unchecked")
	public static String getXmlFormList(long recordTotal, List beanList){
		ExtTotal extTotal = new ExtTotal();//创建ExtTotal类用于保存记录数
		extTotal.setResults(recordTotal);//设置记录总数到total对象
		List results = new ArrayList();//创建临时的LIST对象results
		results.add(extTotal);//将extTotal对象加入到results中,作为results对象的第一个元素
		results.addAll(beanList);//将beanList追加到results对象中
		XStream sm = new XStream(new DomDriver());//创建xstream对象
		//遍历result对象，将所有的类创建别名，别名为不包含包名的类名
		for(int i = 0 ; i < results.size(); i++){
			Class c = results.get(i).getClass();
			String b = c.getName();
			String[] temp = b.split("\\.");
			sm.alias(temp[temp.length - 1],c);
		}
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"+sm.toXML(results);
		return xml;
		
	}
	
	/**
	 * 通过LIST生成JSON数据。
	 * @param recordTotal 记录总数，不一定与BEANLIST中的记录数相等。
	 * @param beanList 包含BEAN对象的集合，
	 * @return 生成的JSON数据
	 */
	public static String getJsonFromList(long recordTotal, List beanList){
		ExtTotalJson totalJson = new ExtTotalJson();
		totalJson.setResults(recordTotal);
		totalJson.setItems(beanList);
		JSONObject jsonArray = JSONObject.fromObject(totalJson);
		return jsonArray.toString();
	}
	
	
	
}
