package com.zswy.group.util.test;

import java.util.ArrayList;
import java.util.List;

import com.zswy.group.util.ExtHelper;

public class XstreamListTest {

	/**
	 * ExtHelper工具类测试
	 * 
	 * @author zhangpeng
	 * @date 2010.04.11
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneNumer homePhone = new PhoneNumer("宅电", "123456");
		PhoneNumer officePhone = new PhoneNumer("办公电话", "15801073989");
		List phoneList = new ArrayList();
		phoneList.add(homePhone);
		phoneList.add(officePhone);
		String xml = ExtHelper.getXmlFormList(phoneList.size(), phoneList);
		System.out.println(xml);

		/**
		 * xml数据格式
		 * <?xml version="1.0" encoding="UTF-8" ?> <list> <ExtTotal>
		 * <results>2</results> </ExtTotal> <PhoneNumer> <type>宅电</type>
		 * <number>123456</number> </PhoneNumer> <PhoneNumer> <type>办公电话</type>
		 * <number>15801073989</number> </PhoneNumer> </list>
		 */

	}
}
