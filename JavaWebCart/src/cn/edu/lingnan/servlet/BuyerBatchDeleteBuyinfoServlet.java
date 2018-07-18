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

public class BuyerBatchDeleteBuyinfoServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
		String[] arr1 = req.getParameterValues("arr1");
	    buyinfoDAO bdao = new buyinfoDAO();
		buyinfoDTO cart = (buyinfoDTO)req.getSession().getAttribute("id1");
		for(String a:arr1)
		{
			//对从页面中传进来的数据进行处理（去掉分隔每个数据之间的逗号）
			String[] b = a.split(",");
			for (String c : b)
			{
				bdao.userDeleteBuyinfoById(c);
			}
		}
		Vector<buyinfoDTO> v = new Vector<buyinfoDTO>();
		v = bdao.findCartById(cart.getAid());
		//把结果传到jsp页面里去
		HttpSession s = req.getSession();
		//setAttribute(string name, object value)，即变量名以及变量对应的值
		s.setAttribute("cart", v);
		//页面跳转
		resp.sendRedirect("buyerDeleteBuyinfo.jsp");
	}
}
