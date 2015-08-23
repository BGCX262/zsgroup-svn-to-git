package com.zswy.group.buildhtml;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.*;
//import com.saas.sys.log.Logger;
import java.util.HashMap;
import java.io.*;
import java.net.*;

public class Config
{
	//Logger log;
	ArrayList config_cont;
	public  Config()
	{	
	    config_cont = new ArrayList();	 
		//log= new Logger(this);	
	}
	public void init()
	{
		String basepath=Thread.currentThread().getContextClassLoader().getResource("").toString();
		String fieldspath=basepath.substring(5,basepath.length()) + "login.properties";
		try
		{
			FileReader ffield=new FileReader(fieldspath);
			BufferedReader fieldbuff=new BufferedReader(ffield);	
			String fieldline=fieldbuff.readLine();
			
			while(fieldline!=null)
			{
				if (!fieldline.trim().equalsIgnoreCase(""))
				{
					if (!fieldline.substring(0,1).equalsIgnoreCase("#"))
					{
						String[] fieldlinestr = fieldline.split("=");
						HashMap map = new HashMap();
						map.put("name", fieldlinestr[0].toUpperCase());
						map.put("value", fieldlinestr[1]);
						this.config_cont.add(map);
					}
				}
				fieldline=fieldbuff.readLine(); 			 
			}
			
			fieldbuff.close();
			ffield.close();	
			}
		catch (IOException e) 
		{
			throw new RuntimeException("[init]��ȡ�����ļ����!"+fieldspath);
		}

	}
	
	public String getLogPath(){
		String basepath=Thread.currentThread().getContextClassLoader().getResource("").toString();
		String fieldspath=basepath.substring(5,basepath.length()) + "login.properties";
		return fieldspath;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList getLogProperties(){
		String basepath=Thread.currentThread().getContextClassLoader().getResource("").toString();
		String fieldspath=basepath.substring(5,basepath.length()) + "login.properties";
		try
		{
			FileReader ffield=new FileReader(fieldspath);
			BufferedReader fieldbuff=new BufferedReader(ffield);	
			String fieldline=fieldbuff.readLine();
			
			while(fieldline!=null)
			{
				if (!fieldline.trim().equalsIgnoreCase(""))
				{
					HashMap map = new HashMap();
					if (!fieldline.substring(0,1).equalsIgnoreCase("#"))
					{
						String[] fieldlinestr = fieldline.split("=");
						map.put("name", fieldlinestr[0]);
						map.put("value", fieldlinestr[1]);
					}
					if (fieldline.substring(0,1).equalsIgnoreCase("#"))
					{
						String[] fieldlinestr = fieldline.split("#");
						map.put("help", fieldlinestr[1]);
					}
					this.config_cont.add(map);
				}
				fieldline=fieldbuff.readLine(); 			 
			}
			
			fieldbuff.close();
			ffield.close();	
			}
		catch (IOException e) 
		{
			throw new RuntimeException("[init]��ȡ�����ļ����!"+fieldspath);
		}
		return config_cont;
	}
	
	public String getString(String fields)
	{
		
		if (this.config_cont.isEmpty())
		{	System.out.println(fields);
			throw new RuntimeException("");
		}
		String str= "";
		for(Iterator it = this.config_cont.iterator(); it.hasNext();)
		{
			HashMap map =(HashMap)it.next();
			
			if (map.get("name") !=null)
			{
				if (map.get("name").toString().equalsIgnoreCase(fields))
				{					 
                    str = map.get("value").toString();					 
					break;
				}
			}
			if (!it.hasNext())
			{
				return null;
			}
		}		
		return str;
	}
	public int getConfigSize()
	{
		if (this.config_cont.isEmpty())
		{
			throw new RuntimeException("�����ļ�û�г�ʼ��,[getString]����ʧ��!");
		}
		return this.config_cont.size();
	}
   public static final String HTTP="http://soft.xsaas.com";
   
   public void WriteToFile(String str){
   	BufferedWriter bwrite;
	String basepath=Thread.currentThread().getContextClassLoader().getResource("").toString();
	String fieldspath=basepath.substring(5,basepath.length()) + "login.properties";
   	try{
   			bwrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fieldspath)));
   			bwrite.write(str);
   			bwrite.flush();
   			bwrite.close();
   		}catch(Exception e){
   				e.printStackTrace();
   			} 			
   	}
}