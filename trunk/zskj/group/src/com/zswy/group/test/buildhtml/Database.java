package com.zswy.group.test.buildhtml;

import java.sql.ResultSet;

public interface Database {
	String DATABASE = "group";
    String USERNAME = "root";
    String PASSWORD = "root";
    String URL_PREFIX = "jdbc:mysql://localhost/" + DATABASE;
    String DRIVER = "org.gjt.mm.mysql.Driver";

    int doUpdate(String sql);
    ResultSet doSelect(String sql);


}
