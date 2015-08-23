package com.zswy.group.test.buildhtml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
/**
 * WriteNews.java://写数据流到硬盘。并调用DoneNews.addNews()方法。
 * @author zhangpeng
 *
 */
public class WriteNews {
	 private final String MIDDLE_DIR = "";//可自定义衔接目录。
	 private final String FILE_SUFFIX = ".html";//可自定义文件后缀名。
	 
	 public boolean write(News news, String realPathPrefix, Calendar calendar) {
	        int year = calendar.get(Calendar.YEAR);
	        int month = calendar.get(Calendar.MONTH) + 1;
	        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	        String fileName = calendar.getTimeInMillis() + FILE_SUFFIX;
	        String realPath = realPathPrefix + MIDDLE_DIR + year + "\\" + month + "\\" + dayOfMonth + "\\";
	        try {
	            if (!mkDirs(realPath)) {
	             //throw new IOException("make dir('" + realPath + "') unsuccessfully!");
	            }
	            
	            FileOutputStream fos = new FileOutputStream(new File(realPath + fileName));
	            byte[] conBytes = news.getContent().getBytes();
	            //加入模板页
	            
	            fos.write(conBytes);
	            
	            fos.close();
	        } catch (IOException ioe) {
	        	ioe.printStackTrace();
	            return false;
	        }
	        
	        String newsPath = year + "/" + month + "/" + dayOfMonth + "/" + fileName;
	        news.setPath(newsPath);
	        return new DoneNews().addNews(news);
	    }
	 
	 private boolean mkDirs(String realPath) {
	        boolean success = false;
	        File path = new File(realPath);
	     if(!path.exists()) {
	      success = path.mkdirs();
	        }
	        return success;
	    }


}
