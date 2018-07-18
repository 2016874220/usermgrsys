package com.lingnan.usersys.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lingnan.usersys.common.exception.DaoException;

/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class DBUtils
{
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try{
			//加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String user = "scott";
			String password = "123456";
			//获取数据库连接对象
			conn=DriverManager.getConnection(url,user,password);
		}catch (ClassNotFoundException e)
		{
			//将异常封装成自定义异常
			throw new DaoException("数据库jar包加载失败",e);
			//System.out.println("数据库jar包加载失败......");
			//e.printStackTrace();
		}
		    catch (SQLException e)
		{
		    //将异常封装成自定义异常
			throw new DaoException("数据库连接获取失败",e);
	    	//System.out.println("数据库连接获取失败......");
			//e.printStackTrace();
		}
		//返回得到的连接对象
		return conn;
	}
	
	/**
	 * 开启事务
	 * @param conn
	 */
	public static void beginTransaction(Connection conn){
		try{
			//将事务的自动提交模式设为假
			conn.setAutoCommit(false);
		}catch(SQLException e){
			//将异常封装成自定义异常
			throw new DaoException(e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 提交事务
	 * @param conn
	 */
	public static void commit(Connection conn){
		try{
			//提交事务
			conn.commit();
			//将事务的自动提交模式设为真
			conn.setAutoCommit(true);
		}catch(SQLException e){
			//将异常封装成自定义异常
			throw new DaoException(e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 回滚事务
	 * @param conn
	 */
	public static void rollback(Connection conn){
		try{
			//回滚事务
			conn.rollback();
			//将事务的自动提交模式设为真
			conn.setAutoCommit(true);
		}catch(SQLException e){
			//将异常封装成自定义异常
			throw new DaoException(e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 关闭连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		try{
			//如果数据库连接对象不为空，关闭该对象
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
			//将异常封装成自定义异常
			throw new DaoException(e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 关闭statement
	 * @param rs
	 * @param stmt
	 */
	public static void closeStatement(ResultSet rs,Statement stmt){
		try{
			//如果查询结果集对象不为空，关闭该对象
			if(rs != null){
				rs.close();
			}
			//如果声明对象不为空，关闭该对象
			if(stmt != null){
				stmt.close();
			}
		}catch(SQLException e){
			//将异常封装成自定义异常
			throw new DaoException(e);
			//e.printStackTrace();
		}
	}
}
