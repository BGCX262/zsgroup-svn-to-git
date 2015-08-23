package com.zswy.group.buildhtml;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import java.io.InputStream;
import java.util.Properties;

public class ProjectConfig{

    static private ProjectConfig _config = null;
    static private Config configFile;
    static public ProjectConfig getInstance(){
        configFile= new Config();
        configFile.init();
        if(_config==null)
            _config = new ProjectConfig();
        return _config;
    }

    final public static int ORACLEDB = 1;
    final public static int SQLSVRDB = 2;
    final public static int MYSQLDB = 3;
    final public static String DBTITLE = ProjectConfig.getInstance().getMainDB();
    static public  String WEBTITLE = configFile.getString("mysqlbase.webtitle");
    static public  String BOTTOM = configFile.getString("mysqlbase.bottom");
    static public  String LOGOPATH = configFile.getString("mysqlbase.logopath");
    static public  String WEBNAME = configFile.getString("mysqlbase.webname");
    static public  String WEBADD = configFile.getString("mysqlbase.webadd");
    static public  String WEBDESC = configFile.getString("mysqlbase.webdesc");
    private String MainDB = null;
 
    protected ProjectConfig()
    {
        InputStream is = getClass().getClassLoader().getResourceAsStream("login.properties");
        Properties dbProps = new Properties();
        try 
        {
            dbProps.load(is);
        }
        catch (Exception e) 
        {
            System.err.println("Can't read the properties file. " +
                    "Make sure login.properties is in the CLASSPATH");
            return;
        }
        MainDB = dbProps.getProperty("MainDB", "mysqlbase");
    }
    private String getMainDB() { return MainDB; }
}
