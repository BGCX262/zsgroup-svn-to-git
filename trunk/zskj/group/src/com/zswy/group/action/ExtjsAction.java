package com.zswy.group.action;

import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.Action;

import com.zswy.group.model.Person;

public class ExtjsAction extends BaseAction {
	private long results;
	private List items;

	public long getResults() {
		return results;
	}

	public void setResults(long results) {
		this.results = results;
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public String execute() throws Exception{
		this.results = 3;
		Person p1 = new Person(0,"张三",29,"男","1979-09-13","山东");
		Person p2 = new Person(1,"李四",28,"女","1980-10-11","广东");
		Person p3 = new Person(2,"王一",27,"不男不女","1981-01-23","上海");
		Person p4 = new Person(3,"王二",27,"男","1981-01-23","北京");
		Person p5 = new Person(4,"王三",27,"女","1981-01-23","深圳");
		Person p6 = new Person(5,"赵二",27,"男","1981-01-23","广西");
		Person p7 = new Person(6,"赵四",27,"男","1981-01-23","大连");
		this.items = new ArrayList();
		this.items.add(p1);
		this.items.add(p2);
		this.items.add(p3);
		this.items.add(p4);
		this.items.add(p5);
		this.items.add(p6);
		this.items.add(p7);
		return Action.SUCCESS;
	}
}
