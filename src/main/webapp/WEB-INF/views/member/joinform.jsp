<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> <!-- 3.x.x 버전 - 가장 최신 버전, 아작스를 지원 -->

</head>
<body>
<script>
function checkid(){
	var overlapcheck_id = jf.m_id.value;
	let valcheck_id = /^[a-z]+[a-z0-9]{5,19}$/g;
	if(overlapcheck_id.length==0 || overlapcheck_id==""){
		alert("중복검사할아이디를입력하세요")
		jf.m_id.focus();
		return false;
	}else if(!valcheck_id.test(overlapcheck_id)||overlapcheck_id.length<6){
		alert("아이디정규표현식XXXX신호")
		jf.m_id.focus();
		return false;
	}else {
		//window.location.href="/micky_SportsWear/member/joinidcheck?overlapcheck_id=" + overlapcheck_id;
		$.ajax({
			url: '/micky_SportsWear/member/joinidcheck?overlapcheck_id=' + overlapcheck_id,
			type: 'GET',
			success: function( result ) {
				
				if( result==0) {
					//alert(result);
					alert("사용가능한아이디입니다")
				} else if( result==1 ) {
					alert(result);
					alert("이미있는아이디입니다")
				}
			},
			error: function() {
				console.log( "joinForm의 ajax 에러" )
			}
		})
	}
	
}
function checkinfo(){
	var m_id = jf.m_id.value;
	var m_pw = jf.m_pw.value;
	var m_name = jf.m_name.value;
	var m_tel = jf.m_tel.value;
	var m_name2 = jf.m_name2.value;
	var m_email = jf.m_email.value;
	//var m_grade = jf.m_grade.value;
	var m_age = jf.m_age.value;
	var m_gender = jf.m_gender.value;
	//var m_cash = jf.m_cash.value;
	let valcheck_pw = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;
	let valcheck_tel = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	let valcheck_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	if(m_id==0 || m_id==""){
		alert("아이디를입력하세요")
		return false;
	}else if(m_pw==0 ||m_pw==""){
		alert("비밀번호를입력하세요")
		return false;
	}else if(!valcheck_pw.test(m_pw)||m_pw.length<8){
		alert("비번정규표현식XXXX신호")
		jf.m_pw.focus();
		return false;
	}else if(m_name==0 || m_name==""){
		alert("이름을입력하세요")
		return false;
	}else if(m_tel==0 || m_tel==""){
		alert("전화번호를입력하세요")
		return false;
	}else if(!valcheck_tel.test(m_tel)){
		alert("전번정규표현식XXXX신호")
		jf.m_tel.focus();
		return false;
	}else if(m_name2==0 || m_name2==""){
		alert("닉네임을입력하세요")
		return false;
	}else if(m_email==0 || m_email==""){
		alert("이메일을입력하세요")
		return false;
	}else if(!valcheck_email.test(m_email)){
		alert("메일정규표현식XXXX신호")
		jf.m_email.focus();
		return false;
	}else if(m_age==0 || m_age==""){
		alert("나이를입력하세요")
		return false;
	}else if(m_gender==0 || m_gender==""){
		alert("성별을입력하세요")
		return false;
	}else{
		return true;
		alert("가입진행신호")
	}
	
}
</script>
<h3>joinform.jsp</h3>
<h1>회원가입화면</h1>
<%-- 중복확인 0/중복x , 1/중복o : ${overlapcheck_result } <br />  <br /> --%>
<form action="join" name="jf" method="post" onsubmit="return checkinfo()">
아이디 : <input type="text" id="id" name="m_id" value=""/><input type="button" value="중복확인" onclick="checkid()" /> <br />
비밀번호 : <input type="text" name="m_pw" /> <br /> 
이름 : <input type="text" name="m_name" /> <br /> 
전화번호 : <input type="text" id="m_tel" name="m_tel" maxlength="11" placeholder="휴대폰번호를 입력해주세요" style="ime-mode:disabled"> <br />
닉네임 : <input type="text" name="m_name2" /><input type="button" value="중복확인" onclick="#" /> <br />
이메일 : <input type="email" name="m_email" /> <br /> 
등급 : <input type="text" name="m_grade" value="bronze" readonly/> <br /> 
나이 : <input type="text" name="m_age" /> <br /> 
성별 : <input type="radio" name="m_gender" value="male" />남<input type="radio" name="m_gender" value="female" />여 <br /> 
캐시 : <input type="text" name="m_cash" value="500000" readonly/> <br /> 
첨부파일 : <input type="text" name="m_filesrc" value="noimg" readonly/> <br />
<input type="submit" value="가입" />
<input type="button" value="취소" onclick="location.href='loginform'" />
</form>
</body>
</html>