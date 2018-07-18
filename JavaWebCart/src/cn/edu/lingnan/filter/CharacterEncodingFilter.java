package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter
{
	String encoding = null;
	public void destroy()
	{
		this.encoding = null;
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException
	{
//		System.out.println("过滤器起效......");
		//对字符集进行编码（把参数移入配置文件）
		arg0.setCharacterEncoding(this.encoding);
		arg1.setCharacterEncoding(this.encoding);
		//资源继续往下传递
		arg2.doFilter(arg0, arg1);
	}

	//初始化。FilterConfig这个配置读的是配置文件web.xml里的参数，在此把它写入配置文件
	public void init(FilterConfig arg0) throws ServletException
	{
		this.encoding = arg0.getInitParameter("encoding");
		
	}
	
}
