package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.adminDAO;
import cn.edu.lingnan.dao.buyinfoDAO;
import cn.edu.lingnan.dto.adminDTO;
import cn.edu.lingnan.dto.buyinfoDTO;

public class UpdateSelfMessageServlet extends HttpServlet
{
	@Override protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException
	{
//		System.out.println("3333333333333333");
		adminDTO user = (adminDTO)req.getSession().getAttribute("id");
		adminDAO adao = new adminDAO();
		Vector<adminDTO> v = new Vector<adminDTO>();
		v = adao.findSelfMessageById(user.getAid());
		HttpSession s=req.getSession();
		s.setAttribute("user", v);
		//Ò³ÃæÌø×ª
		resp.sendRedirect("updateSelfMessage.jsp");
	}
}
