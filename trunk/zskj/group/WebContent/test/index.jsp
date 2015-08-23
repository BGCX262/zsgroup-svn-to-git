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
<FORM METHOD=POST ACTION="save.jsp">
<INPUT TYPE="text" NAME="title"><BR>
<TEXTAREA NAME="content" ROWS="10" COLS="50"></TEXTAREA><BR>
<INPUT TYPE="submit">
</FORM>


</body>
</html>