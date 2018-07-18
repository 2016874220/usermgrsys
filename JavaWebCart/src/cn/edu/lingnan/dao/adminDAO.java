package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.adminDTO;
import cn.edu.lingnan.dto.buyinfoDTO;
import cn.edu.lingnan.util.DataAccess;

public class adminDAO {
	
	//---------------------------------登录-----------------------------------
	public int login(String _id,String _password)
	{
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat=null;
		ResultSet rs=null;
		int superValue = 0;
		try 
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
		    rs=stat.executeQuery("select * from admin where aid='"+_id+"' and password='"+_password+"' and state=1");
		    if(rs.next())
		    {
				superValue=Integer.parseInt(rs.getString("superuser"));
				System.out.println("-----1-----superValue:"+superValue);
		    }
		}
		    catch (SQLException e) {
		    	System.out.println("运行sql语句时出现错误");
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rs!=null)
						rs.close();
					if(stat!=null)
						rs.close();
					if(conn!=null)
						conn.close(); 
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			}
		return superValue;
	}
	
	//----------------------------区分身份信息----------------------------
	public int DistinguishBetweenAdminAndUser(String _name,String _password,Integer _superuser)
	{
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat=null;
		ResultSet rs=null;
		int superValue=0;
		try 
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
		    rs=stat.executeQuery("select * from admin where aname='"+_name+"' and password='"+_password+"'");
		    if(rs.next())
		    {
				superValue=Integer.parseInt(rs.getString("superuser"));
		    }
		}
		    catch (SQLException e) {
		    	System.out.println("运行sql语句时出现错误");
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rs!=null)
						rs.close();
					if(stat!=null)
						rs.close();
					if(conn!=null)
						conn.close(); 
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			}
		return superValue;
	}	
	
	//---------------------(Ajax)登录时判断这个用户是否存在------------------
	public boolean findUserByName(String _name)
	{
		boolean flag = false;
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat=null;
		ResultSet rs=null;
		try 
		{
			conn=DataAccess.getConnection();
			prep = conn.prepareStatement
					("select * from admin where aname=? and state=1");
			prep.setString(1, _name);
			rs = prep.executeQuery();
		    if(rs.next())
		    {
		    	flag = true;
		    }
		}
		    catch (SQLException e) {
		    	System.out.println("运行sql语句时出现错误");
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rs!=null)
						rs.close();
					if(stat!=null)
						rs.close();
					if(conn!=null)
						conn.close(); 
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			}
		return flag;
	}
	
	
	
	//-------------注册（用户已存在这个判断是在后台执行的，结果也无法返回到页面，只会跳转到ERROR.html，只能用Ajax）-----------
	public boolean insertUser(String _aid,String _name,String _password,String _repassword,Integer _superuser)
	{ 
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		try
		{
			conn = DataAccess.getConnection();
			stat=conn.createStatement();
		    rs=stat.executeQuery("select aid from admin where aid='"+_aid+"' and state=1");
		    if(rs.next())
		    {
				System.out.println("该用户已存在！");
		    }
		    else
		    {
		    	if(_password.equals(_repassword))
		    	{
		    		if(_superuser==1 || _superuser==2)
		    		{
		    			prep = conn.prepareStatement
							("insert into admin(aid,aname,password,superuser) values (?,?,?,?)");
		    		prep.setString(1, _aid);
			        prep.setString(2, _name);
			        prep.setString(3, _password);
			        prep.setInt(4, _superuser);
			        prep.executeUpdate();
			        flag = true;
		    		}
		    		else
		    			System.out.println("身份填写错误！");
		    	}
		    	else
		    		System.out.println("密码输入错误！");
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
	
	//-------------------------------注销用户(by id)--------------------------------
	public boolean deleteUser(String aid)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		try
		{
			conn = DataAccess.getConnection();
			stat=conn.createStatement();
		    rs=stat.executeQuery("select state from admin where aid='"+aid+"'");
		    while(rs.next())
		    {
				Integer state = rs.getInt("state");
				if(state==1)
			    {
			    	prep = conn.prepareStatement
			    			("update admin set state=0 where aid= ?");
			    	prep.setString(1, aid);
			    	prep.executeUpdate();
			    	flag = true;
			    }
				else
				{
					System.out.println("不能重复注销同一个用户！");
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
				
	//-------------------------------用户修改用户名和密码--------------------------------
	public boolean updateUserNameAndPasswd(String _id,String _name,String _newpasswd,String _passwd,String _p,String _makesure)
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
		    rs = stat.executeQuery("select password from admin where aid='"+_id+"'");
		    while(rs.next())
		    {
		    	_p = rs.getString(1);
		    	
		    }
		    if(_p.equals(_passwd))	//不能用_ppasswd==_passwd
		    {
		    	if(_newpasswd.equals(_makesure))
		    	{
		    		stat.executeUpdate
		    				("update admin set aname='"+_name+"' and password='"+_newpasswd+"' where aid='"+_id+"'");
			        flag = true;
		    	}
		    	else
		    		System.out.println("新密码确认错误！");
		    }
		    else
		    {
		    	System.out.println("原密码错误，修改密码失败！");
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
	
	//-------------------------------管理员查看所有用户信息-----------------------------
	public Vector<adminDTO> adminFindAllUser()
	{
		Vector<adminDTO> v = new Vector<adminDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat=null;
		ResultSet rs=null;
		try 
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
		    rs=stat.executeQuery("select * from admin where state=1");
		    while (rs.next())
			{
		    	adminDTO a = new adminDTO();
				a.setAid(rs.getString("aid"));
				a.setAname(rs.getString("aname"));
				a.setPassword(rs.getString("password"));
				a.setSuperuser(rs.getInt("superuser"));
				a.setState(rs.getInt("state"));
				v.add(a);
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
	
	//-------------------------------管理员修改用户信息-----------------------------
	public boolean adminUpdateUser(adminDTO adto)
	{
		String aid = adto.getAid();
		String aname = adto.getAname();
		String password = adto.getPassword();
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
	    			("update admin set aname='"+aname+"',password='"
		    +password+"' where aid='"+aid+"'");
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
	
	//-------------------------------用户通过aid获取自己的个人信息-----------------------------
	public adminDTO getById(String id)
	{
		adminDTO a = new adminDTO();
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat=null;
		ResultSet rs=null;
		try 
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
		    rs=stat.executeQuery
		    		("select * from admin where aid='"+id+"' and state=1");
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
	public Vector<adminDTO> findSelfMessageById(String id)
	{
		Vector<adminDTO> v = new Vector<adminDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat=null;
		ResultSet rs=null;
		try 
		{
			conn=DataAccess.getConnection();
			stat=conn.createStatement();
		    rs=stat.executeQuery
		    		("select * from admin where aid='"+id+"' and state=1");
		    while (rs.next())
			{
		    	adminDTO a = new adminDTO();
				a.setAid(rs.getString("aid"));
				a.setAname(rs.getString("aname"));
				a.setPassword(rs.getString("password"));
				v.add(a);
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
