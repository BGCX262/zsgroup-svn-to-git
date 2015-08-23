package com.zswy.group.util.test;

import java.util.ArrayList;
import java.util.List;

import com.zswy.group.util.ExtHelper;

import net.sf.json.JSONObject;

public class JSonLibTest {

	/**JSON-LIB工具类测试。生成EXT返回JSON对象
	 * @param args
	 */
	public String getJsonStr(){
		PhoneNumer homePhone = new PhoneNumer("宅电", "123456");
		PhoneNumer officePhone = new PhoneNumer("办公电话", "15801073989");
		Person person = new Person("张朋",1,homePhone,officePhone);
		JSONObject json = JSONObject.fromObject(person);
		String jsonstr = json.toString();
		return jsonstr;
		//{"name":"张朋","age":1,
		// "officePhone":{"number":"15801073989","type":"办公电话"},
		// "homePhone":{"number":"123456","type":"宅电"}}
	}
	
	public String getJsonList(){
		PhoneNumer homePhone = new PhoneNumer("宅电", "123456");
		PhoneNumer officePhone = new PhoneNumer("办公电话", "15801073989");
		List phoneList = new ArrayList();
		phoneList.add(homePhone);
		phoneList.add(officePhone);
		String json = ExtHelper.getJsonFromList(phoneList.size(), phoneList);
		return json;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(new JSonLibTest().getJsonStr());
		System.out.println(new JSonLibTest().getJsonList());

	}

}
