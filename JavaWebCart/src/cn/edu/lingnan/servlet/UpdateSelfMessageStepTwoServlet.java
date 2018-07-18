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
import cn.edu.lingnan.dto.buyinfoDTO;

public class UpdateSelfMessageStepTwoServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
		String aid = req.getParameter("aid");
		String aname = req.getParameter("aname");
		String password = req.getParameter("password");
		System.out.println(aid+"   "+aname+"   "+password);
		adminDTO adto = new adminDTO();
		adminDAO adao =new adminDAO();
		adto.setAid(aid);
		adto.setAname(aname);
		adto.setPassword(password);
		boolean flag = adao.adminUpdateUser(adto);
		//返回登录界面，重新登录
		resp.sendRedirect("login.html");
	}
}
