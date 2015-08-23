window.onload=function()
{
for(var ii=0; ii<document.links.length; ii++)
document.links[ii].onfocus=function(){this.blur()}
}


function setTab(m,n){
 var tli=document.getElementById("menu"+m).getElementsByTagName("li");
 var mli=document.getElementById("main"+m).getElementsByTagName("div");
 for(i=0;i<tli.length;i++){
  tli[i].className=i==n?"hover":"";
  mli[i].style.display=i==n?"block":"none";
 }
}


var YAO = function(){
	var A = '[object Array]', D = document, IE = navigator.userAgent.match(/MSIE\s([^;]*)/), nt = "nodeType", OP = Object.prototype;
	
	return {
		isArray: function(s){
		   return OP.toString.apply(s) === A;
	    }, 
		isString: function(s){
		   return typeof s === 'string';
	    },
		stopEvent: function(evt){
			this.stopPropagation(evt);
			this.preventDefault(evt);
		},
		stopPropagation: function(evt){
			if (evt.stopPropagation) {
				evt.stopPropagation();
			}
			else {
				evt.cancelBubble = true;
			}
		},
		preventDefault: function(evt){
			if (evt.preventDefault) {
				evt.preventDefault();
			}
			else {
				evt.returnValue = false;
			}
		},
		get: function(elem){
			var elemID, E, m, i, k, length, len;
			if (elem) {
				if (elem[nt] || elem.item) {
					return elem;
				}
				if (YAO.isString(elem)) {
					elemID = elem;
					elem = D.getElementById(elem);
					if (elem && elem.id === elemID) {
						return elem;
					}
					else {
						if (elem && elem.all) {
							elem = null;
							E = D.all[elemID];
							for (i = 0, len = E.length; i < len; i += 1) {
								if (E[i].id === elemID) {
									return E[i];
								}
							}
						}
					}
					return elem;
				}
				else {
					if (elem.DOM_EVENTS) {
						elem = elem.get("element");
					}
					else {
						if (YAO.isArray(elem)) {
							m = [];
							for (k = 0, length = elem.length; k < length; k += 1) {
								m[m.length] = YAO.get(elem[k]);
							}
							return m;
						}
					}
				}
			}
			return null;
		},
		hasClass: function(elem, className){
			var has = new RegExp("(?:^|\\s+)" + className + "(?:\\s+|$)");
			return has.test(elem.className);
		},
		addClass: function(elem, className){
			if (this.hasClass(elem, className)) {
				return;
			}
			elem.className = [elem.className, className].join(" ");
		},
		removeClass: function(elem, className){
			var replace = new RegExp("(?:^|\\s+)" + className + "(?:\\s+|$)", "g");
			if (!this.hasClass(elem, className)) {
				return;
			}
			var o = elem.className;
			elem.className = o.replace(replace, " ");
			if (this.hasClass(elem, className)) {
				this.removeClass(elem, className);
			}
		},
		replaceClass: function(m, k, j){
			if (k === j) {
				return false;
			}
			var l = new RegExp("(?:^|\\s+)" + k + "(?:\\s+|$)", "g");
			if (!this.hasClass(m, k)) {
				this.addClass(m, j);
				return;
			}
			m.className = m.className.replace(l, " " + j + " ");
			if (this.hasClass(m, k)) {
				this.replaceClass(m, k, j);
			}
		},
		getByClassName: function(className, tag, rootTag){
			var elems = [], i, tempCnt = D.getElementById(rootTag).getElementsByTagName(tag), len = tempCnt.length;
			for (i = 0; i < len; i++) {
				if (YAO.hasClass(tempCnt[i], className)) {
					elems.push(tempCnt[i]);
				}
			}
			if (elems.length < 1) {
				return false;
			}
			else {
				return elems;
			}
		},
		setOpacity: function(el, val){
			if (IE) {
				if (YAO.isString(el.style.filter)) {
					el.style.filter = 'alpha(opacity=' + val * 100 + ')';
					if (!el.currentStyle || !el.currentStyle.hasLayout) {
						el.style.zoom = 1;
					}
				}
			}
			else {
				el.style['opacity'] = val;
			}
		},
		YTabs: function(){
			var j, len = arguments.length, sigleTab = [];
			for (j = 0; j < len; ++j) {
				sigleTab[j] = new YAO.simpleTab(arguments[j]);
			}
		},
		fadeUp: function(elem){
			if (elem) {
				var level = 0, fade = function(){
					var timer = null;
					level += 0.05;
					if (timer) {
						clearTimeout(timer);
						timer = null;
					}
					if (level > 1) {
						YAO.setOpacity(elem, 1);
						return false;
					}
					else {
						YAO.setOpacity(elem, level);
					}
					timer = setTimeout(fade, 50);
				};
				fade();
			}
		},
		zebra: function(){
			var j,length = arguments.length;
			for (j = 0; j < length;  ++j) {
				(function(config){
					var root = YAO.get(config.rootTag) || (config.root || null),rows = root.getElementsByTagName(config.rowTag) || (config.rows || null), i, len = rows.length, lastClass = '';
					if (root && rows && len > 1) {
						for (var i = 0; i < len; ++i) {
							rows[i].className = i % 2 == 0 ? 'even' : 'odd';
							rows[i].onmouseover = function(){
								lastClass = this.className;
								YAO.replaceClass(this,lastClass,'hover');
							};
							rows[i].onmouseout = function(){
								YAO.replaceClass(this,'hover',lastClass);
							};
						}
					}
					else{
						return false;
					}
				})(arguments[j]);
			}
		},
		moveElement: function(element, finalX, finalY, speed){
			var elem = (typeof element === 'string') ? YAO.get(element) : element, style = null;
			if (elem) {
				var move = function(){
					var timer = null, dist = 0;
					style = elem.style;
					if (timer) {
						clearTimeout(timer);
						timer = null;
					}
					if (!style.left) {
						style.left = '0';
					}
					if (!style.top) {
						style.top = '0';
					}
					var xpos = parseInt(style.left, 10);
					var ypos = parseInt(style.top, 10);
					if (xpos == finalX && ypos == finalY) {
						return true;
					}
					if (xpos < finalX) {
						dist = Math.ceil((finalX - xpos) / 10);
						xpos = xpos + dist;
					}
					if (xpos > finalX) {
						dist = Math.ceil((xpos - finalX) / 10);
						xpos = xpos - dist;
					}
					if (ypos < finalY) {
						dist = Math.ceil((finalY - ypos) / 10);
						ypos = ypos + dist;
					}
					if (ypos > finalY) {
						dist = Math.ceil((ypos - finalY) / 10);
						ypos = ypos - dist;
					}
					style.left = xpos + 'px';
					style.top = ypos + 'px';
					timer = setTimeout(move, speed);
				};
				move();
			}
		}
	};
}();
YAO.simpleTab = function(oConfigs){
	/* ==================================================================================================================================================================================================================
	 * 初始化配置
	 * ==================================================================================================================================================================================================================
	 * tabCnt：tabs（标签）的父节点 <Object> <可选> 值：oConfigs.tabId - 节点ID、oConfigs.tabRoot - 节点对象、nul - 空值（默认值）
	 * tabs：全部导航tabs <Object> <必须> 值：oConfigs.cTag - （通过获得getElementsByTagName获取tabCnt下的所有）标签的tagName、oConfigs.tabs - 所有标签节点对象、nul - 空值（默认值）
	 * contents：全部需要显示的（内容）节点 <Object> <必须> 值：oConfigs.cTag - （通过获得getElementsByTagName获取tabCnt下的所有）内容的tagName、oConfigs.contents - 全部需要显示的（内容）节点对象、null - 空值（默认值）
	 * length：标签和显示内容的长度（目前只能处理相同数量的，因为主要功能是针对tab导航显示，而不是导航菜单）<Number> <可选> 值：tabs.length - 所有标签对象的长度、0 - 默认没有（如果设置tabs错误时启动）
	 * defaultIndex：默认显示的标签和内容的索引 <Number> <可选> 值：oConfigs.defaultIndex - 索引值、0 - 默认为显示第一项
	 * lastIndex：当前显示的项的索引值 <Number> <可选> 值：默认为初始项索引值
	 * lastTab：上一个选中的标签节点 <Object> <可选> 值：this.tabs[this.lastIndex]、null - 默认没有（如果设置tabs错误时启动）
	 * lastContent：上一个显示的内容节点 <Object> <可选> 值：this.contents[this.lastIndex]、null - 默认没有（如果设置contents错误时启动）
	 * evtName：标签的出发事件 <String> <可选> 值：oConfigs.evt - 一般为click、mouseover - 默认值
	 * defaultClass：默认标签项的className <String> <可选> 值：oConfigs.defaultClass - className、current - 默认className
	 * previousClass：当前标签前一个标签的显示样式（针对类似YAHOO标签设置） <String> <可选> 值：oConfigs.previousClass、默认为空
	 * hideAll：隐藏全部（当用于菜单显示需要设置） <Boolean> <可选> 值：oConfigs.hideAll（true）、false（默认值）
	 * auto：是否自动切换 <Boolean> <可选> 值：oConfigs.auto（一般为true）、false - 默认值，默认是不自动切换的
	 * speed：自动切换时间间隔 <Number> <可选> 值：oConfigs.speed、6000 - 默认值，默认6秒切换一次
	 * fadeUp：自动切换是否渐显 <Boolean> <可选> 值：oConfigs.fadeUp、false - 默认值，默认没有渐变过度效果
	 * =============================================================================================================================================================================================================== */
	this.tabCnt = (oConfigs.tabId) ? YAO.get(oConfigs.tabId) : (oConfigs.tabRoot || null);
	this.tabs = (oConfigs.tTag) ? this.tabCnt.getElementsByTagName(oConfigs.tTag) : (oConfigs.tabs || null);
	this.contents = (oConfigs.cTag) ? this.tabCnt.getElementsByTagName(oConfigs.cTag) : (oConfigs.contents || null);
	this.length = this.tabs.length || 0;
	this.defaultIndex = oConfigs.defaultIndex || 0;
	this.lastIndex = this.defaultIndex;
	this.lastTab = this.tabs[this.lastIndex] || null;
	this.lastContent = this.contents[this.lastIndex] || null;
	this.evtName = oConfigs.evt || 'mouseover';
	this.defaultClass = oConfigs.defaultClass || 'current';
	this.previousClass = oConfigs.previousClass || '';
	this.hideAll = oConfigs.hideAll || false;
	this.auto = oConfigs.auto || false;
	this.isPause = false;
	this.speed = oConfigs.speed || 6000;
	this.fadeUp = oConfigs.fadeUp || false;
	this.scroll = oConfigs.scroll || false;
	this.scrollId = oConfigs.scrollId || null;
	this.scrollSpeed = oConfigs.scrollSpeed || 5;
	/*
	 * 根据配置，执行各项功能
	 */
	var i, that = this;
	if (this.auto) {
		this.timer = setTimeout(function(){
			that.autoChange();
		}, that.speed);
	}
	if (this.tabs && this.contents) {
		if (!this.hideAll) {
			YAO.addClass(this.lastTab, this.defaultClass);
			this.lastContent.style.display = 'block';
		}
		else {
			YAO.removeClass(this.lastTab, this.defaultClass);
			if (!this.scroll) {
				this.lastContent.style.display = 'none';
			}
		}
		for (i = 0; i < this.length; ++i) {
			if (i !== this.defaultIndex && !this.scroll) {
				YAO.removeClass(this.tabs[i], 'current');
				this.contents[i].style.display = 'none';
			}
			this.tabs[i]['on' + this.evtName] = function(index){
				return function(event){
					var evt = null, currentContent = that.contents[index], currentTab = this;
					that.setCurrent.call(that, this, currentContent, index);
					that.lastIndex = index;
					if (that.auto) {
						that.isPause = true;
					}
					evt = event || window.event;
					YAO.stopEvent(evt);
				}
			}(i);
			this.tabs[i]['onmouseout'] = function(index){
				return function(){
					if (that.hideAll && that.evtName === 'mouseover') {
						if (that.lastTab === this) {
							YAO.removeClass(this, (YAO.hasClass(this, that.defaultClass) ? that.defaultClass : 'current'));
						}
						if (that.previousClassTab) {
							YAO.removeClass(that.previousClassTab, that.previousClass);
						}
						if (!that.scroll) {
							that.contents[index].style.display = 'none';
						}
					}
					else {
						if (that.auto) {
							that.isPause = false;
						}
					}
				}
			}(i);
		}
	}
};
/*
 * 初始化设置
 * timer：制动切换的定时器
 * isPause：是否暂停切换
 */
