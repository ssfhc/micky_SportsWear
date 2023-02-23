<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Micky Sports Wear</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
<!-- 반응형 setting -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
header{
background-color: #CCCCCC;
height: 200px;
position: fixed; width: 100%
}
.top_ul{
list-style-type: none;
font-family: 'Noto Sans KR', sans-serif;
float: right; 			/* top메뉴 우측정렬 */
margin: 30px 30px 5px 0px;  /* [위] [오른쪽] [아래] [왼쪽] */
border: 1px solid black;
}
.top_ul li {
	display: inline; 	/* ※float Χ */
	font-size: 15px;
	border-left: 1px solid black;
	padding: 0px 10px 0px 10px; 
	margin: 10px 0px 5px 0px; /* [위] [오른쪽] [아래] [왼쪽] */
}
.top_ul li:first-child{
 border-left: none; 	/* home 영역 좌측 테두리만 제거 */
}
.top_ul li a{
	text-decoration: none;
	color: black;
}
.top_ul li a:hover{
	text-decoration: underline;
	color: black; font-weight: bold;
}
.main_ul{
	list-style-type: none;
	font-family: 'Noto Sans KR', sans-serif;
	float: right;
	margin: 0px 100px 5px 0px; /* [위] [오른쪽] [아래] [왼쪽] */
	border: 1px black solid;
}
.main_ul li{
	display: inline;
	font-size: 20px;
	padding: 0px 60px 0px 60px; 
}
.main_ul li a{
	text-decoration: none;
	color: black;
}
.main_ul li:hover{
	text-decoration: underline;
	background-color: white;
	color: black; font-weight: bold;
}


/* h1+logo */
.header-wrap1{
	display: flex;
	flex-direction: row-reverse;
	justify-content: space-between;
	padding: 10px 90px 10px 80px;  /* [위] [오른쪽] [아래] [왼쪽] */
	border: 1px solid black;
}

.header-h1{
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 50px;
	text-align: center;	
	border: 1px solid black;
	margin-right: 500px;
	padding: 1px 0px 0px 5px;
	
}

.head-logo{
	border: 1px solid black;
	margin-bottom: 10px;
}

/* icon */
.home{
width: 20px;
height: 15px;

}
.logout{
width: 20px;
height: 15px;

}
.my{
width: 20px;
height: 18px;

}
</style>

</head>

<body>
<header>
   		<ul class="top_ul">
	   		<li class="top_li1"><a href="#"><img class="home" src="resources/img/admin/admin_home_icon.png">home</a></li>
	   		<li class="top_li2"><a href="#"><img class="logout" src="resources/img/admin/admin_logout_icon.png">logout</a></li>
	   		<li class="top_li3"><a href="#"><img class="my" src="resources/img/admin/admin_mypage_icon.png">My admin page</a></li>
   		</ul>
   		
		<div class="header-wrap1">
		<h1 class="header-h1">Admin Home</h1>	
		<img class="head-logo" 
 		src="resources/img/admin/mickylogo_icon.png">
 		</div>
 			
    	<ul class="main_ul">
	      <li class="main_li1"><a href="#">회원관리</a></li>
	      <li class="main_li2"><a href="#">상품관리</a></li>
	      <li class="main_li3"><a href="#">주문관리</a></li>
	      <li class="main_li4"><a href="#">chart</a></li>
    	</ul>	
</header>

</body>
</html>