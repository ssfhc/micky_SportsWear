<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html lang="ko">

<style>
.dropdown:hover .dropdown-menu {
    display: block;
    margin-top: 0;
/*     border: 10px solid red; */
    width: 1000px; 
    
}
.dropdown-menu{
/* 	width: 1000px; */
	 position: relative;
	 margin: auto;
}
</style>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>header</title>
</head>
<body>
	<h1>micky_SportsWear</h1>
	<h1>
		<a href="main">메인화면</a>
	</h1>
	<div>
		<a href="product/productList">전체상품리스트</a>
 		<a href="review/reviewBoard">리뷰</a>
		<a href="Cart/before">장바구니</a> 
		<a href="admin_olist">관리자상품구매리스트</a>
		<a href="member/loginform">로그인</a>
		<a href="admin_product">관리자상품관리</a>
	</div>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li class="dropdown"><a href="#">남성</a>
        	<ul class="dropdown-menu">
				<li><a href="#">자캣&조끼</a>
					<ul>
						<li><a href="#">조끼</a></li>
						<li><a href="#">가디건</a></li>
					</ul>
				</li>
				<li><a href="#">셔츠</a>
					<ul>
						<li><a href="#">라운드티</a></li>
						<li><a href="#">후디</a></li>
						<li><a href="#">셔츠</a></li>
					</ul>
				</li>
				<li><a href="#">바지</a>
					<ul>
						<li><a href="#">트레이닝/조거팬츠</a></li>
						<li><a href="#">레깅스</a></li>
					</ul>
				</li>
			</ul>  
        </li>
        <li class="dropdown"><a href="#">여성</a>    	
        	<ul class="dropdown-menu">
				<li><a href="#">자캣&조끼</a>
					<ul>
						<li><a href="#">조끼</a></li>
						<li><a href="#">가디건</a></li>
					</ul>
				</li>
				<li><a href="#">셔츠</a>
					<ul>
						<li><a href="#">라운드티</a></li>
						<li><a href="#">후디</a></li>
						<li><a href="#">셔츠</a></li>
					</ul>
				</li>
				<li><a href="#">바지</a>
					<ul>
						<li><a href="#">트레이닝/조거팬츠</a></li>
						<li><a href="#">레깅스</a></li>
					</ul>
				</li>
			</ul>  
        </li>
        <li class="dropdown"><a href="#">가방&용품</a>
        	<ul class="dropdown-menu">
				<li><a href="#">기타용품</a>
					<ul>
						<li><a href="#">양말</a></li>
						<li><a href="#">마스크</a></li>
					</ul>
				</li>
				<li><a href="#">모자</a>
					<ul>
						<li><a href="#">CAP</a></li>
					</ul>
				</li>
			</ul>  
        </li>
       
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="상품검색">
        </div>
        <button type="submit" class="btn btn-default">검색</button>
      </form>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
	
													

</body>
</html>
