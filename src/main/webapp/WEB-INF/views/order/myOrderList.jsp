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
<h3>나의 주문내역</h3>
<table width="800" border="1">
	<tr>
		<td>상품주문번호</td>
		<td>주문번호</td>
		<td>주문수량</td>
		<td>주문일자</td>
		<td>결제형태</td>
		<td>총액</td>
		<td>상품번호</td>
	</tr>
	<c:forEach items="${omdList }" var="dto">
	<tr>
		<td>${dto.om_cntnum }</td>
 		<td>${dto.om_num }</td>
		<td>${dto.u_cnt }</td>
		<td>${dto.om_date }</td>
		<td>${dto.om_pay }</td>
		<td>${dto.p_price }</td> 
		<td>${dto.p_no }</td> 
	</tr>
	</c:forEach>
</table>
</body>
</html>