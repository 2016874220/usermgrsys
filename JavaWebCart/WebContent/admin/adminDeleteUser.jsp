<!-- 引包，import -->
<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,com.lingnan.umssys.common.constant.userBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>adminDeleteUserServlet</title>
<!-- 实现按钮的全选、不选、反选、批量删除 -->
<script>
	function allcheck()
	{
		var checkObj = document.getElementsByName("check");
		for(var i=0; i<checkObj.length; i++)
			{
				checkObj[i].checked = true;
			}
	}
	function allnotcheck()
	{
		var checkObj = document.getElementsByName("check");
		for(var i=0; i<checkObj.length; i++)
			{
				checkObj[i].checked = false;
			}
	}
	function backcheck()
	{
		var checkObj = document.getElementsByName("check");
		for(var i=0; i<checkObj.length; i++)
			{
				if(checkObj[i].checked == true)
					{
					checkObj[i].checked = false;
					}
				else
					{
						checkObj[i].checked = true;
					}
			}
	}
	function batchdelete()
	{
		var arr = [];
		var flag = false;
		var checkObj = document.getElementsByName("check");
		for(var i=0; i<checkObj.length; i++)
			{
				if(checkObj[i].checked == true)
				{
					arr.push(checkObj[i].value);
					flag = true;
				}
			}
		alert(arr);
		if(flag = true)
			{
				if(confirm("您确定要删除该用户？"))
					{
						location.href="adminBatchDeleteUserServlet?arr="+arr;
					}
			}
		else
			{
			alert("您至少选择一个用户，再进行删除！");
			}
	}
</script>
</head>
<body>
	<table border=1>
		<!-- 修改字符编码（包括.jsp本身的默认字符编码）-->
		<tr>
			<td></td>
			<td>用户账号</td>
			<td>用户名</td>
			<td>密码</td>
			<td>身份（1管理员，2商家，3买家）</td>
			<td>买家是否已清空该购物信息（1未删除，0已删除）</td>
		</tr>
		<%
			Vector<userBean> v = new Vector<userBean>();
			v = (Vector<userBean>) session.getAttribute("alluser");
			//Iterator迭代器，用于遍历容器里的对象
			Iterator it = v.iterator();
			userBean a = null;
			while (it.hasNext())
			{
				a = (userBean) it.next();
		%>
		<tr>
			<td><input type="checkbox" name="check" value=<%=a.getAid()%>></td>
			<td><%=a.getAid()%></td>
			<td><%=a.getAname()%></td>
			<td><%=a.getPassword()%></td>
			<td><%=a.getSuperuser()%></td>
			<td><%=a.getState()%></td>
			<td><a href="adminDeleteUserServlet?aid=<%=a.getAid()%>">删除</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<input type="button" id="btn1" value="全选" onClick="allcheck();" />
	<input type="button" id="btn2" value="不选" onClick="allnotcheck();" />
	<input type="button" id="btn3" value="反选" onClick="backcheck();" />
	<input type="button" value="批量删除" onClick="batchdelete();" />
</body>
</html>