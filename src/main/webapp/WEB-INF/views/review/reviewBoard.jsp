<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/reviewstyle.css" />
</head>
<body>
<h3>Reviewboard</h3>

<div class="review_table">

<!-- core태그 사용 -->
<c:forEach items="${review_list }" var="list">
	<div class="row">
		<div class="cell col1">
			<div class="review_total">
				<div class="review_box">
					<div class="review_label">
						<input type="hidden" value="${list.r_no }" />
						<p>${list.r_title }</p>
						<p class="user_date">
							<span>★★★★★</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>${list.m_id }</span>
						</p>
						<div class="product_option">
							<strong>구매옵션</strong>&nbsp;<span>색상</span>&nbsp;<span>사이즈</span>
						</div>
						<div class="user_content"> <!-- commend -->
							<p>${list.r_content }</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="cell col2">
			<div class="img_box">
				<img src="../resources/img/icon_reply.gif" alt="그린 클리프 반팔 라운드티" />
			</div>
			<div>
				<%-- <span>${list.r_date }</span> --%>
				<span><fmt:formatDate value="${list.r_date }" pattern="yyyy.MM.dd"/></span>
			</div>
		</div>
	</div>
</c:forEach>
</div>
<a href="reviewWriteview">리뷰 쓰기</a>
</body>
</html>