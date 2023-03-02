package micky.sports.shop.service.order;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.OrderDao;
import micky.sports.shop.dao.ProductDao;
import micky.sports.shop.dto.OrderMemberDto;
import micky.sports.shop.dto.ProductDto;
import micky.sports.shop.service.MickyServiceInter;

public class OrderDeliveryService implements MickyServiceInter{
	private SqlSession sqlSession;
	private HttpSession httpsession;

	public OrderDeliveryService(SqlSession sqlSession,HttpSession httpsession) {
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
		
		String receipt_name =request.getParameter("receipt_name");
		String receipt_phone =request.getParameter("receipt_phone");
		String addr1 =request.getParameter("addr1");
		String addr2 =request.getParameter("addr2");
		String addr3 =request.getParameter("addr3");
		
		OrderDao odao=sqlSession.getMapper(OrderDao.class);
		//가장최근 주문번호확인 *변경전
		//OrderMemberDto checkOmCntnum= odao.checkOmCntnum(loginId);
		//String omCntnum=checkOmCntnum.getOm_cntnum();
		//odao.deliverys(omCntnum,loginId,receipt_name,receipt_phone,addr1,addr2,addr3);
		
		//가장최근 주문번호확인 *변경후
	    ArrayList<OrderMemberDto> oms=odao.checkOms(loginId);
	    String omCntnum;
	    String omNum;
	    for (OrderMemberDto om : oms) {
	       omCntnum=om.getOm_cntnum();
	       omNum=om.getOm_num();
	       odao.delivery(omNum,loginId,receipt_name,receipt_phone,addr1,addr2,addr3,omCntnum);   
	    }
	
	}

}
