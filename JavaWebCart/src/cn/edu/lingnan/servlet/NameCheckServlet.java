package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.adminDAO;

public class NameCheckServlet extends HttpServlet
{
	@Override protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
		//从传过来的链接里面读参数
		String username = req.getParameter("username");
		System.out.println("-------------username:      "+username);
		adminDAO adao = new adminDAO();
		boolean flag = adao.findUserByName(username);
		//给前面的页面一个值，让register.html里的函数userNameCheck()的request.responseText能够读到数据；
		if(flag)
		{
			resp.getWriter().print("true");//传递过去之后，前端的页面就能得到这个"true"，然后判断用户已存在
		}
	}
}
