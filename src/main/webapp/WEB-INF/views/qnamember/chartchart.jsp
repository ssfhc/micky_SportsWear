<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> <!-- 3.x.x 버전 - 가장 최신 버전, 아작스를 지원 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.0/dist/chart.min.js"></script>
</head>
<body>
<div class="container">
	<div class="col-md-6">
		<canvas id="myChart" width="400" height="400"></canvas>
	</div>
</div>
<script>

	
			const ctx = document.getElementById('myChart').getContext('2d');
			const myChart = new Chart(ctx,{ //위에 가져온 차트 구조를 맞춰준다
				type:'bar',
				data:{
					labels:['총회원수','남성','여성','Green','Purple','Orange'],
					datasets:[{
						//label:'회원수',
						data:['${totalMember}','${maleMember}','${femaleMember}'],
						backgroundColor:[
							 'rgba(255, 99, 132, 1.0)',
				                'rgba(54, 162, 235, 0.2)',
				                'rgba(255, 206, 86, 0.2)',
				                'rgba(75, 192, 192, 1.0)',
				                'rgba(153, 102, 255, 0.2)',
				                '#0000ff'

						],
						borderColor: [
			                'rgba(255, 99, 132, 1)',
			                'rgba(54, 162, 235, 1)',
			                'rgba(255, 206, 86, 1)',
			                'rgba(75, 192, 192, 1)',
			                'rgba(153, 102, 255, 1)',
			                'rgba(255, 159, 64, 1)'
			            ],

						borderWidth:3
					}]
				},
				options:{
					scales:{
						y:{
							beginAtZero:true
						}
					}
				}
			}
					
			);
			
		
</script>
<h3>chartchart.jsp</h3>
<h1>차트만들어보기</h1>
<input type="hidden" id="totalMember" value="${totalMember}" />
</body>
</html>