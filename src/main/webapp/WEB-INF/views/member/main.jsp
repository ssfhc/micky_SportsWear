<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String loginid = (String)session.getAttribute("loginid"); %> <!-- 로그인된아이디 스트링으로가져오기 -->   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>main.jsp</h3>
<h1>메인화면</h1>
<%if(session.getAttribute("loginid")==null){ //로그인이 실패하면
%>
<input type="button" value="로그인화면" onclick="location.href='loginform'" /> <br />
<%
}else { //로그인이 성공하면 
%>
<hr />
프로필사진 확인용 : 
<img src="../resources/upload/${dto.m_filesrc}" style="border: 1px" width="150px" height="150px"/>
<hr />
<font color="blue"><%=session.getAttribute("loginid") %></font>
님 반가워요
<input type="button" value="로그아웃" onclick="location.href='logout'" /> <br />
<input type="button" value="마이페이지" onclick="location.href='mypageform'" /><br />
<% 
if(loginid.equals("admintest")){ //로그인아이디가 admintest라면 관리자페이지button이 보임
%>
<input type="button" value="관리자페이지" onclick="location.href='adminpage'"/>	<br />
<%
}
%>
<%
}
%>

<!-- 값 확인용 -->
로그인중인 아이디 : <%=session.getAttribute("loginid") %>


<hr />
<a href="../product/productList">productlist</a>  <br />
</body>
</html>