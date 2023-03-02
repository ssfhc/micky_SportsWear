<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> <!-- 3.x.x 버전 - 가장 최신 버전, 아작스를 지원 -->
<style>
.membercheckformbtn{
	color: white;
	background-color: black;
	border-color: black;
	transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
	border-radius: 5px;
	border: 1px solid;
	width: 150px; 
	height: 30px;
}	
.findidformbtn:hover {
	color: black;
	background-color: white;
	border-color: black;
	cursor: pointer;
}
.inputvalue{
	width: 300px;
	height: 30px;
	border: 1px solid #c4c4c4;
	background-color: #ffffff;
}
</style>
</head>
<body style="text-align: center">
<script>
function checkValue(){
	inputPw = document.getElementById("m_pw").value; //input password값
	
	if(!inputPw){
		alert("비밀번호입력하세요")
	}else{
		$.ajax({
			url:'../member/memberdropcheck',
			type:'POST',
			data:"m_pw="+inputPw,
			dataType:'text',
			success:function(result){
				if( result==0) { 
					alert("본인인증실패")
					$('#m_pw').val('');
					document.getElementById("m_pw").focus();
				} else if( result==1 ) {
					alert("본인인증완료")
					self.close();
					opener.location.href="memberdrop";
				}
			},
			error: function() {
				console.log( "에러" )
			}
		})
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
<%-- <h1 style="margin-right: 30px">본인인증</h1>
아이디 : <input type="text" value="<%=session.getAttribute("loginid") %>" style="margin-right: 106px;" name="m_id" readonly/> <br />
비밀번호 : <input type="password" name="m_pw" id="m_pw" />
비밀번호표시<input type="checkbox" name="showpassword" /> <br /> <br />
<input class="btn1" type="button" value="확인" onclick="checkValue()" />
<input class="btn1" type="button" value="취소" onclick="window.close()" style="margin-right: 25px" />
 --%>
<div class="container" style="width: 500px; height: 350px; text-align: center">
         <!-- <img src="../resources/kthimg/THEMICKYFACE2.png"  width="300" height="250"> -->   
		 <h1>본인인증</h1>  
         <div>
            <input class="inputvalue" type="text"  name="m_id" id="m_id" value="<%=session.getAttribute("loginid") %>" readonly />
         </div>
         <br />
         <div>
            <input class="inputvalue" type="password" name="m_pw" id="m_pw" placeholder="비밀번호 입력.." />
         </div>
         	비밀번호표시<input type="checkbox" name="showpassword" />
         <br />
         <br />
         <button class="membercheckformbtn" onclick="checkValue()" >확인</button>
         <button class="membercheckformbtn" onclick="window.close()" >취소</button> <br /> <br /> <br />

         </div>
</body>
</html>