<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<s:form method="post" name="form1" action="#">
	<table border="1" cellpadding="0" cellspacing="0" bordercolor="#B8CFEE" width="510">
		<tr>
			<td><s:textfield name="newstypeone.lxmc" label="新闻类别名称"></s:textfield></td>
		</tr>
		<tr>
			<td>操作</td>
			<td><input type="button" value="提交" />&nbsp;&nbsp;<input type="button" value="重置" /></td>
			
		</tr>
	</table>
</s:form>
</body>
</html>