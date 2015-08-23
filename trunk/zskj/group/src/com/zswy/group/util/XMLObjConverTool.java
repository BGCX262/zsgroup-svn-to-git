/**
 * FileName: XMLObjConvertBean.java
 * CDT: 2009-12-16
 * Author: Zhang.ze-xiong
 * Function: TODO
 *
 *  ========================================================================
 *  | DATE                     |Author                        | Desp       |
 *  ------------------------------------------------------------------------
 *  | 2009-12-16                |Zhang.ze-xiong                | Create     |
 *  ========================================================================
 *
 */
package com.zswy.group.util;

import com.thoughtworks.xstream.XStream;

/**
 * @author Zhang.ze-xiong
 * 
 */
public class XMLObjConverTool {
	private static XMLObjConverTool convertTool = null;

	public static XMLObjConverTool getInstance() {
		if (convertTool == null) {
			convertTool = new XMLObjConverTool();
		}
		return convertTool;
	}

	public Object getObjByXMLString(final String xml) {
		return new XStream().fromXML(xml);
	}

	public String getXMlByObj(final Object obj) {
		return new XStream().toXML(obj);
	}
}