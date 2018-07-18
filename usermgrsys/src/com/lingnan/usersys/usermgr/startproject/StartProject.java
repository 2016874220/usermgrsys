package com.lingnan.usersys.usermgr.startproject;

import com.lingnan.usersys.usermgr.view.IndexFrame;

/**
 * 系统启动类
 * @author Administrator
 *
 */
public class StartProject{
	public static void main(String[] args)
	{
		//实例化用户登录和注册的操作界面类
		IndexFrame frame = new IndexFrame();
		//调用loginFrame方法，显示用户登录和注册的操作界面
		frame.show();
	}
}
