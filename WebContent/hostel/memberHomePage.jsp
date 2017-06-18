<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<title>memberHomePage</title>

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
					<li role="presentation" class="active"><a href="#">会员操作</a></li>
					<li role="presentation"><a href="http://localhost:9080/HostelWorld/MemberInfoChangeServlet">信息修改</a></li>
					<li role="presentation"><a href="http://localhost:9080/HostelWorld/MemberStatisticsServlet">信息统计</a></li>
					<li role="presentation"><a
						href="http://localhost:9080/HostelWorld/IndexServlet">退出</a></li>

				</ul>
			</div>
		</div>

		<div class="col-md-8">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">充值激活</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							<form method='POST'
								action="<%= response.encodeURL(request.getContextPath()+"/MemberRechargeServlet") %>">
								充值金额<input type="text" name="number"> <input
									type="hidden" name="cardID" value="${cardID}">
								<button type="submit" class="btn btn-default">确认</button>

							</form>
						</div>
					</div>
				</div>
			</div>

			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">预订房间</h3>
				</div>
				<div class="panel-body">
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							<form method='POST'
								action="<%= response.encodeURL(request.getContextPath()+"/MemberReserveServlet") %>">
								酒店号：<input type="text" name="hostelID">
								 房间号：<input type="text" name="roomID">
								 <input type="hidden" name="cardID" value="${cardID}">
								住店日期<input type="text" name="stayDate">	
								<button type="submit" class="btn btn-default">确认</button>
							</form>
						</div>
					</div>


				</div>
			</div>

			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">资格取消</h3>
				</div>
				<div class="panel-body">
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">

							<form method='POST'
								action="<%= response.encodeURL(request.getContextPath()+"/StopQuaServlet") %>">
								<input type="hidden" name="cardID" value="${cardID}">
								<button type="submit" class="btn btn-default">放弃资格</button>
							</form>

						</div>
					</div>
				</div>
			</div>

			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">等级优惠</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							<p>消费至1000元可享9折优惠 
							   <br>消费至2000元可享8折优惠
							   <br>消费至3000元可享7折优惠
							  </p>
						</div>
					</div>
				</div>

			</div>
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">积分查看</h3>
				</div>
				<div class="panel-body">
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							<p>当前积分${consumption}</p>
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