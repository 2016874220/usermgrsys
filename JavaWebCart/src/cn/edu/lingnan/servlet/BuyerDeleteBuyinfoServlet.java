package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.buyinfoDAO;
import cn.edu.lingnan.dto.buyinfoDTO;


public class BuyerDeleteBuyinfoServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
		//getParameter得到的都是String类型的。或者是用于读取提交的表单中的值（http://a.jsp?id=123中的123）
		buyinfoDTO cart = (buyinfoDTO)req.getSession().getAttribute("id1");
		String bid = req.getParameter("bid");
		buyinfoDAO bdao = new buyinfoDAO();
		boolean flag = bdao.userDeleteBuyinfoById(bid);
		//页面跳转之前，需更新v，否则里面的值还是原来未作修改的
		Vector<buyinfoDTO> v = new Vector<buyinfoDTO>();
		v = bdao.findCartById(cart.getAid());
		//把结果传到jsp页面里去
		HttpSession s=req.getSession();
		s.setAttribute("cart", v);
		//页面跳转
		resp.sendRedirect("buyerDeleteBuyinfo.jsp");
	}
}
