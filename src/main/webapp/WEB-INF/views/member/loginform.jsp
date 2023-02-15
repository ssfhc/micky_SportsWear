<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<script>
function checkValue(){
	inputId = document.getElementById("m_id").value; //input id값
	inputPw = document.getElementById("m_pw").value; //input password값
	if(!inputId){ //id를 입력하지않으면
		alert("아이디입력없음");
		//return false; //flase리턴, submit작동안함
	}else if(!inputPw){ //pw를 입력하지않으면
		alert("비밀번호입력없음");
		//return false; //flase리턴, submit작동안함
	}else{
		$.ajax({
			type:'GET',
			url:'/shop/member/login?m_id=' + inputId + '&m_pw=' + inputPw,
			success:function(data){
				//alert("로그인폼에이잭스확인 : "+data)
				if(data==0){
					alert("아이디비밀번호를확인하세요")
				}else if(data==1){
					alert("로그인완료확인")
					window.location.href="/shop/member/main"
				}
			}
		})
	}
	
}
</script>

<h3>loginform.jsp</h3>
<h1>로그인화면</h1>

<!-- <form action="login" method="post" name="logininfo" onsubmit="return checkValue()" > --> <!-- submit 실행 전에 먼저실행됨 -->

<input type="hidden" name="login_check_result" value="NO" />

아이디 : <input type="text" name="m_id" id="m_id" /> <br />
비밀번호 : <input type="password" name="m_pw" id="m_pw" autocomplete="current-password"/> <br />

<input type="submit" value="로그인" onclick="checkValue()" /> <!-- 입력한 id,pw를 MemberContorller/login()으로 보내기 -->
<input type="button" value="회원가입" onclick="location.href='joinform'" /> <br />
<input type="button" value="메인화면" onclick="location.href='main'" />

</form>
</body>
</html>