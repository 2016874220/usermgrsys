package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 用户dao接口的实现类
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{
	/**
	 * 数据库连接
	 */
	private Connection conn;
	
	/**
	 * 构造方法
	 * @param conn 数据库连接
	 */
	public UserDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param passwd 密码
	 * @param user 用户信息
	 * @return 用户信息
	 */
	public UserVO login(String name,String passwd)
	{
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		//声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVO user = null;
		try 
		{
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			prep = conn.prepareStatement
					("select * from T_user where name=? and passwd=?");
		    //调用预编译对象的setXXX方法，给对应变量赋值
			prep.setString(1,name);
			prep.setString(2,passwd);
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = prep.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			while(rs.next())
		    {
				//创建一个新用户对象，赋值给用户对象变量
				user = new UserVO();
				/*
				 * 调用结果集对象的getXXX()方法，取出各个字段的值
				 * 然后再调用用户对象的setXXX()方法，给属性赋值
				 * 最后新创建的对象中包含了查询结果中的所有字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setMail(rs.getString("mail"));
				user.setBirth(rs.getDate("birth"));
				user.setSuperuser(rs.getInt("superuser"));
		    }
		}
		    catch (SQLException e) {
		    	System.out.println("运行sql语句时出现错误"+e.getMessage());
				//将异常封装成自定义异常
		    	throw new DaoException("登录时查询数据出错",e);
			}
			finally
			{
				//调用数据库工具类，关闭结果集对象和声明对象
				DBUtils.closeStatement(rs, prep);
			}
			/*
			 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据
			 * 如果查询结果为空，该对象为空值null
			 */
			return user;
	}

	/**
	 * 注册/添加用户
	 * @param user 用户信息
	 * @return 注册/添加成功，则返回true；失败返回false
	 */
	public boolean addUser(UserVO user)
	{
		//先判断参数是否为空，如果不为空，进行数据库插入操作
		if(user != null){
			//声明预编译的声明对象变量，用于进行数据库操作的载体
			PreparedStatement prep=null;
			//声明变量，用于保存数据库更新结果
			int result = -1;
			try {
				//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
				prep = conn.prepareStatement
						("insert into T_user(name,passwd,mail,birth) values(?,?,?,?)");
				//调用预编译对象的setXXX方法，给对应变量赋值
				prep.setString(1,user.getName());
				prep.setString(2,user.getPasswd());
				prep.setString(3,user.getMail());
				//将java.util.Date类型转换为java.sql.Date类型
				prep.setDate(4,new java.sql.Date(user.getBirth().getTime()));
				//调用预编译对象的executeUpdate方法，执行插入操作。返回插入结果，赋值给变量
				result = prep.executeUpdate();
				//判断插入结果变量，如果结果大于0，数据库插入成功，返回true；否则插入失败，返回false
				if(result > 0){
					return true;
				}else{
					return false;
				}
				//如果出现异常，输出异常信息，同时，返回false
				}catch (SQLException e) {
			    	System.out.println("运行sql语句时出现错误"+e.getMessage());
					//将异常封装成自定义异常
			    	throw new DaoException("添加或注册用户时插入数据出错",e);
				}finally
				{
					//调用数据库工具类，关闭声明对象
					DBUtils.closeStatement(null, prep);
				}
		}else{
			//如果参数为空，返回false
			return false;
		}
	}

	/**
	 * 删除用户
	 * @param id 用户编号
	 * @return 成功返回true；失败返回false
	 */
	public boolean deleteUser(int id){
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
		//声明变量，用于保存数据库更新结果
		int result = -1;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			prep = conn.prepareStatement
					("delete from T_user where id=?");
			//调用预编译对象的setXXX方法，给对应变量赋值
			prep.setInt(1,id);
			//调用预编译对象的executeUpdate方法，执行插入操作。返回插入结果，赋值给变量
			result = prep.executeUpdate();
			//System.out.println("****************id:"+id);
			//判断插入结果变量，如果结果大于0，数据库插入成功，返回true；否则插入失败，返回false
			if(result > 0){
				return true;
			}else{
				return false;
			}
			//如果出现异常，输出异常信息，同时，返回false
			}catch (SQLException e) {
		    	System.out.println("运行sql语句时出现错误"+e.getMessage());
				//将异常封装成自定义异常
		    	throw new DaoException("删除用户时出错",e);
			}finally
			{
				//调用数据库工具类，关闭声明对象
				DBUtils.closeStatement(null, prep);
			}
	}
	
	/**
	 * 根据id查找用户
	 * @param id 用户编号
	 * @param user 用户信息
	 * @return 用户信息
	 */
	public UserVO findUserById(int id)
	{
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		//声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVO user = null;
		try 
		{
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			prep = conn.prepareStatement
					("select * from T_user where id=?");
		    //调用预编译对象的setXXX方法，给对应变量赋值
			prep.setInt(1,id);
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = prep.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			while(rs.next())
		    {
				//创建一个新用户对象，赋值给用户对象变量
				user = new UserVO();
				/*
				 * 调用结果集对象的getXXX()方法，取出各个字段的值
				 * 然后再调用用户对象的setXXX()方法，给属性赋值
				 * 最后新创建的对象中包含了查询结果中的所有字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setMail(rs.getString("mail"));
				user.setBirth(rs.getDate("birth"));
				user.setSuperuser(rs.getInt("superuser"));
		    }
		}
		    catch (SQLException e) {
		    	System.out.println("运行sql语句时出现错误"+e.getMessage());
				//将异常封装成自定义异常
		    	throw new DaoException("根据id查询数据时出错",e);
			}
			finally
			{
				//调用数据库工具类，关闭结果集对象和声明对象
				DBUtils.closeStatement(rs, prep);
			}
			/*
			 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据
			 * 如果查询结果为空，该对象为空值null
			 */
			return user;
	}

	/**
	 * 根据用户名查找用户
	 * @param name 用户名
	 * @return 用户信息
	 */
	public Vector<UserVO> findUserByName(String name)
	{
		//可能存在多个同名用户，故需用容器来存放多条数据
		Vector<UserVO> v = new Vector<UserVO>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		//声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVO user = null;
		try 
		{
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			prep = conn.prepareStatement
					("select * from T_user where name like ?");
		    //调用预编译对象的setXXX方法，给对应变量赋值
			prep.setString(1,"%"+name+"%");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = prep.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			while(rs.next())
		    {
				//创建一个新用户对象，赋值给用户对象变量
				user = new UserVO();
				/*
				 * 调用结果集对象的getXXX()方法，取出各个字段的值
				 * 然后再调用用户对象的setXXX()方法，给属性赋值
				 * 最后新创建的对象中包含了查询结果中的所有字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setMail(rs.getString("mail"));
				user.setBirth(rs.getDate("birth"));
				user.setSuperuser(rs.getInt("superuser"));
				v.add(user);
		    }
		}
		    catch (SQLException e) {
		    	System.out.println("运行sql语句时出现错误"+e.getMessage());
				//将异常封装成自定义异常
		    	throw new DaoException("根据用户名查询数据时出错",e);
			}
			finally
			{
				//调用数据库工具类，关闭结果集对象和声明对象
				DBUtils.closeStatement(rs, prep);
			}
			/*
			 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据
			 * 如果查询结果为空，该对象为空值null
			 */
			return v;
	}

	/**
	 * 查询所有用户
	 * @return 用户信息
	 */
	public Vector<UserVO> findAll()
	{
		//可能存在多个同名用户，故需用容器来存放多条数据
		Vector<UserVO> v = new Vector<UserVO>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		try 
		{
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			prep = conn.prepareStatement
					("select * from T_user");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = prep.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			while(rs.next())
		    {
				UserVO user = new UserVO();
				/*
				 * 调用结果集对象的getXXX()方法，取出各个字段的值
				 * 然后再调用用户对象的setXXX()方法，给属性赋值
				 * 最后新创建的对象中包含了查询结果中的所有字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setMail(rs.getString("mail"));
				user.setBirth(rs.getDate("birth"));
				user.setSuperuser(rs.getInt("superuser"));
				v.add(user);
		    }
		}
		    catch (SQLException e) {
		    	System.out.println("运行sql语句时出现错误"+e.getMessage());
				//将异常封装成自定义异常
		    	throw new DaoException("查询数据时出错",e);
			}
			finally
			{
				//调用数据库工具类，关闭结果集对象和声明对象
				DBUtils.closeStatement(rs, prep);
			}
			/*
			 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据
			 * 如果查询结果为空，该对象为空值null
			 */
			return v;
	}

	/**
	 * 根据id更新用户
	 * @param user 用户信息
	 * @return 成功返回true；失败返回false
	 */
	public boolean updateUser(UserVO user,int userid)
	{
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
		//声明变量，用于保存数据库更新结果
		int result = -1;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			prep = conn.prepareStatement
					("update T_user set name=?, passwd=?,mail=?,birth=?,superuser=? where id=?");
			//调用预编译对象的setXXX方法，给对应变量赋值
			prep.setString(1,user.getName());
			prep.setString(2,user.getPasswd());
			prep.setString(3,user.getMail());
			//将java.util.Date类型转换为java.sql.Date类型
			prep.setDate(4,new java.sql.Date(user.getBirth().getTime()));
			prep.setInt(5,user.getSuperuser());
			prep.setInt(6,userid);  //注意区分自身id和需要修改的用户的id！！！
			//调用预编译对象的executeUpdate方法，执行更新操作。返回更新结果，赋值给变量
			result = prep.executeUpdate();
			//判断更新结果变量，如果结果大于0，数据库更新成功，返回true；否则更新失败，返回false
			if(result > 0){
				return true;
			}else{
				return false;
			}
			//如果出现异常，输出异常信息，同时，返回false
			}catch (SQLException e) {
		    	System.out.println("运行sql语句时出现错误"+e.getMessage());
				//将异常封装成自定义异常
		    	throw new DaoException("修改用户时修改数据出错",e);
			}finally
			{
				//调用数据库工具类，关闭声明对象
				DBUtils.closeStatement(null, prep);
			}
	}

	@Override public List<UserVO> findUsers(int pageNo, int pageSize)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override public int getRecordCount()
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
