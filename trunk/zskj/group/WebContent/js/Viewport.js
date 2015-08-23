Ext.BLANK_IMAGE_URL = "/group/js/ext/resources/images/default/s.gif";
Ext.QuickTips.init();
Ext.onReady(function(){
	var top = new Ext.BoxComponent({
		el:"top",
		height:10
	});
	var head = new Ext.Panel({
		region:"north",
		height:53,
	    title:'',
		split:true,
		border:true,
		items:[top]
	});
	
	var root = new Ext.tree.AsyncTreeNode({
		text:'功能菜单',
		id : 'root',
		expanded:true,
		loader : new Ext.tree.TreeLoader({
			dataUrl:'/group/Sys!getTree.shtml'
		})
	
	});
	var west = new Ext.Panel({
		title:"网站后台管理导航菜单",
		region:"west",
		width:250,
		collapsible:true,
		layout:"accordion",
		items:[{
			title:"111",
			iconCls:"icon_title_ppt",
			autoScroll:true,
			items:[new Ext.tree.TreePanel({
				root:root,
				rootVisible:true,
				border:false,
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
		}]
				,
			tbar : [
				'皮肤选择：',
				{
					xtype : 'themeChange',
					width : 80,
					listWidth : 80
				},
				'->'
			]
	});
	var main = new Ext.TabPanel({
		region:"center",
		activeItem:0,
		enableTabScroll:true,
		height:1000,
		width:1000,
	//	applyTo:'panel', //页面中的DIV
	//	autoTabs:true, //自动扫描页面中的DIV。然后将其转换为标签页
	//	activeTab:0, //默认激活第一个TAB页
		items:[{
			xtype:"panel",
			title:"首页",
			iconCls:"icon_home",
			html:"<iframe src='http://www.extjs.com/deploy/dev/docs/' frameborder=0 width=100% height=100%></iframe>",
			closable:false
			
		}]
	});
	
		var vp = new Ext.Viewport({
		layout:'border',  //布局的样式
		items:[head,west,main]
	});
});

