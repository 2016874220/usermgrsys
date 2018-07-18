package com.lingnan.usersys.usermgr.controller;

import com.lingnan.usersys.usermgr.business.service.UserService;
import com.lingnan.usersys.usermgr.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * 
 * @author Administrator
 *
 */
public class UserController
{
	//声明用户service接口对象，用于业务处理
	UserService userMgrService = UserServiceImpl.getInstance();
	
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param passwd 密码
	 * @return 用户信息
	 */
	public UserVO doLogin(String name, String passwd){
		UserVO user = null;
		try{
			//调用用户service接口中的login方法，进行用户登录操作
			user = userMgrService.login(name,passwd);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户登录时出现错误："+e.getMessage());
		}
		return user;
	}
	
	/**
	 * 用户注册
	 * @param user 用户信息
	 * @return 成功返回true；失败返回false
	 */
	public boolean doRegister(UserVO user){
		boolean flag = false;
		try
		{
			flag = userMgrService.addUser(user);
		}
		catch (Exception e)
		{
			System.out.println("用户注册时出现错误"+e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 添加用户
	 * @param user 用户信息
	 * @return 成功返回true；失败返回false
	 */
	public boolean doAdd(UserVO user){
		boolean flag = false;
		try
		{
			flag = userMgrService.addUser(user);
		}
		catch (Exception e)
		{
			System.out.println("添加用户时出现错误"+e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 根据id查询用户
	 * @param id 用户编号
	 * @return 用户信息
	 */
	public UserVO doFindUserById(int id){
		UserVO user = null;
		try{
			//调用用户service接口中的login方法，进行用户登录操作
			user = userMgrService.findUserById(id);
		}catch(Exception e){
			//显示异常信息
			System.out.println("根据id查询用户时出现错误："+e.getMessage());
		}
		return user;
	}
}
