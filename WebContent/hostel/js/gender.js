
	var myChart3 = echarts.init(document.getElementById('graph3'));
	
	var option = {
		    backgroundColor: '#2c343c',

		    title: {
		        text: '性别比例饼状图',
		        left: 'center',
		        top: 20,
		        textStyle: {
		            color: '#ccc'
		        }
		    },

		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },

		    visualMap: {
		        show: false,
		        min: 80,
		        max: 600,
		        inRange: {
		            colorLightness: [0, 1]
		        }
		    },
		    series : [
		        {
		            name:'性别比例',
		            type:'pie',
		            radius : '65%',
		            center: ['50%', '50%'],
		            data:[
		                {value:400, name:'男'},
		                {value:355, name:'女'},
		            ].sort(function (a, b) { return a.value - b.value; }),
		            roseType: 'radius',
		            label: {
		                normal: {
		                    textStyle: {
		                        color: 'rgba(255, 255, 255, 0.3)'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    lineStyle: {
		                        color: 'rgba(255, 255, 255, 0.3)'
		                    },
		                    smooth: 0.2,
		                    length: 10,
		                    length2: 20
		                }
		            },
		            itemStyle: {
		                normal: {
		                    color: '#c23531',
		                    shadowBlur: 200,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            },

		            animationType: 'scale',
		            animationEasing: 'elasticOut',
		            animationDelay: function (idx) {
		                return Math.random() * 200;
		            }
		        }
		    ]
		};
	myChart3.setOption(option);
	