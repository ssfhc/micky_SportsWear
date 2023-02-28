<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nanum+Gothic&family=Noto+Sans+KR:wght@900&family=UnifrakturCook&display=swap" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/pchartstyle.css" />
</head>
<body>

<c:if test="${empty sessionScope.loginid }">
   <a href="../member/loginform">login</a> 
   |  <a href="../member/joinform">join</a>

</c:if>
 <c:if test="${not empty sessionScope.loginid }">
    <a href="../member/logout">logout</a> 
 <br />
 ${sessionScope.loginid } 님, 로그인상태입니다.
	 <div>
		<p class="go-myOrderList" style="color: #336666;">
		<a href="../member/mypageform">마이페이지로</a>
		</p>
	</div>
 </c:if>
 
 <!-- 로그인 상태라면 나의 주문내역보기 가능 -->

<h3>판매량 top5</h3>
<div class="productChartPackage">

<h4>현재시간 top5</h4>
<ul class="productChart">
<c:forEach items="${pdtTimeChart }" var="pTChart">
	<li>
		<div class="pdtthumbnail">
			<a href="productDetail?pname=${pTChart.p_name }&pfilesrc=${pTChart.p_filesrc }">
			<img src="../resources/img/productimg/${pTChart.p_filesrc }.jpg" alt="" />
			</a>
		</div>
		<div class="pdtdetail">
			<p class="pname">
			<a href="productDetail?pname=${pTChart.p_name }&pfilesrc=${pTChart.p_filesrc }">
			${pTChart.p_name}
			</a>
			</p>
			<p class="pcolor">
				<span>${pTChart.p_color}</span>
			</p>
			<p class="pprice">
				<span><fmt:formatNumber value="${pTChart.p_price}" pattern="###,###"/>원</span>
			</p>
		</div>
	</li>	
</c:forEach>
</ul>
<h4>전체상품 top5</h4>
<ul class="productChart">
<c:forEach items="${productChart }" var="pChart">
	<li>
		<div class="pdtthumbnail">
			<a href="productDetail?pname=${pChart.p_name }&pfilesrc=${pChart.p_filesrc }">
			<img src="../resources/img/productimg/${pChart.p_filesrc }.jpg" alt="" />
			</a>
		</div>
		<div class="pdtdetail">
			<p class="pname">
			<a href="productDetail?pname=${pChart.p_name }&pfilesrc=${pChart.p_filesrc }">
			${pChart.p_name}
			</a>
			</p>
			<p class="pcolor">
				<span>${pChart.p_color}</span>
			</p>
			<p class="pprice">
				<span>${pChart.p_price}</span>
			</p>
		</div>
	</li>	
</c:forEach>
</ul>

</div>


</body>
</html>