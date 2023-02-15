<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> <!-- 3.x.x 버전 - 가장 최신 버전, 아작스를 지원 -->
</head>
<body>
<script>
function email(){ //이메일인증번호발송
const eamil = $('#m_email').val()+$('#m_email2').val(); //input email + select(option 메일주소)
console.log('완성된 이메일 : '+ eamil); //확인용 (f12콘솔창 확인가능)

	$.ajax({
		type : 'GET',
		url : '/shop/member/emailcheck?email=' + eamil, //email주소를 controller emailcheck()으로
		success : function(data){
			console.log("data : "+data); //인증번호확인용 (f12콘솔창 확인가능)
			checkinput.attr('disabled',false); //인증번호입력란 활성화
			code=data; //인증번호를 code에 저장
			alert('ajax신호신호이메일신호') //확인용
		}
	})
}
</script>
<h3>findidform.jsp</h3>
<h1>아이디찾기화면</h1>
이름 : <input type="text" name="m_name" id="m_name" /> <br />
이메일 : <input type="text" name="m_email" id="m_email" />
		<select name="m_email2" id="m_email2">
		<option>@naver.com</option>
		<option>@daum.net</option>
		<option>@gmail.com</option>
		<option>@hanmail.com</option>
		<option>@yahoo.co.kr</option>
		</select> 
		<input type="button" onclick="email()" value="임시비밀번호발송"/>
</body>
</html>