
	//alert("new Test");
	var myChart2 = echarts.init(document.getElementById('graph2'));

	var area=["南京","无锡","徐州","常州","苏州",
		"南通","连云港","淮安","盐城","扬州","镇江","泰州","宿迁"];
	var xData=[];
	var sData=[];
	
	
	$.getJSON('/HostelWorld/GetAreaOfHostelServlet',function (data) {
		//System.out.println("aaaaaa");
		
		for(var i=0;i<13;i++){
            xData[i]=area[i];
            sData[i]=data[i];
        }
        myChart2.setOption({        //加载数据图表
        	color: ['#2E8B57'],
        	legend: {
                data:['城市--酒店数量']
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
                    name:'数量',
                    type:'bar',
                    barWidth: '60%',
                    data:sData
                }
            ]
        });

	})
