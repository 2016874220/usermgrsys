package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.goodsDAO;
import cn.edu.lingnan.dto.goodsDTO;


public class AdminDeleteGoodsServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
		String gid = req.getParameter("gid");
		goodsDAO gd = new goodsDAO();
		boolean flag = gd.deleteGoods(gid);
		//页面跳转之前，需更新v，否则里面的值还是原来未作修改的
		Vector<goodsDTO> v = new Vector<goodsDTO>();
		v = gd.adminFindAllGoods();
		//把结果传到jsp页面里去
		HttpSession s = req.getSession();
		//setAttribute(string name, object value)，即变量名以及变量对应的值
		s.setAttribute("alldeletegoods", v);
		//页面跳转
		resp.sendRedirect("adminDeleteGoods.jsp");
	}
}
