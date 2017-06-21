<%@page import="model.Accommodation"%>
<%@page import="model.Reserve"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<title>memberStatistics</title>

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
					<li role="presentation"><a href="http://localhost:9080/HostelWorld/MemberInfoChangeServlet">信息修改</a></li>
					<li role="presentation"   class="active" ><a href="#">信息统计</a></li>
					<li role="presentation" style="color: red"><a
						href="http://localhost:9080/HostelWorld/IndexServlet">退出</a></li>

				</ul>
			</div>
		</div>

		<div class="col-md-8">

			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">预订信息</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							<%
	out.println("店号      房号  预定日期      入住日期<br>");																			
	ArrayList<Reserve> reserveList = (ArrayList<Reserve>) request.getSession().getAttribute("memberReserve"); 
	
	DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
	for (Reserve re:reserveList){

		String nowDate = sdf.format( re.getNowDate()); 
		String stayDate = sdf.format(re.getStayDate());
		
		out.println(re.getHostelID()+" "+re.getRoomID()+" "+nowDate
		+" "+stayDate);
		out.println("<br>");
		out.println("<br>");
		out.println("<a class=\"btn btn-default\"  href=\"");
		out.println("http://localhost:9080/HostelWorld/RemoveRegisterServlet");
		out.println("?roomID=");
		out.println(re.getRoomID());
		out.print("\"");
		out.println("\">");
		out.println("取消预约");
		out.println("</a>");
		out.print("<br>");
	}
%>
						</div>
					</div>
				</div>
			</div>
			
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">住宿信息</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							
							
							<%
							out.println("店号      房号  姓名      卡号<br>");							
							ArrayList<Accommodation> acList = (ArrayList<Accommodation>)request.getSession().getAttribute("memberAccommodation"); 
							for (Accommodation ac:acList){
								out.println(ac.getHostelID()+" "+ac.getRoomID()+" "+ac.getPersonName()+" "+ac.getCardID());
								out.println("<br>");
							}
							%>						
							
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

