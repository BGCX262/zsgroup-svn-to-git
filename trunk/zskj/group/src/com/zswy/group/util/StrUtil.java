package com.zswy.group.util;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 字符串转码工具类
 * @author zhangpeng
 *
 */
public class StrUtil {

	/**
	 * 转UTF-8编码
	 * @param instr
	 * @return
	 */
	public static String strToUtf8(String instr) {
		String outstr = "";
		if (instr == null || instr == "") {
			outstr = "";
		} else {
			try {
				outstr = new String(instr.getBytes("ISO-8859-1"), "utf-8");
			} catch (Exception e) {
				throw new RuntimeException("编码转换错误" + e);
			}
		}
		if (instr == null || instr == "") {
			outstr = "";
		}
		return outstr;
	}

	/**
	 * 转GBK编码
	 * @param instr
	 * @return
	 */
	public static String strToGbk(String instr) {
		String outstr = "";
		if (instr == null || instr == "") {
			outstr = "";
		} else {
			try {
				outstr = new String(instr.getBytes("ISO-8859-1"), "GBK");
			} catch (Exception e) {
				throw new RuntimeException("编码转换错误" + e);
			}
		}
		if (instr == null || instr == "") {
			outstr = "";
		}
		return outstr;
	}

	/**
	 * @param str
	 *            需要显示的字符串
	 * @param len
	 *            需要显示的长度(注意：长度是以byte为单位的，一个汉字是2个byte)
	 * @param symbol
	 *            用于表示省略的信息的字符，如“...”,“>>>”等。 只需要提供一个符号即可 表示占位符
	 * @return 返回处理后的字符串
	 */

	public static String getLimitStr(String str, int bytes, String symbol)
			throws Exception {
		// 1.过滤全角字符
//		str = QBchange(str);
//		System.out.println("2."+str);
		// 2.先判断原始字符串总长度
		byte def_b[] = str.getBytes("GBK");
		if (def_b.length <= bytes) {
			return str;
		}
		// 3.中英文匹配
		Pattern a = Pattern.compile("[\u4e00-\u9fa5]+$");
		String[] split = str.split("");
		int len = 0;
		StringBuilder sb = new StringBuilder();
		for (String s : split) {
			Matcher b = a.matcher(s);
			if (!"".equals(s)) {
				if (b.matches()) {
					// System.out.println(s + " is chinese");
					len += 2;
					if (len <= bytes) {
						if (len <= bytes - 2)
							sb.append(s);
						else {
							for (int i = 0; i < bytes - len; i++)
								sb.append(symbol);
						}
						continue;
					}
				} else {
					// System.out.println(s + " is NOT chinese");
					len += 1;
					if (len <= bytes) {
						if (len <= bytes - 3)
							sb.append(s);
						else {
							for (int i = 0; i < bytes - len; i++)
								sb.append(symbol);
						}
						continue;
					}
				}
			}
			if (len >= bytes) {
				break;
			}
		}
		// System.out.println("len="+len);
		try {
			if (len > bytes) {
				byte b[] = sb.toString().getBytes("GBK");
				// System.out.println("b.lenght="+b.length);
				if (b.length < bytes) {
					for (int i = 0; i < bytes - b.length; i++)
						sb.append(symbol);
				}
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

}
