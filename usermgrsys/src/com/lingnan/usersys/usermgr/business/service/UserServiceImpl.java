package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;
import java.util.List;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.business.dao.UserDao;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * 
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{
	/**
	 * 用户service类实例
	 */
	private static UserService userService = new UserServiceImpl();
	
	/**
	 * 构造方法
	 */
	private UserServiceImpl(){
		
	}
	
	/**
	 * 取得用户service实例
	 * @return 实例对象
	 */
	public static UserService getInstance(){
		return userService;
	}
	
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param passwd 密码
	 * @return 用户信息
	 */
	public UserVO login(String name, String passwd){
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		UserVO user = null;
		//调用数据库工具类的getConnection方法,取得数据库连接对象，并赋值给数据库连接对象变量
		conn = DBUtils.getConnection();
		//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
		UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
		//调用dao中的login方法，进行登录操作，结果赋值给登录结果变量
		user = userMgrDao.login(name, passwd);
		try{
			
		}catch(DaoException e){
			//将自定义异常抛出
			throw e;
		}catch(Exception e){
			//将异常封装成自定义异常并抛出
			throw new ServiceException("用户登录错误",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return user;
	}
	
	/**
	 * 添加/注册用户
	 * @param user 用户信息
	 * @return 当flag=true，添加/注册用户成功；当flag=false，添加/注册用户失败
	 */
	public boolean addUser(UserVO user)
	{
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库插入结果
		boolean flag = false;
		try{
			//调用数据库工具类的getConnection方法,取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用数据库工具类的beginTransaction方法，开启事务
			DBUtils.beginTransaction(conn);
			//调用dao中的addUser方法，进行数据库插入操作，结果赋值给插入结果变量
			flag = userMgrDao.addUser(user);
			//调用数据库工具类的commit方法，提交事务
			DBUtils.commit(conn);
		}catch(DaoException e){
			//将自定义异常抛出
			throw e;
		}catch(Exception e){
			//操作过程中出现异常，调用数据库工具类的rollback方法，回滚事务
			DBUtils.rollback(conn);
			//将异常封装成自定义异常并抛出
			throw new ServiceException("添加或注册用户错误",e);
		}finally{
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库插入结果
		return flag;
	}

	/**
	 * 根据id查找用户
	 * @param id 用户编号
	 * @return 用户信息 
	 */
	public UserVO findUserById(int id)
	{
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		UserVO user = null;
		//调用数据库工具类的getConnection方法,取得数据库连接对象，并赋值给数据库连接对象变量
		conn = DBUtils.getConnection();
		//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
		UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
		//调用dao中的findUserById方法，进行登录操作，结果赋值给登录结果变量
		user = userMgrDao.findUserById(id);
		try{
			
		}catch(DaoException e){
			//将自定义异常抛出
			throw e;
		}catch(Exception e){
			//将异常封装成自定义异常并抛出
			throw new ServiceException("根据id查询用户错误",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return user;
	}

	@Override public List<UserVO> findUserByName(String name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override public List<UserVO> findAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override public boolean updateUser(UserVO user)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override public boolean daleteUser(int id)
	{
		// TODO Auto-generated method stub
		return false;
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
