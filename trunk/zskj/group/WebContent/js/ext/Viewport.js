Ext.BLANK_IMAGE_URL = "/group/js/ext/resources/images/default/s.gif";
Ext.QuickTips.init();
Ext.onReady(function(){
	var top = new Ext.BoxComponent({
		el:"top",
		height:120
	});
	var head = new Ext.Panel({
		region:"north",
		height:123,
	    title:'中石万业科技集团后台管理系统',
		split:true,
		border:true,
		items:[top]
	});
	
	var root = new Ext.tree.AsyncTreeNode({
		text:'菜单根节点',
		id : 'root',
		loader : new Ext.tree.TreeLoader({
			dataUrl:''
		})
	
	});
	
	var root1 = new Ext.tree.TreeNode({
		id:"root1",
		text:"功能菜单",
		icon:'js/image/95.gif',
		expanded:true
	});
	var node = new Ext.tree.TreeNode({
		text:'新闻管理',
		rootVisible:false,
		href:'xw/getAllNews.do'
		
	});
	root1.appendChild(node);
	node.appendChild(new Ext.tree.TreeNode({
		id:"p1",
		text:"新闻资讯[暂未使用]",
		icon:'js/image/form.gif'
	}));
   node.appendChild(new Ext.tree.TreeNode({
   		id:'p2',
   		icon:'js/image/form.gif',
   		text:'新闻管理',
   		href:'xw/getAllNews.do'
   }));
    node.appendChild(new Ext.tree.TreeNode({
   		id:'p3',
   		icon:'js/image/form.gif',
   		text:'精品案例',
   		href:'jp/getAllJpal.do'
   }));
     node.appendChild(new Ext.tree.TreeNode({
   		id:'p4',
   		text:'产品服务',
   		icon:'js/image/form.gif',
   		
   		href:'cp/getByCp.do'
   }));
   

	var node3 = new Ext.tree.TreeNode({
		text:'中策划',
		
		rootVisible:false
		
	});
	node3.appendChild(new Ext.tree.TreeNode({
		id:"p21",
		text:"中策划形象片管理",
		icon:'js/image/form.gif',
		href:"/zskj/zch/getAllZch.do"
	}));
	node3.appendChild(new Ext.tree.TreeNode({
		id:"p22",
		text:"中策划视频管理",
		icon:'js/image/form.gif',
		href:"/zskj/sp/getAllLbSp.do"
	}));
	node3.appendChild(new Ext.tree.TreeNode({
		id:"p23",
		text:"中策划宣传册管理",
		icon:'js/image/form.gif',
		href:"/zskj/xcc/getAllXcc.do"
	}));
		node3.appendChild(new Ext.tree.TreeNode({
		id:"p24",
		text:"关于中策划",
		icon:'js/image/form.gif',
		href:"/zskj/zch/getAboutZch.do"
	}));
	root1.appendChild(node3);
	
	var node4 = new Ext.tree.TreeNode({
		text:'关于中石',		
		rootVisible:false	
	});

	node4.appendChild(new Ext.tree.TreeNode({
		id:"p25",
		text:"关于我们",
		icon:'js/image/form.gif',
		href:"/zskj/gyzs/zzGyzs.do"
		
	}));
	root1.appendChild(node4);
	
	  var node2 = new Ext.tree.TreeNode({
   		text:'系统维护',
   		icon:'js/image/113.gif'
   });
   
    root1.appendChild(node2);
	node2.appendChild(new Ext.tree.TreeNode({
		id:"p10",
		icon:'js/image/252.gif',
		text:"产品字典维护",
		expandable:true,
		href:"/zskj/newstype/selectAllNewsTypeOne.do"
	}));
	node2.appendChild(new Ext.tree.TreeNode({
		id:"p11",
		icon:'js/image/252.gif',
		text:"新闻字典维护",
		href:"/zskj/fl/selectAllFl.do"
	}));
	node2.appendChild(new Ext.tree.TreeNode({
		id:"p12",
		icon:'js/image/252.gif',
		text:"形象片字典维护",
		href:"/zskj/xl/selectAllXxpLb.do"
	}));
	node2.appendChild(new Ext.tree.TreeNode({
		id:"p13",
		icon:'js/image/252.gif',
		text:"关于我们字典维护",
		href:"/zskj/aboutfl/selectAllAboutFl.do"
	}));
	node2.appendChild(new Ext.tree.TreeNode({
		id:"p14",
		text:"用户管理",
		icon:'js/image/guardian.gif',
		href:"user/SelectUser.do"
	}));
	
	
	
	var root2 = new Ext.tree.TreeNode({
		id:"root2",
		text:"系统菜单"
	});
	root2.appendChild(new Ext.tree.TreeNode({
		id:"extjs-user",
		text:"数据维护",
		href:"manager/news.jsp"
	}));
	
	var west = new Ext.Panel({
		title:"综合应用导航",
		region:"west",
		width:250,
		collapsible:true,
		layout:"accordion",
		items:[{
			title:"新闻发布",
			iconCls:"icon_title_ppt",
			autoScroll:true,
			items:[new Ext.tree.TreePanel({
				root:root1,
				rootVisible:true,
				border:true,
				listeners:{
					"click":function(node,e){
						e.stopEvent();
						var tab = main.getItem(node.id);
						if(!tab){
							tab = main.add({
								id:node.id,
								iconCls:"icon_ppt",
								xtype:"panel",
								title:node.text,
								closable:true,
								html:"<iframe src='" + node.attributes.href + "' frameborder=0 width=100% height=100%></iframe>"
							});
						}
						main.setActiveTab(tab);
					}
				}
			})]
		},{
			title:"系统管理",
			iconCls:"icon_title_demo",
			items:[new Ext.tree.TreePanel({
				root:root2,
				rootVisible:true,
				border:false,
				listeners:{
					"click":function(node,e){
						e.stopEvent();
						Ext.Ajax.request({
							url:"userMgr.js",
							success:function(response,options){
								eval(response.responseText);
							}
						});
					}
				}
			})]
		}]
	});
	var main = new Ext.TabPanel({
		region:"center",
		activeItem:0,
		enableTabScroll:true,
		items:[{
			xtype:"panel",
			title:"默认首页",
			iconCls:"icon_home",
			html:"这是默认首页的内容"
		}]
	});
	
		var vp = new Ext.Viewport({
		layout:'border',  //布局的样式
		items:[head,west,main]
	});
});

