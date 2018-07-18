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

public class BuyerUpdateBuyinfoStepTwoServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
		buyinfoDTO cart = (buyinfoDTO)req.getSession().getAttribute("id2");
		String aid = req.getParameter("aid");
		String bid = req.getParameter("bid");
		String gid = req.getParameter("gid");
		String sumnum = req.getParameter("sumnum");
		System.out.println("---------------"+bid+"   "+aid+"   "+gid+"   "+sumnum);
		buyinfoDTO bdto = new buyinfoDTO();
		buyinfoDAO bdao =new buyinfoDAO();
		bdto.setBid(bid);
		bdto.setAid(aid);
		bdto.setGid(gid);
		bdto.setSumnum(Integer.parseInt(sumnum));
		boolean flag = bdao.buyerUpdateBuyinfo(bdto);
		Vector<buyinfoDTO> v = new Vector<buyinfoDTO>();
		//先找出所有用户，罗列出来，以供选择，然后加以修改
		v = bdao.findCartById(cart.getAid());
		HttpSession s=req.getSession();
		s.setAttribute("cart", v);
		//页面跳转
		resp.sendRedirect("buyerUpdatebuyinfo.jsp");
	}
}
