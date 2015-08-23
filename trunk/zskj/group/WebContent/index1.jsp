<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zswy.group.model.Person" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			Person p1 = new Person(0,"FM",29,"男","1979-09-13","山东");
			Person p2 = new Person(1,"MU",28,"女","1980-10-11","广东");
			List list = new ArrayList();
			list.add(p1);
			list.add(p2);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Keywords" content="" />
		<meta name="Description" content="" />
		<meta name="author" content="" />
		<title></title>
		
	</head>

	<body>
	<%
		String fm="",mu="",ca="",cz="";
		for(int i=0;i<list.size();i++){
			Person p3 = (Person)list.get(i);
			
			if(p3.getName().equals("FM")){
				 fm = p3.getName();
				out.println("上海航空");
			}else if(p3.getName().equals("MU")){
				 mu = p3.getName();
				out.println("东方航空");
			}
			
		}
		if(fm.equals("")){
			out.println("fm");
		}
		if(mu.equals("")){
			out.println("mu");
		}
		if(ca.equals("")){
			out.println("ca");
		}
		if(cz.equals("")){
			out.println("cz");
		}
	%>
	</body>
</html>