package com.zswy.group.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author zhangpeng
 * 
 */
public class Timer {
	private static DateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static DateFormat format2 = new SimpleDateFormat(
	"yyyy-MM-dd");
	public static String dateToStr(Date inDate){
		String str = format.format(inDate);
		return str;
	}
	/**
	 * 24小时后的日期时间
	 * @return
	 */
	public static Date get24LastDate(Date indate) {
		Calendar c = Calendar.getInstance();
		c.setTime(indate);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}
	
	/**
	 * 3天后后的日期时间
	 * @return
	 */
	public static Date getThreeDayLastDate(Date indate) {
		Calendar c = Calendar.getInstance();
		c.setTime(indate);
		c.add(Calendar.DATE, 3);
		return c.getTime();
	}
	

	
	/**
	 * 将String 日期转换成DATE类型 
	 * @param indate
	 * @return
	 */
	public static Date getChangeDate(String indate) {
		Date date = null;
		try {
			date = format.parse(indate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;

	}
	/**
	 * 
	 * @param indate
	 * @return
	 */
	public static Date changeDate(String indate) {
		Date date = null;
		try {
			date = format2.parse(indate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;

	}

	/**
	 * 比较日期时间
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int dateCompareResult(Date startDate, Date endDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		return startDate.compareTo(endDate);

	}

	/**
	 * 生成日期
	 * 
	 * @param tag
	 * @return
	 */
	public static String generateSysdate(String tag) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat tradeTime = null;
		String result = "";
		if (tag.equalsIgnoreCase("1")) {
			tradeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else if (tag.equalsIgnoreCase("2")) {
			tradeTime = new SimpleDateFormat("yyyy-MM-dd");
		}else if(tag.equalsIgnoreCase("3")){
			tradeTime = new SimpleDateFormat("yyyyMMddHHmmss");
		} else {
			tradeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		result = tradeTime.format(cal.getTime());
		return result;
	}

	/**
	 * 返回日期类型日期
	 * 
	 * @param tag
	 * @return
	 * @throws ParseException
	 */
	public static Date getSysDate(String tag) throws ParseException {
		Date date = format.parse(generateSysdate(tag));
		return date;
	}

}
