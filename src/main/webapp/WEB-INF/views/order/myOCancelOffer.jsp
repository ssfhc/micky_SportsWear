<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../resources/js/jquery-3.6.1.min.js"></script>
<script src="../resources/js/jquery.bpopup.min.js"></script>
</head>
<body>

<c:if test="${empty sessionScope.loginid }">
   <a href="../loginform">login</a> 
   |  <a href="">join</a>
</c:if>
<c:if test="${not empty sessionScope.loginid }">
    <a href="../logout">logout</a> 
<br />
${sessionScope.loginid } 님, 로그인상태입니다.
</c:if>
 

 <div>
	<h3>취소신청완료</h3> 	
 </div>
 

<div>
	<p class="go-myOrderList">
		<a href="../order/myOrderList">나의주문내역보기</a>
	</p>
	<p class="go-productList">
		<a href="../product/productList">상품둘러보기</a>
	</p>
</div>

</body>
</html>