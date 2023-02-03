<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h1><a href="main">메인화면</a></h1>



<a href="product/productLsit">productList</a>
<a href="review/reviewBoard">review</a>
<a href="Cart/before">Cart</a>
<a href="admin/admin_olist">admin_olist</a>
<a href="loginform">loginform</a>


</body>
</html>
