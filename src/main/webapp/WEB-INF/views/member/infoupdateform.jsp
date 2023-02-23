<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Babylonica&family=Nanum+Gothic:wght@400;800&family=Noto+Sans+KR:wght@100&family=Titillium+Web&display=swap" rel="stylesheet">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> <!-- 3.x.x 버전 - 가장 최신 버전, 아작스를 지원 -->
</head>
<body style="font-family: 'Noto Sans Korean'">
<script>
window.onload = function(){
	var defaultemail = jf.defaultemail.value;
	if(defaultemail=="@daum.net"){
		$("#m_email2 option:eq(0)").prop("selected",true);
	}else if(defaultemail=="@naver.com"){
		$("#m_email2 option:eq(1)").prop("selected",true);
	}else if(defaultemail=="@gmail.com"){
		$("#m_email2 option:eq(2)").prop("selected",true);
	}else if(defaultemail=="@hanmail.com"){
		$("#m_email2 option:eq(3)").prop("selected",true);
	}else if(defaultemail=="@yahoo.co.kr"){
		$("#m_email2 option:eq(4)").prop("selected",true);
	}
	
	
}



function checkValue(){
	//var defaultemail = jf.defaultemail.value;
	//alert(defaultemail)

	inputPw = document.getElementById("m_pw").value; //input password값
	inputTel1 = document.getElementById("m_tel1").value;
	inputTel2 = document.getElementById("m_tel2").value;
	inputTel3 = document.getElementById("m_tel3").value;
	inputNickName = document.getElementById("m_name2").value;
	inputEmail = document.getElementById("m_email").value;
	//inputEmail2 = documnet.getElementById("m_email2").value;

	let valcheck_pw = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/; //pw 정규식
	//let valcheck_tel = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/; //tel 정규식
	
	var checkname2_YESorNO = jf.checkname2_YESorNO.value; //nickname중복확인진행 유무(기본값은 NO)
	var checkemail_YESorNO = jf.email_check_input_result.value; //email인증진행 유무(기본값은 NO)
	var checkpassword_YESorNO = jf.checkpassword_YESorNO.value; //비밀번호확인 진행 유무

	if(!inputPw){
		alert("비번입력하세요")
		return false;
	}else if(checkpassword_YESorNO=="NO"){
		alert("비밀번호확인진행하세요")
		jf.m_pw.focus();
		return false;
	}else if(!inputTel1 || !inputTel2 || !inputTel3){
		alert("전번입력하세요")
		return false;
	}else if(!inputNickName){
		alert("닉네임입력하세요")
		return false;
	}else if(checkname2_YESorNO=="NO"){
		alert("닉네임중복확인하세요")
		return false;
	}else if(!inputEmail){
		alert("이메일입력하세요")
		return false;
	}else if(checkemail_YESorNO=="NO"){
		alert("이메일인증하세요")
		return false;
	}else if(!valcheck_pw.test(inputPw)||inputPw.length<8){
		alert("비번정규표현식XXXX신호")
		return false;
	}/* else if(!valcheck_tel.test(inputTel)){
		alert("전번정규표현식XXXX신호")
		return false;
	} */
}
function checknickname(){ //닉네임중복확인
	var overlapcheck_nickname = jf.m_name2.value; //input nickname 값
	
	if(overlapcheck_nickname==0 || overlapcheck_nickname==""){ //input nickname을 타이핑하지않았을때
		alert("중복검사할닉네임을입력하세요")
		jf.m_name2.focus();
		return false;
	}else{
		$.ajax({
			url: '../member/joinnicknamecheck?overlapcheck=' + overlapcheck_nickname, //input nickname을 controller joinnicknamecheck()으로
			type: 'GET',
			success: function( result ) {
				
				if( result==0) { //닉네임이 중복하지않을때
					//alert(result);
					alert("사용가능한닉네임입니다 : "+result)
					$("input[name=checkname2_YESorNO]").val('YES'); //닉네임중복확인진행 유무(기본값은 NO)
				} else if( result==1 ) { //닉네임이 중복할때
					//alert(result);
					alert("이미있는닉네임입니다 : "+result)
				}
			},
			error: function() {
				console.log( "joinForm의 ajax 에러" )
			}
		})
	}
}
function emailcheck(){ //이메일인증번호발송
	const eamil = $('#m_email').val()+$('#m_email2').val(); //input email + select(option 메일주소)
	console.log('완성된 이메일 : '+ eamil); //확인용 (f12콘솔창 확인가능)
	const checkinput = $('.email_check_input') //인증번호입력란 (기본값 비활성화)
		
	
	 	$.ajax({
		type:'GET',
		url:'../member/emailoverlapcheck?email=' +eamil,
		success:function(result){
			alert(result)
			if(result==1){
				alert("이미사용중인이메일입니다")
			}else if(result==0){
				alert("사용가능한이메일입니다")
				
				$.ajax({
					type : 'GET',
					url : '../member/emailcheck?email=' + eamil, //email주소를 controller emailcheck()으로
					success : function(data){
						console.log("data : "+data); //인증번호확인용 (f12콘솔창 확인가능)
						checkinput.attr('disabled',false); //인증번호입력란 활성화
						code=data; //인증번호를 code에 저장
						alert('ajax신호신호이메일신호') //확인용
					}
				})
				
			}else{
				alert("오류")
			}
		}
	})
}
function emailinputcheck(){ //이메일인증번호확인
	var input_code = $(".email_check_input").val(); //input 인증번호
	alert("이메일인증번호확인 테스트") //확인용
	if(input_code == code){ //input 인증번호가 발급인증번호랑 일치하면
		$("input[name=email_check_input_result]").val('YES'); //이메일인증진행 유무 YES로 값을 변경
		alert("인증번호OO")
	}else{
		$("input[name=email_check_input_result]").val('NO'); //아니면 NO
		alert("인증번호XX")
	}
}
function readURL(input) { //프로필사진 업로드 (아직잘모름)
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	      document.getElementById('preview').src = e.target.result;
	    };
	    reader.readAsDataURL(input.files[0]);
	  } else {
	    document.getElementById('preview').src = "";
	  }
	}
