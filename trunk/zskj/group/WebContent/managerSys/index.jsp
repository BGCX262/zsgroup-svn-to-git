<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网站后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/ext/resources/css/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/ext/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/ext/ext-all.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/ext/source/locale/ext-lang-zh_CN.js"></script>
       <script type="text/javascript" src="<%=request.getContextPath() %>/js/ext/ext/themeChange.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/Viewport.js"></script>
 
</head>
    
  </head>
  
  <body>
	<div id="top" style="background-image: url('<%=path %>/js/image/head.jpg');">
  		<div style="float:left;background-image:url('images/top-left.gif');width:293px;height:82px;"></div>
  		<div style="float:right;background-image: url('images/top-right.gif');width:731px;height:82px;"></div>
  	</div>
  	
  	<div id="tree-div"></div>  
  	<div id="panel">
  	
  		
  	</div>  
  	</body>
</html>
