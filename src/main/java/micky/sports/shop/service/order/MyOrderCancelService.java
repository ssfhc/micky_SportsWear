package micky.sports.shop.service.order;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.OrderDao;
import micky.sports.shop.service.cart.MickyServiceInter;

public class MyOrderCancelService implements MickyServiceInter{
	private SqlSession sqlSession;
	private HttpSession httpsession;
	public MyOrderCancelService(SqlSession sqlSession,HttpSession httpsession) {
		this.sqlSession=sqlSession;
		this.httpsession=httpsession;
	}
	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");	
		
		//로그인 세션
		httpsession = request.getSession();
		String loginId = (String)httpsession.getAttribute("loginid");

		String omcntnum=request.getParameter("omcntnum");

		OrderDao odao = sqlSession.getMapper(OrderDao.class);
		model.addAttribute("myOrderCancelOffer",odao.myOrderCancelOffer(omcntnum));
		
		model.addAttribute("myList",odao.ordersMember(loginId));
		
	}

}
