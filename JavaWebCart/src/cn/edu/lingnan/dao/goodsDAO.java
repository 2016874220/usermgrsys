package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import cn.edu.lingnan.dto.goodsDTO;
import cn.edu.lingnan.util.DataAccess;

public class goodsDAO
{
	//-------------------------------管理员添加商品-----------------------------
	public boolean insertGoods(String _gid,String _gname,String _price,String _gnum)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		try
		{
			conn = DataAccess.getConnection();
			stat=conn.createStatement();	//先不考虑不同商家同商品名的情况
		    rs=stat.executeQuery("select gname from goods where gname='"+_gname+"' and state=1");
		    if(rs.next())
		    {
				System.out.println("该商品已存在！");
		    }
		    else
		    {
		    	prep = conn.prepareStatement
						("insert into goods(gid,gname,price,gnum) values (?,?,?,?)");
		    	prep.setString(1, _gid);
		    	prep.setString(2, _gname);
		        prep.setString(3, _price);
		        prep.setString(4, _gnum);
		        prep.executeUpdate();
		        flag = true;
		    }	
		}
		catch (SQLException e)
		{
			System.out.println("运行SQL语句时出现错误！");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
					rs = null;
				}
				if (prep != null)
				{
					prep.close();
					prep = null;
				}
				if (conn != null)
				{
					conn.close();
					conn = null;
				}
			}
			catch (SQLException e)
			{
				System.out.println("关闭连接、语句及结果集时出现错误！");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	//-----------------------------管理员删除商品(by id)------------------------
	public boolean deleteGoods(String _id)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		try
		{
			conn = DataAccess.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from buyinfo where gid='"+_id+"' and state=1");
			while(rs.next())
			{
				stat.execute("update buyinfo set state=0 where gid='"+_id+"'");
			}			
			stat.execute("update goods set state=0 where gid= '"+_id+"'");
			stat.execute("update goods set gnum=0 where gid= '"+_id+"'");	//商品已删除，则商品数量也改为0
	        flag = true;
		}
		catch (SQLException e)
		{
			System.out.println("运行SQL语句时出现错误！");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
					rs = null;
				}
				if (prep != null)
				{
					prep.close();
					prep = null;
				}
				if (conn != null)
				{
					conn.close();
					conn = null;
				}
			}
			catch (SQLException e)
			{
				System.out.println("关闭连接、语句及结果集时出现错误！");
				e.printStackTrace();
			}
		}
		return flag;
	}	
	
	//-------------------------------修改商品价格(by id)--------------------------------
	public boolean updateGoods(String _id,String _price)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try
		{
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("update goods set price=? where gid= ? and state=1");	//state=1：已被删除的商品不能修改价格
	        prep.setString(1, _price);
	        prep.setString(2, _id);
	        prep.executeUpdate();
	        flag = true;
		}
		catch (SQLException e)
		{
			System.out.println("运行SQL语句时出现错误！");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
					rs = null;
				}
				if (prep != null)
				{
					prep.close();
					prep = null;
				}
				if (conn != null)
				{
					conn.close();
					conn = null;
				}
			}
			catch (SQLException e)
			{
				System.out.println("关闭连接、语句及结果集时出现错误！");
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	//-------------------------------管理员查看商品信息-----------------------------
	public Vector<goodsDTO> adminFindAllGoods()
	{
		Vector<goodsDTO> v = new Vector<goodsDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat=null;
		ResultSet rs=null;
		try 
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
		    rs=stat.executeQuery("select * from goods where state=1");
		    while (rs.next())
			{
				goodsDTO g = new goodsDTO();
				g.setGid(rs.getString("gid"));
				g.setGname(rs.getString("gname"));
				g.setPrice(rs.getString("price"));
				g.setGnum(rs.getString("gnum"));
				v.add(g);
			}
		}
		catch (SQLException e)
		{
			System.out.println("运行SQL语句时出现错误！");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
					rs = null;
				}
				if (prep != null)
				{
					prep.close();
					prep = null;
				}
				if (conn != null)
				{
					conn.close();
					conn = null;
				}
			}
			catch (SQLException e)
			{
				System.out.println("关闭连接、语句及结果集时出现错误！");
				e.printStackTrace();
			}
		}
		return v;
	}
	
	//-------------------------------用户查看商品信息-----------------------------
	public Vector<goodsDTO> userFindAllGoods()
	{
		Vector<goodsDTO> v = new Vector<goodsDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat=null;
		ResultSet rs=null;
		try 
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
		    rs=stat.executeQuery("select * from goods where state=1 and gnum!=0");
		    while (rs.next())
			{
				goodsDTO g = new goodsDTO();
				g.setGid(rs.getString("gid"));
				g.setGname(rs.getString("gname"));
				g.setPrice(rs.getString("price"));
				g.setGnum(rs.getString("gnum"));
				v.add(g);
			}
		}
		catch (SQLException e)
		{
			System.out.println("运行SQL语句时出现错误！");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
					rs = null;
				}
				if (prep != null)
				{
					prep.close();
					prep = null;
				}
				if (conn != null)
				{
					conn.close();
					conn = null;
				}
			}
			catch (SQLException e)
			{
				System.out.println("关闭连接、语句及结果集时出现错误！");
				e.printStackTrace();
			}
		}
		return v;
	}
	
	//-------------------------商家修改商品信息--------------------------
	public boolean adminUpdateGoods(goodsDTO gdto)
	{
		String gid = gdto.getGid();
		String gname = gdto.getGname();
		String price = gdto.getPrice();
		String gnum = gdto.getGnum();
		boolean flag = false;
		Connection conn = null;
		Statement stat=null;
		ResultSet rs=null;
		try
		{
			conn = DataAccess.getConnection();
			stat=conn.createStatement();
			//注意分行截取位置
		    stat.executeUpdate
	    			("update goods set gname='"+gname+"',price='"
		    +price+"',gnum='"+gnum+"' where gid='"+gid+"'");
		    flag = true;
		}
		catch (SQLException e)
		{
			System.out.println("运行SQL语句时出现错误！");
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
					rs = null;
				}
				if (conn != null)
				{
					conn.close();
					conn = null;
				}
			}
			catch (SQLException e)
			{
				System.out.println("关闭连接、语句及结果集时出现错误！");
				e.printStackTrace();
			}
		}
		return flag;
	}
}
