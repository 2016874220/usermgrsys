package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.adminDTO;
import cn.edu.lingnan.dto.buyinfoDTO;
import cn.edu.lingnan.dto.goodsDTO;
import cn.edu.lingnan.util.DataAccess;

public class buyinfoDAO
{
	// -------------------------------管理员查看所有购买信息-----------------------------
	public Vector<buyinfoDTO> adminFindAllBuyinfo()
	{
		Vector<buyinfoDTO> v = new Vector<buyinfoDTO>();
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		try
		{
			conn = DataAccess.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from buyinfo where state=1");
			while (rs.next())
			{
				buyinfoDTO b = new buyinfoDTO();
				b.setBid(rs.getString("bid"));
				b.setAid(rs.getString("aid"));
				b.setGid(rs.getString("gid"));
				b.setSumnum(rs.getInt("sumnum"));
				v.add(b);
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
	
	// -------------------------------用户查看购物车-----------------------------
	public Vector<buyinfoDTO> userFindAllBuyinfo(String _aid)
	{
		Vector<buyinfoDTO> v = new Vector<buyinfoDTO>();
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		try
		{
			conn = DataAccess.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from buyinfo where aid='" + _aid
					+ "' and state=1");
			while (rs.next())
			{
				buyinfoDTO b = new buyinfoDTO();
				b.setBid(rs.getString("bid"));
				b.setAid(rs.getString("aid"));
				b.setGid(rs.getString("gid"));
				b.setSumnum(rs.getInt("sumnum"));
				v.add(b);
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
	
	// -----------------------------删除购物车信息(by id)-------------------------
	public boolean userDeleteBuyinfoById(String _id)
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
			String sql1 = "select * from buyinfo where state=1";
			rs = stat.executeQuery(sql1);
			if (rs.next() == false)
			{
				System.out.println("不能重复删除该信息！");
			}
			else
			{
				prep = conn
						.prepareStatement("update buyinfo set state=0 where bid= ?");
				prep.setString(1, _id);
				prep.executeUpdate();
				prep = conn
						.prepareStatement("update buyinfo set sumnum=0 where bid= ?");
				prep.setString(1, _id);
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
	
	// -------------------------------修改某种商品购买数量(by id)---------------------------
	public boolean userUpdateBuyNumById(Integer _bid, Integer _sumnum,
			Integer _gid, Integer _gnum)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		try
		{
			if (_sumnum < 0 || _sumnum == 0)
			{
				System.out.println("购买数量必须大于零！");
				flag = false;
			}
			else
			{
				conn = DataAccess.getConnection();
				stat = conn.createStatement();
				rs = stat.executeQuery("select gid from buyinfo where bid='"
						+ _bid + "'");
				while (rs.next())
				{
					_gid = rs.getInt(1);
				}
				rs = stat.executeQuery("select gnum from goods where gid='"
						+ _gid + "'");
				while (rs.next())
				{
					_gnum = rs.getInt(1);// 再次使用rs，_gnum会覆盖前面的数据_gid，使得结果集rs里面只有一条数据，所以getInt里的数值为1
				}
				if (_sumnum > _gnum)
				{
					System.out.println("库存不足！");
					flag = false;
				}
				else
				{
					prep = conn
							.prepareStatement("update buyinfo set sumnum=? where bid= ?");
					prep.setInt(1, _sumnum);
					prep.setInt(2, _bid);
					prep.executeUpdate();
					flag = true;
				}
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
	
	// ------------------------------加入购物车----------------------------
	public boolean userInsertBuyinfo(String _bid, String _aid, String _gid,
			String _sumnum)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try
		{
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("insert into buyinfo(bid,aid,gid,sumnum) values (?,?,?,?)");
			prep.setString(1, _bid);
			prep.setString(2, _aid);
			prep.setString(3, _gid);
			prep.setString(4, _sumnum);
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
	
	// -------------------------------顾客修改购物车-----------------------------
	public boolean buyerUpdateBuyinfo(buyinfoDTO bdto)
	{
		String bid = bdto.getBid();
		Integer sumnum = bdto.getSumnum();
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try
		{
			conn = DataAccess.getConnection();
			stat = conn.createStatement();
			// 注意分行截取位置
			stat.executeUpdate("update buyinfo set sumnum='" + sumnum
					+ "' where bid='" + bid + "'");
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
	
	// -------------------------------用户通过aid获取自己的购物信息-----------------------------
	public buyinfoDTO getById(String id)
	{
		buyinfoDTO a = new buyinfoDTO();
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		try
		{
			conn = DataAccess.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from buyinfo where aid='" + id
					+ "' and state=1");
			while (rs.next())
			{
				a.setAid(id);
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
		return a;
	}
	
	public Vector<buyinfoDTO> findCartById(String id)
	{
		Vector<buyinfoDTO> v = new Vector<buyinfoDTO>();
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		try
		{
			conn = DataAccess.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from buyinfo where aid='" + id
					+ "' and state=1");
			while (rs.next())
			{
				buyinfoDTO b = new buyinfoDTO();
				b.setBid(rs.getString("bid"));
				b.setAid(rs.getString("aid"));
				b.setGid(rs.getString("gid"));
				b.setSumnum(rs.getInt("sumnum"));
				v.add(b);
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
}
