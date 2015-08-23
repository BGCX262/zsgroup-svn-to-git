package com.zswy.group.util;


/**
 * id生成工具类、字符串操作
 * @author zhangpeng
 *
 */
public class IdUtils {

	public IdUtils() {

	}
	/**
	 * 15位数字ID
	 * @return
	 */
	public static String genTradeId() {
		String tradeId = "";
		RandomStrg.setCharset("0-9");
		RandomStrg.setLength("15");
		try {
			RandomStrg.generateRandomObject();
			tradeId = RandomStrg.getRandom();
		} catch (Exception e) {
		}
		return tradeId;
	}

	/**
	 * 生成十位数字ID
	 * @return
	 */
	public static String genNumTradeId() {
		String tradeId = "";
		RandomStrg.setCharset("0-9");
		RandomStrg.setLength("10");
		try {
			RandomStrg.generateRandomObject();
			tradeId = RandomStrg.getRandom();
		} catch (Exception e) {
		}
		return tradeId;
	}

	/**
	 * 生成6位数字ID
	 * @return
	 */
	public static String genSixNumId() {
		String tradeId = "";
		RandomStrg.setCharset("0-9");
		RandomStrg.setLength("6");
		try {
			RandomStrg.generateRandomObject();
			tradeId = RandomStrg.getRandom();
		} catch (Exception e) {
		}
		return tradeId;
	}
	/**
	 * 生成8位字母加数字的ID
	 * @return
	 */
	public static String GenEightTradeId() {
		String tradeId = "";
		RandomStrg.setCharset("a-zA-Z0-9");
		RandomStrg.setLength("8");
		try {
			RandomStrg.generateRandomObject();
			tradeId = RandomStrg.getRandom();
		} catch (Exception e) {
		}
		return tradeId;
	}

}
