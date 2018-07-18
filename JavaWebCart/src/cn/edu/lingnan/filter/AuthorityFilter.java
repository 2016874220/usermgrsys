package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter 
{

	public void destroy() 
	{
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException 
	{
		// 判断登录用户的权限是什么，如果是超级用户（1）那么可以去到admin目录下的页面，否则去权限错误的页面
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession s = request.getSession();
		Integer superValue = (Integer) s.getAttribute("superValue");
		System.out.println("---3---判断是否在过滤器读到了superValue的值：" + superValue);
		if (superValue != null) 
		{
			if (superValue == 1)
					arg2.doFilter(arg0, arg1);
			else
				response.sendRedirect(request.getContextPath()
						+ "/authority.html");
		} 
		else 
		{
			response.sendRedirect(request.getContextPath() 
					+ "/index.html");
		}
	}

	public void init(FilterConfig arg0) throws ServletException 
	{
		
	}
}

