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

public class AdminBatchDeleteGoodsServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
		String[] arr = req.getParameterValues("arr");
	    goodsDAO gdao = new goodsDAO();
		for(String a:arr)
		{
			//对从页面中传进来的数据进行处理（去掉分隔每个数据之间的逗号）
			String[] b = a.split(",");
			for (String c : b)
			{
				gdao.deleteGoods(c);
			}
		}
		Vector<goodsDTO> v = new Vector<goodsDTO>();
		v = gdao.adminFindAllGoods();
		//把结果传到jsp页面里去
		HttpSession s = req.getSession();
		//setAttribute(string name, object value)，即变量名以及变量对应的值
		s.setAttribute("alldeletegoods", v);
		//页面跳转
		resp.sendRedirect("adminDeleteGoods.jsp");
	}
}
