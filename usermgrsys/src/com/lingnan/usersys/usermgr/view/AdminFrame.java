package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import com.lingnan.usersys.common.util.CheckMailUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
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
	 * 查找个人信息
	 * @param power 身份信息（管理员或普通用户）
	 */
	public void findSelfShow(){
		String power;
		if(user.getSuperuser() == 1){
			power = "管理员";
		}else{
			power = "普通用户";
		}
		System.out.println(user.getId()+"  "+user.getName()+"  "+user.getPasswd()+
				"  "+user.getMail()+"  "+user.getBirth()+"  "+power);
		System.out.println("====================");
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
					System.out.println("输入错误，只能输入1~5的数字");
					System.out.println("请您重新输入");
				}
			}
			int id = 0;
			// 判断用户输入值，进行相应操作
			switch(i){
				case 1:
					IndexFrame adduser = new IndexFrame();
					adduser.addShow("添加用户");
					break;//中断switch
				case 2:
					this.deleteShow(id);
					break;
				case 3:
					this.updateShow(user,id);
					break;
				case 4:
					this.selectToUpdateShow();
					break;
				case 5:
					System.out.println("感谢您的使用，再会！");
					//退出当前界面
					System.exit(0);
					default: //输入值是1~5之外的数字
						System.out.println("输入错误，只能输入1~5的数字");
						System.out.println("请您重新输入");
			}
		}	
	}
	
	/**
	 * 进行查询方法选择的操作界面和操作结果
	 */
	public void selectToUpdateShow(){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//循环进行如下操作
		while(true){
			//显示管理员选择查询后的操作界面
			System.out.println("查询选择界面");
			System.out.println("====================");
			System.out.println("查询全部用户----------1");
			System.out.println("根据ID查询用户--------2");
			System.out.println("根据用户名查询用户------3");
			System.out.println("请选择");
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
			// 判断用户输入值，进行相应操作
			switch(i){
				case 1:
					this.findAllShow();
					break;//中断switch
				case 2:
					int id = 0;
					this.findUserByIdShow(id);
					break;
				case 3:
					String name = null;
					this.findUserByNameShow(name);
					break;
				default: //输入值是1~3之外的数字
						System.out.println("输入错误，只能输入1~3的数字");
						System.out.println("请您重新输入");
			}
		}	
	}
	
	/**
	 * 
	 */
	public void deleteShow(int id){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		System.out.println("删除用户界面");
		System.out.println("====================");
		System.out.println("请输入要删除用户的ID号码：");
		try
		{
			//id = br.read();          //****出错！输入id为37，实则为51，所以删除失败，需进行类型转换
			String ID = br.readLine();
			id = Integer.parseInt(ID);
			
			//调用控制器中的doDelete方法，进行用户登录操作
			UserController uc = new UserController();
			boolean flag = uc.doDelete(id);
			if(flag == true){  //如果为true，删除成功；否则删除失败，显示失败信息
				System.out.println("删除用户成功");
				System.out.println("====================");
				//调用主界面
				this.show();
				//退出当前界面
				System.exit(0);
			}else{
				//删除失败，显示失败信息
				System.out.println("删除失败！！！");
			}	
		}catch(Exception e){
			//显示异常信息
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 */
	public void updateShow(UserVO user,int userid){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("修改用户界面");
		System.out.println("====================");
		System.out.println("请输入要修改的用户的ID号码：");
		try
		{
			//id = br.read();          //****出错！输入id为37，实则为51，所以删除失败，需进行类型转换
			String ID = br.readLine();
			userid = Integer.parseInt(ID);
			System.out.println("请输入要修改的用户的用户名：");
			user.setName(br.readLine());
			System.out.println("请输入要修改的用户的密码：");
			user.setPasswd(br.readLine());
			while(true){
				System.out.println("请输入要修改的用户的邮箱：");
				String mail = br.readLine();
				if(CheckMailUtils.isNameAdressFormat(mail)){
					user.setMail(mail);
					break;
				}
			}
			System.out.println("请输入要修改的用户的权限（管理员1，普通用户2）：");
			String Superuser = br.readLine();
			int supersuer = Integer.parseInt(Superuser);
			//调用控制器中的doUpdate方法，进行修改用户操作
			UserController uc = new UserController();
			boolean flag = uc.doUpdate(user,userid);
			if(flag == true){  //如果为true，修改成功；否则修改失败，显示失败信息
				System.out.println("修改用户成功");
				System.out.println("====================");
				//调用主界面
				this.show();
				//退出当前界面
				System.exit(0);
			}else{
				//修改失败，显示失败信息
				System.out.println("修改失败！！！");
			}	
		}catch(Exception e){
			//显示异常信息
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 */
	public void findUserByIdShow(int id){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("根据id查找用户界面");
		System.out.println("====================");
		System.out.println("请输入要查询的ID：");
		try
		{
			//id = br.read();          //****出错！输入id为37，实则为51，所以删除失败，需进行类型转换
			String ID = br.readLine();
			id = Integer.parseInt(ID);
			
			//调用控制器中的doFindUserById方法，进行根据用户id查询用户信息操作
			UserController uc = new UserController();
			UserVO user = uc.doFindUserById(id);
			if(user != null){  //如果返回值不为空，查询成功，显示用户信息；否则查询失败，显示失败信息
				String power;
				if(user.getSuperuser() == 1){
					power = "管理员";
				}else{
					power = "普通用户";
				}
				System.out.println(user.getId()+"  "+user.getName()+"  "+user.getPasswd()+
						"  "+user.getMail()+"  "+user.getBirth()+"  "+power);
				System.out.println("====================");
				this.show();
			}else{
				//查询失败，显示失败信息
				System.out.println("该用户不存在");
				System.out.println("====================");
			}	
		}catch(Exception e){
			//显示异常信息
			System.out.println("请输入正确格式的用户ID");
			this.findUserByIdShow(id);
		}
	}
	
	/**
	 * 
	 */
	public void findUserByNameShow(String name){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("根据用户名查找用户界面");
		System.out.println("====================");
		System.out.println("请输入要查询的用户名：");
		try
		{
			name = br.readLine();
			
			//调用控制器中的doFindUserByName方法，进行根据用户名查询用户信息操作
			UserController uc = new UserController();
			Vector<UserVO> v = uc.doFindUserByName(name);
			if(user != null){  //如果返回值不为空，查询成功，显示用户信息；否则查询失败，显示失败信息
				String power;
				if(user.getSuperuser() == 1){
					power = "管理员";
				}else{
					power = "普通用户";
				}
				Iterator it = v.iterator();
				UserVO user = null;
				while (it.hasNext()){
					user = (UserVO) it.next();
					System.out.println(user.getId()+"  "+user.getName()+"  "+user.getPasswd()+
						"  "+user.getMail()+"  "+user.getBirth()+"  "+power);
				}
				System.out.println("====================");
				this.show();
			}else{
				//查询失败，显示失败信息
				System.out.println("该用户不存在");
				System.out.println("====================");
			}	
		}catch(Exception e){
			//显示异常信息
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 */
	public void findAllShow(){
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("查找所有用户界面");
		System.out.println("====================");
		try
		{			
			//调用控制器中的doFindUserByName方法，进行根据用户名查询用户信息操作
			UserController uc = new UserController();
			Vector<UserVO> v = uc.doFindAll();
			if(user != null){  //如果返回值不为空，查询成功，显示用户信息；否则查询失败，显示失败信息
				String power;
				if(user.getSuperuser() == 1){
					power = "管理员";
				}else{
					power = "普通用户";
				}
				Iterator it = v.iterator();
				UserVO user = null;
				while (it.hasNext()){
					user = (UserVO) it.next();
					System.out.println(user.getId()+"  "+user.getName()+"  "+user.getPasswd()+
						"  "+user.getMail()+"  "+user.getBirth()+"  "+power);
				}
				System.out.println("====================");
				this.show();
			}else{
				//查询失败，显示失败信息
				System.out.println("查询失败");
				System.out.println("====================");
			}	
		}catch(Exception e){
			//显示异常信息
			System.out.println(e.getMessage());
		}
	}
}
