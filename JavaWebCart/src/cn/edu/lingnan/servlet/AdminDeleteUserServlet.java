package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.adminDAO;
import cn.edu.lingnan.dto.adminDTO;

public class AdminDeleteUserServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
		//此处aid为String
		String aid = req.getParameter("aid");
//		System.out.println("2222222222		"+aid);
		adminDAO ad = new adminDAO();
		boolean flag = ad.deleteUser(aid);
//		if(flag)
//		{
//			
//		}
		//页面跳转之前，需更新v，否则里面的值还是原来未作修改的
		Vector<adminDTO> v = new Vector<adminDTO>();
		v = ad.adminFindAllUser();
		//把结果传到jsp页面里去
		HttpSession s = req.getSession();
		//setAttribute(string name, object value)，即变量名以及变量对应的值
		s.setAttribute("alluser", v);
		//页面跳转
		resp.sendRedirect("adminDeleteUser.jsp");
	}
}
