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
		
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">统计分析</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
														
							<button  class="btn btn-default">每个月订单的总金额</button>
							<div id="graph1" style="width: 800px;height:400px;"></div>
							
						 	<button  class="btn btn-default">每个月订单的平均金额</button>
							<div id="graph2" style="width: 800px;height:400px;"></div>
							
							<button  class="btn btn-default">最近一周的订单</button>
							
							<table class="table table-striped table-hover table-condensed" style="width: 800px;">
                            <thead>
                            <tr>
                                <th  style="font-size: 25px;">房间号</th>
                                <th  style="font-size: 25px;">会员卡号</th>
                                <th  style="font-size: 25px;">日期</th>
                                <th  style="font-size: 25px;">价格</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td style="font-size: 20px;">001</td>
                                <td style="font-size: 20px;">1000002</td>
								<td style="font-size: 20px;">2017-06-20</td>
								<td style="font-size: 20px;">150</td>
                            </tr>
                            <tr>
                                <td style="font-size: 20px;">008</td>
                                <td style="font-size: 20px;">1000092</td>
								<td style="font-size: 20px;">2017-06-19</td>
								<td style="font-size: 20px;">280</td>								
                            </tr>
							<tr>
                                <td style="font-size: 20px;">017</td>
                                <td style="font-size: 20px;">1000085</td>
								<td style="font-size: 20px;">2017-06-19</td>
								<td style="font-size: 20px;">360</td>								
                            </tr>
							<tr>
                                <td style="font-size: 20px;">029</td>
                                <td style="font-size: 20px;">1000083</td>
								<td style="font-size: 20px;">2017-06-19</td>
								<td style="font-size: 20px;">180</td>								
                            </tr>
							<tr>
                                <td style="font-size: 20px;">016</td>
                                <td style="font-size: 20px;">1000074</td>
								<td style="font-size: 20px;">2017-06-19</td>
								<td style="font-size: 20px;">260</td>								
                            </tr>
							<tr>
                                <td style="font-size: 20px;">017</td>
                                <td style="font-size: 20px;">1000003</td>
								<td style="font-size: 20px;">2017-06-18</td>
								<td style="font-size: 20px;">340</td>								
                            </tr>
							<tr>
                                <td style="font-size: 20px;">021</td>
                                <td style="font-size: 20px;">1000085</td>
								<td style="font-size: 20px;">2017-06-18</td>
								<td style="font-size: 20px;">410</td>								
                            </tr>
							<tr>
                                <td style="font-size: 20px;">039</td>
                                <td style="font-size: 20px;">1000085</td>
								<td style="font-size: 20px;">2017-06-17</td>
								<td style="font-size: 20px;">120</td>								
                            </tr>
                            </tbody>
                        </table>
							
							
						</div>
					</div>
				</div>
			</div>
		
		
		
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
    <script src="hostel/js/echarts.min.js"></script>
    
	<script src="hostel/js/sumOfMoney.js"></script>
	<script src="hostel/js/averageOfMoney.js"></script>
	
	
</body>
</html>