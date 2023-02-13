package micky.sports.shop.service.order;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.OrderDao;
import micky.sports.shop.dao.ProductDao;
import micky.sports.shop.service.MickyServiceInter;

public class OrderPaymentService implements MickyServiceInter {
	private SqlSession sqlSession;
	private HttpSession httpsession;
	public OrderPaymentService(SqlSession sqlSession,HttpSession httpsession) {
		this.sqlSession=sqlSession;
		this.httpsession = httpsession;
	}
	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");	
		
		//로그인 세션
		httpsession = request.getSession();
		String loginId = (String)httpsession.getAttribute("loginid");
		//System.out.println("*********~~~~~~~~~~~~~~~~~"+loginId);
		String[] pNo=request.getParameterValues("p_no"); //상품번호
		String[] cnt=request.getParameterValues("cnt"); //수량
		
		String totPrices=request.getParameter("totPrices"); // 구매총액
		
		OrderDao odao=sqlSession.getMapper(OrderDao.class);
		ProductDao pdao=sqlSession.getMapper(ProductDao.class);
		for (int i = 0; i < pNo.length; i++) {
			System.out.println("**********"+cnt[i]);
			//구매이력 추가
			odao.payment(loginId,pNo[i],Integer.parseInt(cnt[i]));
			//구매한 수량 재고 삭제
			pdao.delpayment(pNo[i],Integer.parseInt(cnt[i]));		
		}
		//구매한 금액 회원 캐시 차감 update
		odao.delcash(loginId,Integer.parseInt(totPrices));
		//model.addAttribute("mId",loginId);		
	}

}
