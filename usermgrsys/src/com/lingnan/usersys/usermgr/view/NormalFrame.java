package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 用于用户管理：权限分为普通用户和管理员
 * @author Administrator
 *
 */
public class NormalFrame extends IndexFrame{
	//用户对象
	UserVO user = null;
	
	/**
	 * 带参数的构造器，用于初始化user属性
	 * @param user 用户信息
	 */
	public NormalFrame(UserVO user){
		this.user = user;
	}
	
	/**
	 * 进行用户管理的操作界面和操作系统
	 */
	public void show(){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//循环进行如下操作
		while(true){
			//显示普通用户登陆成功后的操作界面
			System.out.println("修改个人信息---------------1");
			System.out.println("查询个人信息---------------2");
			System.out.println("程序退出------------------3");
			//声明变量，用于接收从控制台输入的操作选项数字
			int i = -1;
			//读取用户控制台输入，如果输入值正确，中断循环；否则提示错误信息，再重新输入
			while(true){
				try{
					//读取用户输入操作选项的数字，同时转换为int型
					i = Integer.parseInt(br.readLine());
					//中断该循环，进行下一步操作：i值判断
					break;
				}catch (Exception e)
				{
					//出现异常时，提示错误信息，再重新输入
					System.out.println("输入错误，只能输入1~3的数字");
					System.out.println("请您重新输入");
				}
			}
		}	
	}
}
