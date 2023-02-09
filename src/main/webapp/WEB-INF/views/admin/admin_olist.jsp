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

<div class="jumbotron text-center">
	<h1>관리자 admin_olist</h1>
	<p>주문관리 현황 리스트</p>
</div>
<br /><br />


<!-- 주문취소 목록 검색 기능 : 시작날짜~종료날짜+취소요청Y 기준 -->
<form action="search_olist" method="post">
	<div>
		<label>
			검색시작일 : 
			<input type="date" name="som_cdate" required pattern="\d{4}-\d{2}-\d{2}" value="som_cdate" />
		</label>
		<label>&nbsp;
			검색종료일 : 
 		<input type="date" name="eom_cdate" required pattern="\d{4}-\d{2}-\d{2}" value="eom_cdate" />
		</label>&nbsp;&nbsp;
	        <label>주문취소요청여부</label>
	    	<input type="text" name="om_cancle" value="${resk }" placeholder="검색어를 입력해주세요"/> 
		    <input type="submit" value="조회"/>
		
<%-- 	 	<c:choose>
			<c:when test="${om_cancle }">
				<input type="checkbox" name="searchType" value="om_cancle1" checked/>
			</c:when>
			<c:otherwise>
				<input type="checkbox" name="searchType" value="om_cancle1" />Y
			</c:otherwise>
		</c:choose> 
		<c:choose>
			<c:when test="${om_cancle }">
				<input type="checkbox" name="searchType" value="om_cancle2" checked/>
			</c:when>
			<c:otherwise>
				<input type="checkbox" name="searchType" value="om_cancle2" />N
			</c:otherwise>
		</c:choose>  --%>
		
	</div>
</form>
<br />


<div class="container">
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
		
		<c:forEach items="${olist }" var="dto">
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
</div>


<br /><br />
<!-- 페이지 처리 -->
	<c:if test="${searchVo.page > 1 }">
		<a href="admin_olist?page=1">[처음]</a>
		<a href="admin_olist?page=${searchVo.page-1 }">[이전]</a>
	</c:if>
	
	<c:forEach begin="${searchVo.pageStart }" end="${searchVo.pageEnd }" var="i">
		<c:choose>
			<c:when test="${i eq searchVo.page }">
				<span style="color: red; font-weight:bold">${i }&nbsp;</span>
			</c:when>
			<c:otherwise>
				<a href="admin_olist?page=${i }" style="text-decoration: none;">${i }&nbsp;</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${searchVo.page < searchVo.totPage }">
		<a href="admin_olist?page=${searchVo.page+1 }">[다음]</a>
		<a href="admin_olist?page=${searchVo.totPage }">[마지막]</a>
	</c:if>


</body>
</html>