<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
[
	{
		id:'1',
		text:'新闻管理',
		href:'#',
		children:[{
				id:3,
				text:'新闻资讯',
				href:'#',
				children:[{
					id:001,
					text:'资讯管理',
					leaf:true,
					href:'#'
				}]
			},{
				id:4,
				text:'新闻资讯',
				leaf:true,
				href:'#'
			}]
	},
{id:'2',text:'产品管理',leaf:true,icon:'js/image/form.gif',href:'/group/Sys!getTree.shtml'},
{id:'3',text:'基本设置',leaf:true,icon:'js/image/95.gif',href:'#'}]