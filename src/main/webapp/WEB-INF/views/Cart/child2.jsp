<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
</head>
<body>
<!-- 참조: https://docu94.tistory.com/98
위내용으로 직접 사용하면 진행안함 따로 적용할때 적용됨 -->


<script>
//var gogo='stop';
function dbupdate() {
	var name=document.getElementById("name").value;
	$.ajax({
	    url:'dbsend?a='+name,
	    async:true,         // false 일 경우 동기 요청으로 변경
	    type:'get',   // POST, GET, PUT
	    data: {            // 전송할 데이터
	        name2:'hhhhhhhh'
	    }
	});
	//hhh();
	//gogo="closego";
	//return gogo;
}
function hhh() {
	
	//if(gogo=='closego'){
		//window.close();
		window.open("about:blank","_self").close();
		//return true;
	//}
	//else{
		//return false;
	//}
	//return true
}

</script>
<h3>child2</h3>
 <br>
    <b><font size="5" color="gray">자식창</font></b>
    <br><br>
 	<form  onsubmit="return hhh()">
	    <input type="text" id="name"><br><br>
	    <input type="submit" value="창닫기" onclick="dbupdate();">
 	</form>
</body>
</html>