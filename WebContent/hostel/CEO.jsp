<%@page import="model.Accommodation"%>
<%@page import="model.Hostel"%>
<%@page import="model.Reserve"%>
<%@page import="model.Room"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<title>CEOHomePage</title>

<link href="hostel/css/bootstrap.min.css" rel="stylesheet">

<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

</head>
<body >

	<div class="row container-fluid" id="navMainContainer">
		<div class="col-md-4" style="text-align: center">
			<div style="padding-left: 25%; padding-right: 25%;">
				<ul class="nav nav-pills nav-stacked " role="tablist">
					<h3>欢迎，大BOOS</h3>
					<li role="presentation" class="active"><a href="#">企业管理</a></li>
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
							
							<button  class="btn btn-default">会员性别比例</button>													
							<div id="graph3" style="width: 800px;height:400px;"></div>							
							
							<button  class="btn btn-default">会员年龄比例</button>													
							<div id="graph5" style="width: 800px;height:400px;"></div>							
							
														
							<button  class="btn btn-default">会员的地区分布</button>													
							<div id="graph1" style="width: 800px;height:400px;"></div>
							
					   <!-- <button  class="btn btn-default">酒店的地区分布</button>													
							<div id="graph2" style="width: 800px;height:400px;"></div>
						-->	
							<button  class="btn btn-default">市场占有率</button>													
							<div id="graph4" style="width: 800px;height:400px;"></div>
							
							
						</div>
					</div>
				</div>
			</div>
		
		
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">开店申请</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							
					    <%
						out.println("店号 申请<br>");																			
						ArrayList<Hostel> applyList = (ArrayList<Hostel>) request.getSession().getAttribute("CEOHostelApply"); 
						if (applyList!=null){
							for (Hostel ho:applyList){
								out.println(ho.getId()+" "+ho.getApply());
								out.println("<br>");
							}
						}

					    %> 

			<form style="align-content: center" method='POST' action="<%= response.encodeURL(request.getContextPath()+"/ApproveServlet") %>">
			<input type="hidden" name="type" value="hostelApply">
			<button class="btn btn-default">审批</button>
			</form>								
						</div>
					</div>
				</div>
			</div>
			
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">房间计划</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							
														<%
	out.println("店号 房间号 价格<br>");																			
	ArrayList<Room> roomList = (ArrayList<Room>) request.getSession().getAttribute("CEORoomApply"); 
	if (roomList!=null){
		for (Room ro:roomList){
			out.println(ro.getHostelID()+" "+ro.getId()+" "+ro.getPrice());
			out.println("<br>");
		}
	}

%>
			<form style="align-content: center" method='POST' action="<%= response.encodeURL(request.getContextPath()+"/ApproveServlet") %>">
			<input type="hidden" name="type" value="roomApply">
			<button class="btn btn-default">审批</button>
			</form>											
						</div>
					</div>
				</div>
			</div>
		
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">预订信息</h3>
				</div>
				<div class="panel-body">

					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							
														<%
	out.println("会员号    店号  房号  预定日期      入住日期<br>");																			
	ArrayList<Reserve> reserveList = (ArrayList<Reserve>) request.getSession().getAttribute("CEOReserve"); 
	
	if (reserveList!=null){
		
		DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		for (Reserve re:reserveList){
			
			String nowDate = sdf.format( re.getNowDate()); 
			String stayDate = sdf.format(re.getStayDate());
			out.println(re.getCardID()+" "+re.getHostelID()+" "+re.getRoomID()+" "+nowDate
			+" "+stayDate);
			
		}
		
		
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
					//		ArrayList<Accommodation> acList = (ArrayList<Accommodation>)request.getSession().getAttribute("CEOAccommodation"); 
				    //		if (acList!=null){
					//			for (Accommodation ac:acList){
					//				out.println(ac.getHostelID()+" "+ac.getRoomID()+" "+ac.getPersonName()+" "+ac.getCardID());
					//				out.println("<br>");
					//		}
					//		}
							%>							
							
						</div>
					</div>
				</div>
			</div>



		</div>


	</div>


	<script src="hostel/js/jquery-3.1.0.min.js"></script>
	<script src="hostel/js/bootstrap.min.js"></script>
	<script src="hostel/js/echarts.min.js"></script>
	
	
	<script src="hostel/js/areaOfCard.js"></script>
	<script src="hostel/js/areaOfHostel.js"></script>
	<script src="hostel/js/gender.js"></script>
	<script src="hostel/js/marketOccupancy.js"></script>
	<script src="hostel/js/age.js"></script>
	
	
<!--<script>
function showArea(){
	alert("sgersvrdf");
	var xData;
	var sData;
	//调用Ajax 
    var myChart = echarts.init(document.getElementById('graph1'));
    var area=["南京","无锡","徐州","常州","苏州",
			"南通","连云港","淮安","盐城","扬州","镇江","泰州","宿迁"];
	
	$.ajax({
	    type : "POST",
	    async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
	    url : "/GetDataServlet",    //请求发送
	    
	    dataType : "JSON",        //返回数据形式为json
	    success : function(result) {
	        //请求成功时执行该函数内容，result即为服务器返回的json对象
	        //在此将数据 
	        if (result) {
	            for(var i=0;i<13;i++){
	                xData[i]=area[i];
	                sData[i]=result[i];
	            }
	            myChart.hideLoading();    //隐藏加载动画
	            myChart.setOption({        //加载数据图表
	                xAxis : [
	                    {
	                        type : 'category',
	                        axisTick: {
	                            alignWithLabel: true
	                        },
	                        data: xData,
	                        name: '城市'
	                    }
	                ],
	                series:[
	                    {
	                        name:'数量',
	                        type:'bar',
	                        barWidth: '60%',
	                        data:sData
	                    }
	                ]
	            });

	       }

	    },
	    error : function(errorMsg) {
	        //请求失败时执行该函数
	        alert("图表请求数据失败!");
	        myChart.hideLoading();
	    }
	});

}

</script>-->

</body>
</html>