YAO.simpleTab.prototype.timer = null;
YAO.simpleTab.prototype.isPause = false;
YAO.simpleTab.prototype = {
	/*
	 * 自动切换
	 */
	autoChange: function(){
		var that = this;
		if (!this.isPause) {
			var currentContent = null, currentTab = null;
			if (this.timer) {
				clearTimeout(this.timer);
				this.timer = null;
			}
			this.lastIndex = this.lastIndex + 1;
			if (this.lastIndex === this.length) {
				this.lastIndex = 0;
			}
			currentContent = this.contents[this.lastIndex];
			currentTab = this.tabs[this.lastIndex];
			this.setCurrent(currentTab, currentContent, this.lastIndex);
			this.timer = setTimeout(function(){
				that.autoChange();
			}, this.speed);
		}
		else {
			this.timer = setTimeout(function(){
				that.autoChange()
			}, this.speed);
			return false;
		}
	},
	/*
	 * 设置当前标签样式和当前显示内容
	 */
	setCurrent: function(curTab, curCnt, index){
		var currentImage = null, itemHeight = 0, scrollHeight = 0;;
		YAO.removeClass(this.lastTab, (YAO.hasClass(this.lastTab, this.defaultClass) ? this.defaultClass : 'current'));
		if (curTab === this.tabs[this.defaultIndex]) {
			YAO.addClass(curTab, this.defaultClass);
		}
		else {
			YAO.addClass(curTab, 'current');
		}
		if (this.previousClass) {
			if (this.previousClassTab) {
				YAO.removeClass(this.previousClassTab, this.previousClass);
			}
			if (index !== 0) {
				YAO.addClass(this.tabs[index - 1], this.previousClass);
				if ((index - 1) === this.defaultIndex) {
					YAO.removeClass(this.tabs[index - 1], this.defaultClass);
				}
				this.previousClassTab = (this.tabs[index - 1]);
			}
		}
		if (!this.scroll) {
			this.lastContent.style.display = "none";
			curCnt.style.display = "block";
		}
		currentImage = (curCnt.tagName.toUpperCase() === 'IMG') ? curCnt : curCnt.getElementsByTagName('img')[0];
		if (this.fadeUp) {
			if (this.lastContent !== curCnt) {
				YAO.fadeUp(currentImage);
			}
		}
		else {
			if (this.scroll) {
				itemHeight = currentImage.offsetHeight;
				scrollHeight = -(index * itemHeight);
				YAO.moveElement(this.scrollId, 0, scrollHeight, this.scrollSpeed);
			}
		}
		this.lastContent = curCnt;
		this.lastTab = curTab;
	}
};	



