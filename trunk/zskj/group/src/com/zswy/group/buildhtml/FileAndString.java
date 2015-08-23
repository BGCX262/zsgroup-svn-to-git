package com.zswy.group.buildhtml;

/**
 *	all Copyright reserver,If you would not get the permittion
 *	you should not COPY,PUBLISH,POST or do other related thing.
 *	or else I will charge on you .
 *
 *	���г����Ȩ��ʯ��(��j���ʺ�HAMMER_SHI)����.
 *	δ����ɲ���תժ��������������
 *	���˱������Ȩ��
 *
 *	@version 1.0
 *	@author shijun
 *	@time 2004-11-25
 *
 */
import java.io.*;

/**
 * �ļ����ַ�ת����
 */
public class FileAndString {
	
	
	
	/**
	 * �ļ�ת�����ַ�
	 */
	public String f2s(String filename) {

		String content = "";
		try {
			
			Reader r = new FileReader(filename);
			java.io.BufferedReader br = new java.io.BufferedReader(r);
			String temp = "";
			while ((temp = br.readLine()) != null) {
				temp = StrReplace.replace(temp, "{#comm:webtitle#}", ProjectConfig.WEBTITLE);
				temp = StrReplace.replace(temp, "{#comm:bottom#}", ProjectConfig.BOTTOM);
				temp = StrReplace.replace(temp, "{#comm:logopath#}", ProjectConfig.LOGOPATH);
				temp = StrReplace.replace(temp, "{#comm:webname#}", ProjectConfig.WEBNAME);
				temp = StrReplace.replace(temp, "{#comm:webadd#}", ProjectConfig.WEBADD);
				temp = StrReplace.replace(temp, "{#comm:webdesc#}", ProjectConfig.WEBDESC);
				// temp = StrReplace.replace(temp,"\"","\\\"");
				temp = temp + "\n";
				content += temp;
			}
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return content;
	}
	
	
	
	/**
	 * �ַ�ת�����ļ�
	 */
	public int s2f(String content, String outputfilename) {

		return s2f(content, outputfilename, -1);
		
	}
	
	
	
	/**
	 * �ַ�ת�����ļ�
	 */
	public int s2f(String content, String outputfilename, int add) {

		int re = 0;
		try {
			
			FileWriter fw = null;
			File f = new File(outputfilename);
			// String t = outputfilename.substring(0,outputfilename.lastIndexOf(File.separator)+1);
			// new File(t).mkdir();
			
			f.getParentFile().mkdir();
			
			if (add > 0)
				fw = new FileWriter(f, true);
			else
				fw = new FileWriter(f, false);
			
			fw.write(content);
			fw.close();
			re = 1;
		}
		catch (Exception e) {
			re = 0;
			System.out.println("s2f error : " + e.getMessage() + " , " + outputfilename);
		}
		return re;
	}
	
	
	
	/**
	 * ���url���ʵõ�webҳ������
	 * 
	 * @param java.net.URL�ַ��ʽ
	 * @return String :ҳ������
	 */
	public String url2string(String surl) {

		try {
			InputStream urlStream = null;
			
			java.net.URL url = new java.net.URL(surl);
			
			java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
			
			connection.connect();
			
			String sCurrentLine;
			
			StringBuffer sTotalString = new StringBuffer(" ");
			
			urlStream = connection.getInputStream();
			
			java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(urlStream));
			while ((sCurrentLine = reader.readLine()) != null) {
				
				sTotalString.append(sCurrentLine);
			}
			
			connection.disconnect();
			urlStream.close();
			return sTotalString.toString();
		}
		catch (Exception e) {
			System.out.println(" get web page error message :" + e.getMessage());
			return " get web page error message :" + e.getMessage();
		}
	}
	
	
	
	/**
	 * ��LinkedList �е����ݰ��д洢���ļ���
	 */
	public void linkedlist2file(java.util.LinkedList ll, String filename, boolean add) {

		StringBuffer sb = new StringBuffer(" ");
		for (int x = 0; x < ll.size(); x++) {
			sb.append((String) ll.get(x) + "\n");
		}
		if (add == true)
			s2f(sb.toString(), filename, 1);
		else {
			s2f(sb.toString(), filename, -1);
		}
		
	}
	
	
	public void linkedlist2file(java.util.LinkedList ll, String filename) {

		linkedlist2file(ll, filename, false);
		
	}
	
	
	
	/**
	 * ���ļ����е���LinkedList��
	 */
	public java.util.LinkedList file2linkedlist(String filename) {

		java.util.LinkedList ll = new java.util.LinkedList();
		try {
			
			Reader r = new FileReader(filename);
			java.io.BufferedReader br = new java.io.BufferedReader(r);
			String temp = "";
			while ((temp = br.readLine()) != null) {
				ll.add(temp);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ll;
	}
	
}