function checkpassword(){ //비밀번호확인
	var input_pw = jf.m_pw.value; //비밀번호
	var input_checkpw = jf.check_mpw.value; //비밀번호확인
	
	alert("비밀번호 : "+input_pw+"비밀번호확인 : "+input_checkpw); //확인용
	
	if(input_pw==input_checkpw && input_pw!=""){
		$("input[name=checkpassword_YESorNO]").val('YES');
		alert("비밀번호일치")
	}else if(input_pw==""){
		alert("비밀번호를 입력하세요")
	}else{
		alert("비밀번호가다릅니다")
	}
}
$(document).ready(function(){ //비밀번호표시 체크박스
	$('input[type=checkbox][name=showpassword]').change(function(){
		alert("비밀번호표시신호")
		if($(this).is(':checked')){
			$('#m_pw').prop("type","text");
			$('#check_mpw').prop("type","text");
		}else{
			$('#m_pw').prop("type","password");
			$('#check_mpw').prop("type","password");
		}
	})
})
</script>
<p style="font-family:'Nanum Gothic'; font-weight: bold;" >infoupdateform.jsp</p>

<p>infoupdateform.jsp</p>
<h1 style="font-family:'Nanum Gothic'">회원정보수정화면</h1>
<form action="infoupdate" name="jf" method = "post" enctype="multipart/form-data" onsubmit = "return checkValue()">
<input type="hidden" name="m_id" value="${infoupdateform.m_id }" />
<input type="hidden" name="checkname2_YESorNO" value="NO" readonly/><br /> <!-- 닉네임중복체크유무 -->
<input type="hidden" name="checkpassword_YESorNO" value="NO" readonly />



<input type="hidden" class="defaultemail" name="defaultemail" id="defaultemail" value="${m_email2 }" /> <!-- 이메일 뒷주소 -->
아이디 : ${infoupdateform.m_id }
<br />
비밀번호 : ${infoupdateform.m_pw }
<br />
<input type="password" name="m_pw" id="m_pw" value="${infoupdateform.m_pw }" />
비밀번호 확인 : <input type="password" id="check_mpw" name="check_mpw" value="${infoupdateform.m_pw }"/> <input type="button" value="확인" onclick="checkpassword()" />
비밀번호표시<input type="checkbox" name="showpassword" /> 
<br /> 
이름 : ${infoupdateform.m_name } 
<br />
전화번호 : ${infoupdateform.m_tel } 
<input type="hidden" name="default_tel" id="default_tel" value="${infoupdateform.m_tel } " />
<br />
<c:set var="tel" value="${infoupdateform.m_tel }"/>
<input type="text" name="m_tel1" id="m_tel1" value="${fn:substring(tel,0,3) }" pattern="\d*" maxlength='3'/> - 
<input type="text" name="m_tel2" id="m_tel2" value="${fn:substring(tel,4,8) }" pattern="\d*" maxlength='4'/> - 
<input type="text" name="m_tel3" id="m_tel3" value="${fn:substring(tel,9,13) }" pattern="\d*" maxlength='4'/>

<br />
닉네임 : ${infoupdateform.m_name2 }
<br />
<input type="text" name="m_name2" id="m_name2" value="${infoupdateform.m_name2 }"/><input type="button" value="중복확인" onclick="checknickname()" />
<br />
이메일 : ${infoupdateform.m_email }
<input type="hidden" name="default_email" id="default_email" value="${infoupdateform.m_email } " />
<br />
		<c:set var="email" value="${infoupdateform.m_email }" />
		<input type="text" name="m_email" id="m_email" value="${fn:substring(email,0,email.indexOf("@"))}"/>
		<select name="m_email2" id="m_email2">
		<option name="daum" value="@daum.net">@daum.net</option>
		<option name="naver"  value="@naver.com">@naver.com</option>
		<option name="gmail"  value="@gmail.com">@gmail.com</option>
		<option name="hanmail"  value="@hanmail.com">@hanmail.com</option>
		<option name="yahoo"  value="@yahoo.co.kr">@yahoo.co.kr</option>
		</select> 
		<input type="button" value="인증번호전송" onclick="emailcheck()"/>
		<input class="email_check_input" placeholder="인증번호 6자리를 입력하세요" disabled="disabled" maxlength="6" />
		<input type="button" value="확인" onclick="emailinputcheck()" />
		<input type="text" name ="email_check_input_result" value="NO"  readonly/><br /> <!-- 이메일인증진행 유무 -->
등급 : ${infoupdateform.m_grade }
<br />
나이 : ${infoupdateform.m_age }
<br />
성별 : ${infoupdateform.m_gender }
<br />
현금 : ${infoupdateform.m_cash }
<br />
프로필사진<input type="file" name="m_filesrc" value="3333" accept="image/png, image/jepg" onchange="readURL(this)"/>
		<img id="preview" src="../resources/upload/${infoupdateform.m_filesrc }" width="150px" height="150px" />
<br />
		<input type="submit" value="수정완료" /> &nbsp;&nbsp;
		<a href="mypageform">마이페이지로</a> &nbsp;&nbsp;

</form>
</body>
</html>