function showList(div_id) 
		{
		 var obj = document.getElementById(div_id + "_ljf");
		 var click_obj = document.getElementById(div_id);
		 var text = click_obj.innerHTML;
		 if(obj.style.display == "none") 
		 {
		  var str = div_id.substring(0,div_id.length - parseInt(getNumberLen(div_id)));
		  var num = div_id.replace(str,"");
		  for(i=1;;i++)
		  {
		   if(!document.getElementById(str+i)) break;
		   document.getElementById(str+i+"_ljf").style.display = "none";
		   var iHtml = document.getElementById(str+i).innerHTML;
		   document.getElementById(str+i).innerHTML = iHtml.replace("images/over.gif","images/start.gif");
		  }
		  
		  obj.style.display = "block";
		  click_obj.innerHTML = text.replace("images/start.gif","images/over.gif");
		 } 
		 else 
		 { 
		  obj.style.display = "none";
		  click_obj.innerHTML = text.replace("images/over.gif","images/start.gif");
		 } 
		}

		function getNumberLen(str)
		{
		 var ljf = null;
		 if (ljf = str.match(/(\d+)[^\d]*$/))
		 {
		  return ljf[1].length;
		 }
		}
		
/*点击显示隐藏层*/
var old=null;
function changemenu(mydiv){
  var obj = document.getElementById(mydiv);
  if (old!=null&&old!=obj)
    old.style.display='none';
  old=obj;
  if (obj.style.display=='none'){
    obj.style.display='block';
  }else{
    obj.style.display='none';
  }
}