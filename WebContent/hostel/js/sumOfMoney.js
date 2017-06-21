
	var myChart1 = echarts.init(document.getElementById('graph1'));
	
	var month=["1月","2月","3月","4月","5月","6月"];
	//var xData=[];
	var sData=[];
	
	
	$.getJSON('/HostelWorld/GetSumOfMoneyServlet',function (data) {
		//System.out.println("aaaaaa");
		
		for(var i=0;i<6;i++){
           // xData[i]=month[i];
            sData[i]=data[i];
        }
		var option = {
			    title: {
			        text: '每月销售总额'
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['每月小结']
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
			            name:'每月小结',
			            type:'line',
			            stack: '总量',
			            data:sData
			        }
			};
		myChart1.setOption(option);
	})
