<!-- 引包，import -->
<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,com.lingnan.umssys.common.constant.buyinfoDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 去掉超链接下划线 -->
<style>
a {
	text-decoration: none
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>商品销售系统</title>
<!-- Bootstrap Styles-->
<link href="../assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="../assets/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->
<link href="../assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="../assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet"
	href="../assets/js/Lightweight-Chart/cssCharts.css">

<!-- 实现按钮的全选、不选、反选、批量删除 -->
<script>
	function allcheck() {
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++) {
			checkObj[i].checked = true;
		}
	}
	function allnotcheck() {
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++) {
			checkObj[i].checked = false;
		}
	}
	function backcheck() {
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++) {
			if (checkObj[i].checked == true) {
				checkObj[i].checked = false;
			} else {
				checkObj[i].checked = true;
			}
		}
	}
	function batchdelete() {
		var arr1 = [];
		var flag = false;
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++) {
			if (checkObj[i].checked == true) {
				arr1.push(checkObj[i].value);
				flag = true;
			}
		}
		alert(arr1);
		if (flag = true) {
			if (confirm("您确定要删除该购物车？")) {
				location.href = "buyerBatchDeleteBuyinfoServlet?arr1=" + arr1;
			}
		} else {
			alert("您至少选择一个购物车再进行删除！");
		}
	}
</script>
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="buyer.html"><strong>商品销售系统</strong></a>
		</div>

		<!--右上角下拉框-->
		<ul class="nav navbar-top-links navbar-right">
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" aria-expanded="false"> <i
					class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="../updateSelfMessageServlet"><i class="fa fa-sign-out fa-fw"></i>修改个人信息</a>
					<li><a href="../logoutServlet"><i
							class="fa fa-sign-out fa-fw"></i>退出</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		</nav>

		<!-- 左侧导航条 -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a href="goodsinfoForBuyerServlet"><i class="fa fa-table"></i>商品信息</a>
                    </li>
                    <li>
                        <a href="buyerAddBuyinfoServlet"><i class="fa fa-edit"></i>添加购物车</a>
                    </li>
                    <li>
                        <a class="active-menu" href="buyerDeleteBuyinfoServlet"><i class="fa fa-edit"></i>删除购物车</a>
                    </li>
                    <li>
                        <a href="buyerUpdateBuyinfoServlet"><i class="fa fa-edit"></i>修改购物车</a>
                    </li>
                    <li>
                        <a href="buyerFindCartServlet"><i class="fa fa-desktop"></i>查看购物车</a>
                    </li>
                </ul>
            </div>
        </nav>

		<!-- 中间展示部分  -->
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div class="header">
				<h1 class="page-header">
					删除购物车页 <small>删除</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="buyer.html">系统</a></li>
					<li><a href="buyerDeleteBuyinfoServlet">删除购物车</a></li>
					<li class="active">展示</li>
				</ol>

			</div>


			<div id="page-inner">

				<div class="row">
					<div class="col-md-12">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading">商品信息列表</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<td></td>
												<td>购物车编号</td>
												<td>用户账号</td>
												<td>商品编号</td>
												<td>购买数量（件）</td>
												<td></td>
											</tr>
										</thead>
										<%
											Vector<buyinfoDTO> v = new Vector<buyinfoDTO>();
											v = (Vector<buyinfoDTO>) session.getAttribute("cart");
											//Iterator迭代器，用于遍历容器里的对象
											Iterator it = v.iterator();
											buyinfoDTO b = null;
											while (it.hasNext())
											{
												b = (buyinfoDTO) it.next();
										%>
										<tbody>
											<tr class="odd gradeX">
											<tr>
												<td><input type="checkbox" name="check"
													value=<%=b.getBid()%>></td>
												<%-- 此处两个<%=b.getBid()%> --%>
												<td><%=b.getBid()%></td>
												<td><%=b.getAid()%></td>
												<td><%=b.getGid()%></td>
												<td><%=b.getSumnum()%></td>
												<td><a
													href="buyerDeleteBuyinfoServlet?bid=<%=b.getBid()%>&aid=<%=b.getAid()%>">删除</a></td>
											</tr>
											<%
												}
											%>
											</tr>
											</tbody>
											</table>
										
			<td>						
	<input type="button" id="btn1" value="全选" onClick="allcheck();" />
	<input type="button" id="btn2" value="不选" onClick="allnotcheck();" />
	<input type="button" id="btn3" value="反选" onClick="backcheck();" />
	<input type="button" value="批量删除" onClick="batchdelete();" />
	
								</div>
							</div>
						</div>
						<!--End Advanced Tables -->
					</div>
				</div>
			</div>
		</div>
		<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->
	<!-- /. WRAPPER  -->
	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="../assets/js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="../assets/js/bootstrap.min.js"></script>
	<!-- Metis Menu Js -->
	<script src="../assets/js/jquery.metisMenu.js"></script>
	<!-- Morris Chart Js -->
	<script src="../assets/js/morris/raphael-2.1.0.min.js"></script>
	<script src="../assets/js/morris/morris.js"></script>
	<script src="../assets/js/easypiechart.js"></script>
	<script src="../assets/js/easypiechart-data.js"></script>
	<script src="../assets/js/Lightweight-Chart/jquery.chart.js"></script>
	<!-- Custom Js -->
	<script src="../assets/js/custom-scripts.js"></script>
</body>
</html>