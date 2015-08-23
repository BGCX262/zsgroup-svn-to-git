package com.zswy.group.test.buildhtml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Administrator
 *
 */
public class TouchDatabase implements Database {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement prepstmt;

	private void init() throws SQLException, ClassNotFoundException {
		stmt = null;
		prepstmt = null;

		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL_PREFIX, USERNAME, PASSWORD);
	}
	
	/**
     * Constructor for Statement.
     *
     */
    public TouchDatabase() {
        try {
            this.init();
            stmt = conn.createStatement();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    
    
    /**
     * Constructor for PreparedStatement.
     * @param sql Pre-compile SQL string.
     */
    public TouchDatabase(String sql) {
        try {
            this.init();
            prepstmt = conn.prepareStatement(sql);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    
	
	@Override
	 public ResultSet doSelect(String sql) {
        // TODO 自动生成方法存根
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


	@Override
	 public int doUpdate(String sql) {
        // TODO 自动生成方法存根
        try {
            return stmt.executeUpdate(sql);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return 0;
        }
    }
	
	 public void setField(int index, String field) {
	        try {
	            prepstmt.setString(index, field);
	        } catch (SQLException sqle) {
	            sqle.printStackTrace();
	        }
	    }

	    public ResultSet doPrepareSelect() {
	        try {
	            return prepstmt.executeQuery();
	        } catch (SQLException sqle) {
	            sqle.printStackTrace();
	            return null;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }




}
