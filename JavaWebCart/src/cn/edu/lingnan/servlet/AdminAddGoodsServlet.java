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

public class AdminAddGoodsServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
		//1.从页面获取我们想要的数据（4个）
		String gid = req.getParameter("gid");
		String gname = req.getParameter("gname");
		String price = req.getParameter("price");
		String gnum = req.getParameter("gnum");
		System.out.println("1："+gid+"	"+gname+"	"+price+"	"+gnum);
		//2.调用后台的业务逻辑去判断这个用户名和密码是否存在且对应
		goodsDAO gd = new goodsDAO();
		goodsDTO gdto = new goodsDTO();
		gdto.setGid(gid);
		gdto.setGname(gname);
		gdto.setPrice(price);
		gdto.setGnum(gnum);
		boolean flag = gd.insertGoods(gid, gname, price, gnum);
		//页面跳转之前，需更新v，否则里面的值还是原来未作修改的
		Vector<goodsDTO> v = new Vector<goodsDTO>();
		v = gd.adminFindAllGoods();
		//把结果传到jsp页面里去
		HttpSession s = req.getSession();
		//setAttribute(string name, object value)，即变量名以及变量对应的值
		s.setAttribute("alladdgoods", v);
		//页面跳转
		resp.sendRedirect("adminAddGoods.jsp");
	}
}
