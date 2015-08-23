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
		<script type="text/javascript">
				function test(){
					var editor_data = CKEDITOR.instances.content.getData();			
					if(editor_data.length==0){
						alert( "请填写" );
						CKEDITOR.instances.content.focus();
						return false;
					}
					
				}
		</script>
		
		
	</head>
<!-- 
	得到CKEDITOR中的内容
	 var editor_data = CKEDITOR.instances.content.getData();
	
	if(editor_data.length==0){
		alert( "请填写产品的详细说明！" );
		CKEDITOR.instances.content.focus();
		return false;
	}
 -->
	<body>
	<form action="">
	<table width="60%">

		<tr>
			<td>简要</td>
		</tr>
		<tr>
			<td>
				<textarea name="content"></textarea>
				<script type="text/javascript" src="<%=path%>/ckeditor/ckeditor.js"></script>
				<script type="text/javascript">
					CKEDITOR.replace( 'content');
				</script>
				
			</td>
		</tr>
		<tr>
			<td> <input type="submit" value="提交" /></td>
		</tr>
	</table>
	</form>
	</body>
</html>