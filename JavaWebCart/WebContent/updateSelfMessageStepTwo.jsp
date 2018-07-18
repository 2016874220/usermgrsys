<!-- ������import -->
<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,com.lingnan.umssys.common.constant.userBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>��Ʒ����ϵͳ</title>
<!-- Bootstrap Styles-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->
<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet"
	href="assets/js/Lightweight-Chart/cssCharts.css">
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
			<a class="navbar-brand" href="###"><strong>��Ʒ����ϵͳ</strong></a>
		</div>

		<!--���Ͻ�������-->
		<ul class="nav navbar-top-links navbar-right">
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" aria-expanded="false"> <i
					class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="updateSelfMessageServlet"><i class="fa fa-sign-out fa-fw"></i>�޸ĸ�����Ϣ</a>
					<li><a href="logoutServlet"><i
							class="fa fa-sign-out fa-fw"></i>�˳�</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		</nav>

		<!-- ��ർ���� -->
		<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
				<li><a href="###"><i
						class="fa fa-table"></i>��Ʒ��Ϣ</a></li>
				<li><a href="###"><i class="fa fa-edit"></i>������Ʒ</a></li>
				<li><a href="###"><i class="fa fa-edit"></i>ɾ����Ʒ</a></li>
				<li><a href="###"><i
						class="fa fa-edit"></i>�޸���Ʒ��Ϣ</a></li>
				<li><a href="###"><i
						class="fa fa-desktop"></i>�鿴�˿͹������</a></li>
			</ul>
		</div>
		</nav>

		<!-- �м�չʾ����  -->
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div class="header">
				<h1 class="page-header">
					�޸ĸ�����Ϣҳ <small>�޸�</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="###">ϵͳ</a></li>
					<li><a href="updateSelfMessageServlet">�޸ĸ�����Ϣ</a></li>
					<li class="active">չʾ</li>
				</ol>
			</div>

			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading">������Ϣ</div>
							<div class="panel-body">
								<div class="table-responsive">
									<form action="updateSelfMessageStepTwoServlet">
										<table class="table table-striped table-bordered table-hover"
											id="dataTables-example">
											<thead>
												<tr>
													<th>�˺�</th>
													<th>�û���</th>
													<th>����</th>
													<th></th>
												</tr>
											</thead>
											<%
												String aid = request.getParameter("aid");
																														Vector<userBean> v = new Vector<userBean>();
																														v = (Vector<userBean>)session.getAttribute("user");
																														//Iterator�����������ڱ���������Ķ���
																														Iterator it = v.iterator();
																														userBean a = null;
																														while(it.hasNext())
																														{
																															a = (userBean)it.next();
																															if((a.getAid()).equals(aid))
																															{
											%>
											<tbody>
												<tr class="odd gradeX">
												<tr>
													<!-- aid�����޸ģ���aid����Ӧ�ı��򲻿��޸� -->
													<td><input type="text" name="aid"
														value=<%=a.getAid()%> readonly="readonly"></td>
													<td><input type="text" name="aname"
														value=<%=a.getAname()%>></td>
													<td><input type="text" name="password"
														value=<%=a.getPassword()%>></td>
													<td><input type="submit" value="ȷ���޸�"></td>
												</tr>
												<%
													}
													}
												%>
												</tr>
											</tbody>
										</table>
									</form>
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
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="assets/js/bootstrap.min.js"></script>

	<!-- Metis Menu Js -->
	<script src="assets/js/jquery.metisMenu.js"></script>
	<!-- Morris Chart Js -->
	<script src="assets/js/morris/raphael-2.1.0.min.js"></script>
	<script src="assets/js/morris/morris.js"></script>


	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>

	<script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>

	<!-- Custom Js -->
	<script src="assets/js/custom-scripts.js"></script>

	<script>
		
	</script>
</body>
</html>