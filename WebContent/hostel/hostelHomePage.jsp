<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<title>hostelHomePage</title>

<link href="hostel/css/bootstrap.min.css" rel="stylesheet">

<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

</head>
<body>

	<div class="row container-fluid" id="navMainContainer">
		<div class="col-md-4" style="text-align: center">
			<div style="padding-left: 25%; padding-right: 25%;">
				<ul class="nav nav-pills nav-stacked " role="tablist">
					<h3>欢迎，${hostelID}</h3>
					<li role="presentation" class="active"><a href="#">客栈管理</a></li>
					<li role="presentation"><a href="http://localhost:9080/HostelWorld/HostelStatisticsServlet?hostelID='${hostelID}'">信息统计</a></li>
					<li role="presentation"><a
						href="http://localhost:9080/HostelWorld/IndexServlet">退出</a></li>

				</ul>
			</div>
		</div>

		<div class="col-md-8">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">发布计划</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							<form method='POST'
								action="<%= response.encodeURL(request.getContextPath()+"/HostelPlanPubServlet") %>">
								<input type="hidden" name="hostelID" value="${hostelID}">
								截止日期<input type="text" name="date"> 房 间 号<input
									type="text" name="roomID"> 价 格<input type="text"
									name="price">
								<button class="btn btn-default">确认</button>
							</form>
						</div>
					</div>

				</div>
			</div>
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">入店登记</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							<form method='POST'
								action="<%= response.encodeURL(request.getContextPath()+"/HostelGetinServlet") %>">
								<input type="hidden" name="hostelID" value="${hostelID}">
								房 间 号<input type="text" name="roomID">
								房 价<input type="text" name="price">
								姓 名<input type="text" name="name">
								会 员 <input type="radio" name="member" value="is">是<input type="radio" name="member" value="not">否 <br>
								会员卡号<input type="text" name="cardID">
								支付方式<input type="radio" name="payType" value="cash">现金<input type="radio" name="payType" value="card">会员卡
								<button class="btn btn-default">确认</button>
							</form>
						</div>
					</div>

				</div>
			</div>

			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">离店登记</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							<form method='POST'
								action="<%= response.encodeURL(request.getContextPath()+"/HostelGetoutServlet") %>">
								<input type="hidden" name="hostelID" value="${hostelID}">
								房 间 号<input type="text" name="roomID">
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