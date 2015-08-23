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
<!-- save.jsp://保存数据.为简单起见，这里未对输入数据做任何字符过滤或转化工作。 -->
<%
    Vector vNews = new DoneNews().getAllNews();
    if (vNews != null) {
        for (int i=0; i<vNews.size(); i++) {
            News news = (News) vNews.elementAt(i);
            %>
`           <a href="<%=request.getContextPath()%>/<%=news.getPath()%>"><%=news.getTitle()%></a><br>
            <%
        }   
    }
%>

</body>
</html>