<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty sessionScope.loginid }">
   <a href="../loginform">login</a> 
   |  <a href="">join</a>
</c:if>
 <c:if test="${not empty sessionScope.loginid }">
    <a href="../logout">logout</a> 
 <br />
 ${sessionScope.loginid } 님, 로그인상태입니다 ദ്ദി*ˊᗜˋ*)
 </c:if>
 
<h3>상품리스트</h3>
<div class="productNormalPackage">
	<ul class="productList">
	<c:forEach items="${productlsit }" var="plist">
	<li>
		<div class="pdtthumbnail" >
			<a href="productDetail?pname=${plist.p_name }&pfilesrc=${plist.p_filesrc }">
			<img src="../resources/img/productimg/${plist.p_filesrc }.jpg" alt="" />
			</a>
		</div>
		<div class="pdtname">
			<a href="productDetail?pname=${plist.p_name }&pfilesrc=${plist.p_filesrc }">
			${plist.p_name }
			</a>
		</div>
	</li>	
	</c:forEach>
	</ul>
</div>

</body>
</html>