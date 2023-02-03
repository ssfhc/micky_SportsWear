<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<script>
function count(type)  {
	  // 결과를 표시할 element
	  
	  const num=document.getElementById("cartnumm").value;
	  const cartnum=document.getElementById("cartnum"+num).value;
	  const resultElement = document.getElementById('result'+cartnum);
	  
	  // 현재 화면에 표시된 값
	  let number = resultElement.innerText;
	  // 더하기/빼기
	  if(type === 'plus'+cartnum) {
	    number = parseInt(number) + 1;
	    alert(cartnum)
	  }else if(type === 'minus'+cartnum)  {
	    number = parseInt(number) - 1;
	  }
	  
	  // 결과 출력
	  resultElement.innerText = number;
	}
</script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>cart</h3>
장바구니 상품 ${fn:length(list) } 개 <br />
${list.size() } <br />
<a href="#">전체삭제</a> 
<div class="Cart_list">
	<table border="1" width="800">
		  <tr>
			<th>상품정보</th>
			<th>수량</th>
			<th>주문금액</th>
		  </tr>
		<c:forEach  var="cart" items="${list }">
		  <tr>
		    <td>
		    	
				<input type="hidden" id="cartnumm" value="${cart.c_no }" />
				<input type="hidden" id="cartnum${cart.c_no }" value="${cart.c_no }" />
		    	<!-- 상품의 상세정보로 이동 -->
<%-- 		    	<a href="#"><img src="/reources/img/${cart.productDto.p_filesrc }" alt="img_link" /></a> --%>
				
		    	${cart.productDto.p_name } <br />
		    	${cart.productDto.p_size }/${cart.productDto.p_no } <br />
		    	제품수량 : ${cart.c_cnt } <br />    	
		    	장바구니번호 : ${cart.c_no }
		    	
				
		    </td>
		    <td>
		    	<!-- '-'나'+'형태로 구현  -->
				<input type='button' onclick='count("minus${cart.c_no }")' value='-'/>
		    	<input type='button' onclick='count("plus${cart.c_no }")'  value='+'/>
		        <div id='result${cart.c_no }'>${cart.c_cnt }</div>		
		    	<!-- 사이즈, 색상 변경으로인해 제품번경 -->
		    	<a href="#">옵션변경</a>
		    </td>
		    <td>
		    	<a href="deleteCart"><img src="#" alt="현재 장바구니 삭제" /></a>
		    	
		    </td>
		  </tr>
		</c:forEach>		 
	</table>
</div>

<div class="Order_left">
	<dl>
		<dt>주문 금액</dt>	
		
		<dd>
			<ul>
				<li>
					<em>상품금액</em><em>197,100</em><span>원</span>
				</li>
				<li>
					<em>배송비</em><em>0</em><span>원</span>
				</li>
				<li>
					<em>상품 핳인금액</em><em>9,860</em><span>원</span>
				</li>
				<li>
					<em>주문 할인금액</em><em>0</em><span>원</span>
				</li>
			</ul>
		</dd>
	</dl>
	<em>총 결제금액</em> <em>187,240</em><span>원</span>
</div>
<!-- 제품,사이즈,수량,가격,구매자  -->
<a href="#">주문하기</a>

</body>
</html>