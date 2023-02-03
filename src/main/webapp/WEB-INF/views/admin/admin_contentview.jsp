<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<div class="jumbotron text-center">
	<h1>관리자 주문내역 상세</h1>
	<h3>관리자 주문/결제 수정</h3>
</div>
<a href="admin_olist">목록</a>
<form action="modify" method="post">
<input type="hidden" name="om_cntnum" value="${acontent_view.om_cntnum}" />
  <table width="1200" border="1">
		 <tr>
		 	<td colspan="4">주문상세</td>
		 	
		 	
		 	
		 </tr>
		 <tr>
		 	<td>주문일자</td>
		 	<td>ID</td>
		 	<td colspan="2">주문번호</td>
		 </tr>
		 <tr>
		 	<td>${acontent_view.om_date }</td>
		 	<td>${acontent_view.m_id }</td>
		 	<td colspan="2">${acontent_view.om_num }</td>
		 </tr>	
		 <tr>
		 	<td colspan="4">제품정보</td>
		 	
		 	
		 	
		 </tr>
		 <tr>
		    <td>상품주문번호</td>
		    <td>상품번호</td>
		    <td>총액</td>
		    <td>처리상태</td>
		 </tr>	 
		 <tr>
		     <td>${acontent_view.om_cntnum }</td>
		     <td>${acontent_view.p_no }</td>
		     <td>${acontent_view.p_price }</td>
		     <td>
		     <label>결제완료</label>
		     <select id="om_state" name="om_state" onchange="ChageState()">
		       <option value="" selected>-- 결제완료 --</option>
		       <option id="cancle" value="${acontent_update.om_state }">주문취소</option>	              
		     </select>
		    </td>
		 </tr>
		 <tr>
		 	<!-- <td>주문취소일자</td> -->
		 	<!-- <td>주문취소사유</td> -->
		 	<td colspan="2">주문취소승인</td>
		 </tr>
		 <tr>
		  <%-- 	<td>${acontent_view.c_date }</td> --%>
		  <!-- <td>${acontent_view.c_reason }</td> -->
		 	<td colspan="2"><input type="submit" id="admin_cancle" value="주문취소"/></td>
		 </tr>
	</table>
</form>

</body>
</html>