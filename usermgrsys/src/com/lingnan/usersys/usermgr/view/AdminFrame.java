package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 用于用户管理：权限分为普通用户和管理员
 * @author Administrator
 *
 */
public class AdminFrame extends NormalFrame{
	/**
	 * 带参数的构造器，用于初始化user属性
	 * @param user 用户信息
	 */
	public AdminFrame(UserVO user){
		super(user);
	}
	
	/**
	 * @param power 身份信息（管理员或普通用户）
	 */
	public void loginSuccShow(){
		String power;
		System.out.println("欢迎登录主窗体");
		if(user.getSuperuser() == 1){
			power = "管理员";
		}else{
			power = "普通用户";
		}
		System.out.println(user.getName()+"您好"+"		您的权限是："+ power);
		System.out.println("====================");
		//管理员管理
		if(user.getSuperuser() == 1){
			this.show();
		}else{
			new NormalFrame(user).show();
		}
	}
	
	/**
	 * 进行用户管理的操作界面和操作结果
	 */
	public void show(){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//循环进行如下操作
		while(true){
			//显示管理员登陆成功后的操作界面
			System.out.println("添加用户-------------1");
			System.out.println("删除用户-------------2");
			System.out.println("修改用户-------------3");
			System.out.println("查询用户-------------4");
			System.out.println("程序退出-------------5");
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
