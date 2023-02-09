<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>search_olist</h3>
	<table width="1200" border="1">
		<tr>
			<td>상품주문번호</td>
			<td>주문번호</td>
			<td>상품번호</td>
			<td>주문수량</td>			
			<td>아이디</td>
			<td>주문일자</td>
			<td>결제형태</td>
			<td>총액</td>
			<td>처리상태</td>
			<td>주문취소요청여부</td>
			<td>주문취소일자</td>
		</tr>
		
		<c:forEach items="${slist }" var="dto">
		<tr>
<!-- 상품주문번호 -->       <td><a href="admin_contentview?om_cntnum=${dto.om_cntnum}">
									${dto.om_cntnum }</a></td> 
<!-- 주문번호 -->		    <td>${dto.om_num }</td>
<!-- 상품번호 -->			<td>${dto.p_no }</td>
<!-- 주문수량 -->			<td>${dto.u_cnt }</td>			
<!-- 아이디 -->			<td>${dto.m_id }</td>
<!-- 주문일자 -->			<td><fmt:formatDate value="${dto.om_date }" pattern="yyyy-MM-dd"/></td>
<!-- 결제형태 -->			<td>${dto.om_pay }</td>
<!-- 총액 -->			    <td>${dto.p_price }</td>
<!-- 처리상태 -->			<td>${dto.om_state }</td>
<!-- 주문취소요청여부 -->		<td>${dto.om_cancle }</td>
<!-- 주문취소일자 -->		<td><fmt:formatDate value="${dto.om_cdate }" pattern="yyyy-MM-dd"/></td>
		</tr>	
		</c:forEach>
	
	</table>	
</body>
</html>