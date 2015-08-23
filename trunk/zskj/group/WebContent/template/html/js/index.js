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
	 * ��ʼ������
	 * ==================================================================================================================================================================================================================
	 * tabCnt��tabs����ǩ���ĸ��ڵ� <Object> <��ѡ> ֵ��oConfigs.tabId - �ڵ�ID��oConfigs.tabRoot - �ڵ����nul - ��ֵ��Ĭ��ֵ��
	 * tabs��ȫ������tabs <Object> <����> ֵ��oConfigs.cTag - ��ͨ�����getElementsByTagName��ȡtabCnt�µ����У���ǩ��tagName��oConfigs.tabs - ���б�ǩ�ڵ����nul - ��ֵ��Ĭ��ֵ��
	 * contents��ȫ����Ҫ��ʾ�ģ����ݣ��ڵ� <Object> <����> ֵ��oConfigs.cTag - ��ͨ�����getElementsByTagName��ȡtabCnt�µ����У����ݵ�tagName��oConfigs.contents - ȫ����Ҫ��ʾ�ģ����ݣ��ڵ����null - ��ֵ��Ĭ��ֵ��
	 * length����ǩ����ʾ���ݵĳ��ȣ�Ŀǰֻ�ܴ�����ͬ�����ģ���Ϊ��Ҫ���������tab������ʾ�������ǵ����˵���<Number> <��ѡ> ֵ��tabs.length - ���б�ǩ����ĳ��ȡ�0 - Ĭ��û�У��������tabs����ʱ������
	 * defaultIndex��Ĭ����ʾ�ı�ǩ�����ݵ����� <Number> <��ѡ> ֵ��oConfigs.defaultIndex - ����ֵ��0 - Ĭ��Ϊ��ʾ��һ��
	 * lastIndex����ǰ��ʾ���������ֵ <Number> <��ѡ> ֵ��Ĭ��Ϊ��ʼ������ֵ
	 * lastTab����һ��ѡ�еı�ǩ�ڵ� <Object> <��ѡ> ֵ��this.tabs[this.lastIndex]��null - Ĭ��û�У��������tabs����ʱ������
	 * lastContent����һ����ʾ�����ݽڵ� <Object> <��ѡ> ֵ��this.contents[this.lastIndex]��null - Ĭ��û�У��������contents����ʱ������
	 * evtName����ǩ�ĳ����¼� <String> <��ѡ> ֵ��oConfigs.evt - һ��Ϊclick��mouseover - Ĭ��ֵ
	 * defaultClass��Ĭ�ϱ�ǩ���className <String> <��ѡ> ֵ��oConfigs.defaultClass - className��current - Ĭ��className
	 * previousClass����ǰ��ǩǰһ����ǩ����ʾ��ʽ���������YAHOO��ǩ���ã� <String> <��ѡ> ֵ��oConfigs.previousClass��Ĭ��Ϊ��
	 * hideAll������ȫ���������ڲ˵���ʾ��Ҫ���ã� <Boolean> <��ѡ> ֵ��oConfigs.hideAll��true����false��Ĭ��ֵ��
	 * auto���Ƿ��Զ��л� <Boolean> <��ѡ> ֵ��oConfigs.auto��һ��Ϊtrue����false - Ĭ��ֵ��Ĭ���ǲ��Զ��л���
	 * speed���Զ��л�ʱ���� <Number> <��ѡ> ֵ��oConfigs.speed��6000 - Ĭ��ֵ��Ĭ��6���л�һ��
	 * fadeUp���Զ��л��Ƿ��� <Boolean> <��ѡ> ֵ��oConfigs.fadeUp��false - Ĭ��ֵ��Ĭ��û�н������Ч��
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
	 * �������ã�ִ�и����
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
 * ��ʼ������
 * timer���ƶ��л��Ķ�ʱ��
 * isPause���Ƿ���ͣ�л�
 */
YAO.simpleTab.prototype.timer = null;
YAO.simpleTab.prototype.isPause = false;
YAO.simpleTab.prototype = {
	/*
	 * �Զ��л�
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
	 * ���õ�ǰ��ǩ��ʽ�͵�ǰ��ʾ����
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
		
/*�����ʾ���ز�*/
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