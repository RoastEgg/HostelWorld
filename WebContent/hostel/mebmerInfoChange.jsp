<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<title>memberInfoChange</title>

<link href="hostel/css/bootstrap.min.css" rel="stylesheet">

<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

</head>
<body>

	<div class="row container-fluid" id="navMainContainer">
		<div class="col-md-4" style="text-align: center">
			<div style="padding-left: 25%; padding-right: 25%;">
				<ul class="nav nav-pills nav-stacked " role="tablist">
					<h3>欢迎，${cardID}</h3>
					<h3>资格，${cardIsActive}</h3>
					<li role="presentation"><a href="http://localhost:9080/HostelWorld/MemberRechargeServlet">会员操作</a></li>
					<li role="presentation"  class="active" ><a href="#">信息修改</a></li>
					<li role="presentation"><a href="http://localhost:9080/HostelWorld/MemberStatisticsServlet">信息统计</a></li>
					<li role="presentation" style="color: red"><a
						href="http://localhost:9080/HostelWorld/IndexServlet">退出</a></li>

				</ul>
			</div>
		</div>

		<div class="col-md-8">

			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">修改信息</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							<form method='POST' action="<%= response.encodeURL(request.getContextPath()+"/MemberCardIDChangeServlet") %>">
								设置新的银行卡号：<input type="text">
								<button class="btn btn-default">确认</button>
							</form>
                        	<form method='POST' action="<%= response.encodeURL(request.getContextPath()+"/MemberPwdChangeServlet") %>">	
								<br> 设置新密码：<input type="text">
								<button class="btn btn-default">确认</button>

							</form>
						</div>
					</div>


				</div>


			</div>




		</div>

	</div>


	<script src="hostel/js/jquery-3.1.0.min.js"></script>
	<script src="hostel/js/bootstrap.min.js"></script>



</body>
</html>

