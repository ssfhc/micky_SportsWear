<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<script>
document.querySelectorAll('.updown').forEach(

  
	function(item, idx) {

		//수량 입력 필드 값 변경

		item.querySelector('input').addEventListener('keyup', function() {

			basket.changePNum(idx + 1);

		});

		//수량 증가 화살표 클릭

		item.children[1].addEventListener('click', function() {

			basket.changePNum(idx + 1);

		});

		//수량 감소 화살표 클릭

		item.children[2].addEventListener('click', function() {

			basket.changePNum(idx + 1);

		});

	}

	);
updateUI: function () {

    document.querySelector('#sum_p_num').textContent = '상품갯수: ' + this.totalCount.formatNumber() + '개';

    document.querySelector('#sum_p_price').textContent = '합계금액: ' + this.totalPrice.formatNumber() + '원';

},
</script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>cart</h3>
장바구니 상품 ${fn:length(list) } 개 <br />
${list.size() }
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
				<input type="hidden" id="cartnum" value="${cart.c_no }" />
		    	<!-- 상품의 상세정보로 이동 -->
<%-- 		    	<a href="#"><img src="/reources/img/${cart.productDto.p_filesrc }" alt="img_link" /></a> --%>
				
		    	${cart.productDto.p_name } <br />
		    	${cart.productDto.p_size }/${cart.productDto.p_no } <br />
		    	제품수량 : ${cart.c_cnt } <br />    	
		    	장바구니번호 : ${cart.c_no }
		    	
				
		    </td>
		    <td>
		    	<!-- 상품갯수 증가 감소버튼  -->
		    	   <div class="updown">

                    <input type="text" name="p_num1" id="p_num1" size="2" maxlength="4" class="p_num" value="2">

                    <span><i class="fas fa-arrow-alt-circle-up up"></i></span>

                    <span><i class="fas fa-arrow-alt-circle-down down"></i></span>

                </div>
		    		
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