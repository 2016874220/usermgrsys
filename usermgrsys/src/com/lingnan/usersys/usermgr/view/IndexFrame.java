package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.util.CheckMailUtils;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * 
 * @author Administrator
 *
 */
public class IndexFrame implements BaseFrame{
	
	/**
	 * 用户登录和注册操作界面
	 */
	public void show(){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//循环操作
		while(true){
			//用户登录和注册界面
			System.out.println("欢迎使用本用户管理系统");
			System.out.println("====================");
			System.out.println("请选择：");
			System.out.println("用户登录-------------1");
			System.out.println("用户注册-------------2");
			System.out.println("退出程序-------------3");
			int i = -1;
			//读取用户控制台输入，如果输入值正确，中断循环，否则提示错误信息，再重新输入
			while(true){
				try{
					//读取用户输入操作选项的数字，同时转换为int型
					i = Integer.parseInt(br.readLine());
					//中断该循环，进入下一步操作：i值判断
					break;
				}catch(Exception e){
					//出现异常时，提示错误信息，再重新输入
					System.out.println("输入错误，只能输入1~3的数字");
					System.out.println("请您重新输入");
				}
			}
			/*
			 * 判断用户输入值，如果值为1，进行用户登录操作，
			 * 如果值为2，进行用户注册操作，如果值为3，退出系统
			 */
			switch(i){
				case 1:
					this.loginShow();
					break;//中断switch
				case 2:
					this.addShow("注册");
					break;
				case 3:
					System.out.println("感谢您的使用，再会！");
					//退出当前界面
					System.exit(0);
					default: //输入值是1~3之外的数字
						System.out.println("输入错误，只能输入1~3的数字");
						System.out.println("请您重新输入");
			}
		}
	}
	/**
	 * 
	 */
	public void loginShow(){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		System.out.println("用户登录界面");
		System.out.println("====================");
		System.out.println("请输入您的用户名：");
		try{
			//以行为单位，读取输入的各个值，赋值给用户对象的各个属性
			String name = br.readLine();
			System.out.println("请输入您的密码：");
			String passwd = br.readLine();
			//调用控制器中的doLogin方法，进行用户登录操作
			UserController uc = new UserController();
			UserVO user = uc.doLogin(name, passwd);
			if(user != null){  //如果返回值不为空，登录成功，显示用户信息操作界面；否则登录失败，显示失败信息
				System.out.println("登录成功。。。");
				System.out.println("====================");
				//调用主界面
				AdminFrame m = new AdminFrame(user);
				m.loginSuccShow();
				//退出当前界面
				System.exit(0);
			}else{
				//登录失败，显示失败信息
				System.out.println("登录失败！！！");
			}	
		}catch(Exception e){
			//显示异常信息
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 
	 */
	public void addShow(String type){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		if("注册".equals(type)){
			System.out.println("用户注册界面");
			System.out.println("====================");
		}else if("添加用户".equals(type)){
			System.out.println("添加用户界面");
			System.out.println("====================");
		}
		System.out.println("请输入用户名：");
		try{
			//实例化用户对象
			UserVO user = new UserVO();
			//读取输入的各个值，赋值给用户对象的各个属性
			user.setName(br.readLine());
			System.out.println("请输入密码：");
			user.setPasswd(br.readLine());
			while(true){
				System.out.println("请输入邮箱：");
				String mail = br.readLine();
				if(CheckMailUtils.isNameAdressFormat(mail)){
					user.setMail(mail);
					break;
				}
			}
			System.out.println("请输入出生日期（YYYY-MM-DD）：");
			user.setBirth(TypeUtils.strToDate(br.readLine()));
			
			UserController uc = new UserController();
			//调用用户控制器中的doRegister方法，进行用户注册操作

			boolean flag = uc.doRegister(user);
			//如果返回值为真，注册成功，显示成功信息；反之注册失败，显示失败信息
			if(flag){
				if("注册".equals(type)){
					System.out.println("用户注册成功");
				}else{
					System.out.println("添加用户成功");
				}
				}else{
					if("注册".equals(type)){
						System.out.println("用户注册失败");
					}else{
						System.out.println("添加用户失败");
					}
				}
			}catch(DateException e){
				//显示异常信息
				if("注册".equals(type)){
					System.out.println("用户注册时出现错误"+e.getMessage());
				}else{
					System.out.println("添加用户时出现错误"+e.getMessage());
				}
			}catch(Exception e){
				if("注册".equals(type)){
					System.out.println("用户注册时出现错误"+e.getMessage());
				}else{
					System.out.println("添加用户时出现错误"+e.getMessage());
				}
			}
		}
		
		public void searchShow(){
		
		}
		
		public void updateShow(String type,UserVO user){
		
		}
	}
