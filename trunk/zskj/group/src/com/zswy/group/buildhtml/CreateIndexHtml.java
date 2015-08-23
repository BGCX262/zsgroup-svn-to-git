package com.zswy.group.buildhtml;

import java.util.ArrayList;
import java.util.HashMap;




/**
 * 自动生成HTML 2009-5-26
 * 
 * @author 张朋 
 * 该功能实现数据替换并根据模板自动创建HTML页面, 通过流的方式进行文件的读取，
 * 相当于实现了一个定制功能 自定义标签文件写入模板中
 * 
 */
public class CreateIndexHtml {
	FileAndString FileString = new FileAndString();
//	Logger log = new Logger(this);

	public void buildIndex(String rootspath) throws Exception {
		Config configFile = new Config();// 配置文件读取
		configFile.init();// 配置文件初始化
		String projectpath = configFile.getString("mysqlbase.projectpath");// 部署的工程路径
		String webtitle = configFile.getString("mysqlbase.webtitle");// 页面中的TITLE
		String str = "";
		String strTemp = "";
		String filepath = projectpath + "index.html"; // 生成的页面路径
		System.out.println("生成页面路径..." + filepath);
		String templatePath = rootspath + "index.html";// 模板页面路径
		System.out.println("模板路径。。。" + templatePath);
		String templateStr = FileIO.LoadFile(templatePath);
		String[] tab = { "${top}", "${bottom}", "${webtitle}" };// 添加标签
		str = StrReplace.replace(templateStr, tab[0], FileString.f2s(rootspath
				+ "top.html"));
		str = StrReplace.replace(str, tab[1], FileString.f2s(rootspath
				+ "footer.html"));
		str = StrReplace.replace(str, tab[2], webtitle);
//		log.LOG_INFO("综合资讯开始。。。。");
		/**
		 * 根据news_type取出综合资讯中17条开始
		 */
		String initStr_0 = "<a href=\"${link}\" onFocus=this.blur()  target=\"_blank\"><img src=${mini_img}  width=\"109px\"; alt=\"${title}\" height=\"76px\" /></a>";
		String initStr = "<li><a href=\"${link}\" onFocus=this.blur() class=firstd target=_blank>${title}</a></li>";
		String initStr1 = "<li><a href=\"${link}\" onFocus=this.blur()  target=_blank>${title}</a></li>";
		String initStr2 = "<dd><a href=\"${link}\" onFocus=this.blur()  target=_blank>${title}</a></dd>";
		String strTemp_0 = "";
		String strTemp1 = "";
		String strTemp2 = "";
		FileIO.SaveToFile(str, filepath);
	}
	  // 全角转半角
    public static final String QBchange(String QJstr) {
            String outStr = "";
            String Tstr = "";
            byte[] b = null;

            for (int i = 0; i < QJstr.length(); i++) {
                    try {
                            Tstr = QJstr.substring(i, i + 1);
                            b = Tstr.getBytes("unicode");
                    } catch (java.io.UnsupportedEncodingException e) {
                            e.printStackTrace();
                    }
                    if (b[3] == -1) {
                            b[2] = (byte) (b[2] + 32);
                            b[3] = 0;
                            try {
                                    outStr = outStr + new String(b, "unicode");
                            } catch (java.io.UnsupportedEncodingException e) {
                                    e.printStackTrace();
                            }
                    } else
                            outStr = outStr + Tstr;
            }
            return outStr;
    }
    /**
	 * @param str 需要显示的字符串
	* @param len 需要显示的长度(注意：长度是以byte为单位的，一个汉字是2个byte)
	* @param symbol 用于表示省略的信息的字符，如“...”,“>>>”等。
	* @return 返回处理后的字符串
	*/

	    public static String getLimitString(String str,int len, String symbol) throws Exception {
			if(str==null)
				return "";
		   int counterOfDoubleByte = 0;
		   byte b[]= str.getBytes("GBK");
		   
		   if(b.length <= len)
		     return str;
		   for(int i = 0; i < len; i++){
		     if(b[i] < 0)
		       counterOfDoubleByte++;
		   }
	
		   if(counterOfDoubleByte % 2 == 0)
		     return new String(b, 0, len, "GBK") + symbol;
		   else
		     return new String(b, 0, len - 1, "GBK") + symbol;
		}

}
