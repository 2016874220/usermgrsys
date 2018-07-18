package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DataAccess
{
	private static String driver=null;//参数不应放在.calss里，应从配置文件当中读取。每次运行系统时，若修改了配置文件，则读到的就是新的参数，代码本身不做修改。
	private static String url=null;
	private static String user=null;
	private static String password=null;
	private static String xmlPath="database.conf.xml";
	private static String xsdPath="database.conf.xsd";
	private static Connection conn=null;
	private static HashMap<String,String>hm=new HashMap<String,String>();
    static
    {
    	if(XmlValidator.validator(xmlPath, xsdPath))
    	{
    		hm=XmlParser.parser(xmlPath);
    		driver=hm.get("driver");
    		url=hm.get("url");
    		user=hm.get("user");
    		password=hm.get("password");
    	}
    }
	
	public static Connection getConnection ()
	{
		try
		{
			//注册驱动程序
			Class.forName(driver);
			//连接数据库
		    conn=DriverManager.getConnection(url,user,password);
		    
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("数据库jar包加载失败..........");
			e.printStackTrace();
		}
		    catch (SQLException e)
		{
		    	System.out.println("数据库连接获取失败.........");
				e.printStackTrace();
		}
//		System.out.println("数据库连接获取成功.....");
		return conn;
	}
	
	public static void closeconn(Connection conn,Statement stat,PreparedStatement prep,ResultSet rs)
	{
		try
		{
			if (rs!=null)
			{
				rs.close();
				rs=null;
			}
			if (prep!= null)
			{
				prep.close();
				prep = null;
			}
			if (conn!= null)
			{
				conn.close();
				conn = null;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}


