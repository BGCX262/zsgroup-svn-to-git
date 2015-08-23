package com.zswy.group.util;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * response工具类
 * 功能：用于弹出提示对话框
 * @author zhangpeng
 *
 */
public class ResponseUtil {

	/**
	 * 
	 * @param response
	 * @param str
	 */
	public static void transportProcess(HttpServletResponse response, String str) {
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (str != "" || str != null) {
				out.print(str);
			}
			out.flush();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception ex) {
			}
		}

	}

	public static boolean transportProcess(HttpServletResponse response,
			boolean flag) {
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(flag);
			out.flush();
			out.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			try {
				out.close();
			} catch (Exception ex) {
			}
		}

	}

	/**
	 * 弹出对话框并且跳转到指定URL
	 * @param response
	 * @param str
	 * @param url
	 * @return
	 */

	public static boolean dialogBox(HttpServletResponse response, String str,
			String url) {
		PrintWriter out = null;
		try {
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			out.print("<script>alert('" + str + "')</script>");
			out.print("<script>window.location.href='" + url + "'</script>");
			out.flush();
			out.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			try {
				out.close();
			} catch (Exception ex) {
			}
		}
	}
	
	/**
	 * 弹出对话框并且跳转到指定URL
	 * @param response
	 * @param str
	 * @param url
	 * @return
	 */

	public static boolean openWindow(HttpServletResponse response, String url) {
		PrintWriter out = null;
		try {
			response.setContentType("text/html; charset=GBK");
			out = response.getWriter();
			out.print("<script>window.location.href='" + url + "'</script>");
			out.flush();
			out.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			try {
				out.close();
			} catch (Exception ex) {
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static boolean transportExtTree(HttpServletResponse response, List list) {
		PrintWriter out = null;
		try {
			response.setContentType("text/html; charset=GBK");
			out = response.getWriter();
			StringBuffer str = TreeUtil.getExtTree(list);
			out.print(str);
			out.flush();
			out.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			try {
				out.close();
			} catch (Exception ex) {
			}
		}
	}
	
}
