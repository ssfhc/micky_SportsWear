<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta content="IE=edge" http-equiv="X-UA-Compatible">
  <meta content="width=device-width,initial-scale=1" name="viewport">
  <meta content="Page description" name="description">
  <meta name="google" content="notranslate" />
  <meta content="Mashup templates have been developped by Orson.io team" name="author">

  <!-- Disable tap highlight on IE -->
  <meta name="msapplication-tap-highlight" content="no">
  
  <link href="../resources/img/myPage/myP-icon.png" rel="myP-icon">
  <link href="../resources/img/myPage/favicon.ico" rel="icon">



  <title>Title page</title>  

<link href="../resources/css/checkIndex.css" rel="stylesheet">
</head>

<body>



<!-- Add your content of header -->
<header class="">
  <div class="navbar navbar-default visible-xs">
    <button type="button" class="navbar-toggle collapsed">
      <span class="sr-only">Toggle nav</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a href="../myPage/checkIndex" class="navbar-brand">MICKY</a>
  </div>

  <nav class="sidebar">
    <div class="navbar-collapse" id="navbar-collapse">
      <div class="site-header hidden-xs">
          <a class="site-brand" href="../myPage/checkIndex" title="">
            <img class="img-responsive site-logo" alt="" src="../resources/img/myPage/mashup-logo.svg">
            MICKY SHOP
          </a>
        <p>마이페이지</p>
        <div class="loginJoin-box">
<c:if test="${empty sessionScope.loginid}">
   <a href="../member/loginform">login</a> 
   |  <a href="../member/joinform">join</a>

로그인이 필요합니다.
</c:if>

 <c:if test="${not empty sessionScope.loginid}">
    <a href="../member/logout">logout</a> 
 <br />
 ${sessionScope.loginid} 님, 로그인상태입니다
  </c:if>
 <div>
	<p class="go-productList" style="color: #336666;">
	<a href="../product/productList">상품둘러보기</a>
	</p>
 </div>
 </div>
      </div>
      <ul class="nav">
        <li><a href="../order/myOrderList" title="">나의주문내역</a></li>
        <li><a href="../review/reviewMylistview" title="">나의리뷰보기</a></li>
        <li><a href="../member/infoupdateform" title="">회원정보수정란</a></li>
        <li><a href="#" title="">추가하기</a></li>

      </ul>

      	<nav class="nav-footer">

		</nav>  
    </div> 
  </nav>
</header>

<!-- <main class="" id="main-collapse">

Add your site or app content here
 
<script>
  document.addEventListener("DOMContentLoaded", function (event) {
     masonryBuild();
  });
</script>

</main> -->

<script>
document.addEventListener("DOMContentLoaded", function (event) {
  navbarToggleSidebar();
  navActivePage();
});
</script>

<script type="text/javascript" src="../resources/js/checkIndex.js"></script>

</body>


</html>