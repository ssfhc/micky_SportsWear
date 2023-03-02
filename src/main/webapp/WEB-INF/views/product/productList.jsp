<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nanum+Gothic&family=Noto+Sans+KR:wght@900&family=UnifrakturCook&display=swap" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/pstyle.css" />
</head>
<body>
<!--@@@ header @@@-->
<jsp:include page="/WEB-INF/views/header.jsp" />



<!--@@@ aside @@@-->
<jsp:include page="/WEB-INF/views/aside.jsp" />


<div class="productNormalPackage">
<ul class="productList">
<c:forEach items="${productlsit}" var="plist">
	<li>
		<div class="pdtthumbnail" >
			<a href="productDetail?pname=${plist.p_name }&pfilesrc=${plist.p_filesrc}">
			<img src="../resources/img/productimg/${plist.p_filesrc}.jpg" alt="" />
			</a>
		</div>
		<div class="pdtname">
			<a href="productDetail?pname=${plist.p_name}&pfilesrc=${plist.p_filesrc}">
			${plist.p_name}
			</a>
		</div>
		<div class="pdtprice">
			<p><fmt:formatNumber value="${plist.p_price}" pattern="###,###"/>원</p>
		</div>
	</li>	
</c:forEach>
</ul>
</div>

</body>

<!--@@@ footer @@@-->
<jsp:include page="/WEB-INF/views/footer.jsp" />

</html>