
	//alert("new Test");
	var myChart4 = echarts.init(document.getElementById('graph4'));	
	
	$.getJSON('/HostelWorld/GetAreaOfHostelServlet',function (data) {

		var option = {
			    title: {
			        text: '市场占有率'
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['占有率%']
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    toolbox: {
			        feature: {
			            saveAsImage: {}
			        }
			    },
			    xAxis: {
			        type: 'category',
			        boundaryGap: false,
			        data: ['1月','2月','3月','4月','5月','6月']
			    },
			    yAxis: {
			        type: 'value'
			    },
			    series: 
			        {
			            name:'占有率%',
			            type:'line',
			            stack: '总量',
			            data:["21","41","37","19","48","56"]
			        }
			};
		myChart4.setOption(option);
	})
