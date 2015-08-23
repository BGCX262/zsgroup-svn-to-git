<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*,com.zswy.group.test.buildhtml.*" %>
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
<%
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    if (title == null | content == null) {
        response.sendRedirect("form.jsp");
        return;
    }
    News news = new News();
    news.setTitle(title);
    news.setContent(content);
    String realPathPrefix = application.getRealPath("/");
    Calendar calendar = Calendar.getInstance();
    boolean success = new WriteNews().write(news, realPathPrefix, calendar);
    String message = "";
    if (success) {
        message = "Add the news successfully. Please return.";
    } else {
        message = "Add the news unsuccessfully. Please return.";
    }
%>
    <%=message%><br>
    <a href="form.jsp">return to form.jsp</a><br>
    <a href="show.jsp">go to show.jsp</a><br>


</body>
</html>