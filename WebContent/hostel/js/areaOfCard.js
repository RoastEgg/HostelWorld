
	//alert("new Test");
	var myChart1 = echarts.init(document.getElementById('graph1'));
	
	var area=["南京","无锡","徐州","常州","苏州",
		"南通","连云港","淮安","盐城","扬州","镇江","泰州","宿迁"];
	var xData=[];
	var sData=[];
	
	
	$.getJSON('/HostelWorld/GetAreaOfCardServlet',function (data) {
		//System.out.println("aaaaaa");
		
		for(var i=0;i<13;i++){
            xData[i]=area[i];
            sData[i]=data[i];
        }
		var option = {
			    
		           
	        	legend: {
	                data:['城市--会员数量','城市--酒店数量']
	            },
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
	            yAxis: {},
	            series:[
	                {
	                    name:'城市--会员数量',
	                    type:'bar',
	                    data:sData
	                },
	                {
	                    name:'城市--酒店数量',
	                    type:'bar',
	                    data:["9","13","7","12","9","5","6","8","7","9","8","7","10"]
	                }
	            ]
	};
		myChart1.setOption(option);
	})
