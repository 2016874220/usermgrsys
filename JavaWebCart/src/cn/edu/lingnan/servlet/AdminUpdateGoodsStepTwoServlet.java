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

public class AdminUpdateGoodsStepTwoServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
		String gid = req.getParameter("gid");
		String gname = req.getParameter("gname");
		String price = req.getParameter("price");
		String gnum = req.getParameter("gnum");
		System.out.println("---------------"+gid+"   "+gname+"   "+price+"   "+gnum);
		goodsDTO gdto = new goodsDTO();
		goodsDAO gdao =new goodsDAO();
		gdto.setGid(gid);
		gdto.setGname(gname);
		gdto.setPrice(price);
		gdto.setGnum(gnum);
		boolean flag = gdao.adminUpdateGoods(gdto);
		Vector<goodsDTO> v = new Vector<goodsDTO>();
		//先找出所有用户，罗列出来，以供选择，然后加以修改
		v = gdao.adminFindAllGoods();
		HttpSession s = req.getSession();
		s.setAttribute("allupdategoods", v);
		//页面跳转
		resp.sendRedirect("adminUpdateGoods.jsp");
	}
}
