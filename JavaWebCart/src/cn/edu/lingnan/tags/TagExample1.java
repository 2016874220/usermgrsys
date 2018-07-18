package cn.edu.lingnan.tags;
/*
 * 为标签开发一个标签处理器：TagExample1.java
 */
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagExample1 extends TagSupport
{
	//标签开始
	public int doStartTag() throws JspException
	{
		try
		{
			pageContext.getOut().println("--------------20180606-------------");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}
	
	//标签结束
	public int doEndTag() throws JspException
	{
		return Tag.EVAL_PAGE;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
