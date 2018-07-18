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


public class BuyerUpdateBuyinfoServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
//		System.out.println("3333333333333333");
		buyinfoDTO cart = (buyinfoDTO)req.getSession().getAttribute("id2");
		buyinfoDAO bdao = new buyinfoDAO();
		Vector<buyinfoDTO> v = new Vector<buyinfoDTO>();
		v = bdao.findCartById(cart.getAid());
		HttpSession s=req.getSession();
		s.setAttribute("cart", v);
		//Ò³ÃæÌø×ª
		resp.sendRedirect("buyerUpdatebuyinfo.jsp");
	}
}
