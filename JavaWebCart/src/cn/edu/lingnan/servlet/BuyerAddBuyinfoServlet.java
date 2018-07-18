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


public class BuyerAddBuyinfoServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
		//1.从页面获取我们想要的数据（4个）
		buyinfoDTO cart = (buyinfoDTO)req.getSession().getAttribute("id4");
		String bid = req.getParameter("bid");
		String aid = req.getParameter("aid");
		String gid = req.getParameter("gid");
		String sumnum = req.getParameter("sumnum");
		//2.调用后台的业务逻辑去判断这个用户名和密码是否存在且对应
		buyinfoDAO bd = new buyinfoDAO();
		buyinfoDTO bdto = new buyinfoDTO();
		bdto.setBid(bid);
		bdto.setAid(aid);
		bdto.setGid(gid);
		bdto.setSumnum(Integer.getInteger(sumnum));
		boolean flag = bd.userInsertBuyinfo(bid, aid, gid, sumnum);
		//页面跳转之前，需更新v，否则里面的值还是原来未作修改的
		Vector<buyinfoDTO> v = new Vector<buyinfoDTO>();
		v = bd.findCartById(cart.getAid());
		HttpSession s=req.getSession();
		s.setAttribute("cart", v);
		//页面跳转
		resp.sendRedirect("buyerAddBuyinfo.jsp");
	}
}
