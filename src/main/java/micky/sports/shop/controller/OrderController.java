package micky.sports.shop.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import micky.sports.shop.dao.OrderDao;
import micky.sports.shop.dto.OrderMemberDto;
import micky.sports.shop.dto.ProductDto;
import micky.sports.shop.service.MickyServiceInter;

@Controller
@RequestMapping("/order")
public class OrderController {
	MickyServiceInter mickyServiceInter;
	
	@Autowired
	private SqlSession sqlSession;
	
	//주문하는 페이지
	@RequestMapping("/orderPage")
	public String orderView(HttpServletRequest request, Model model) {
		System.out.println("========orderPage=======");

		// TODO 230203 상품번호 하나와 상품수량만 확인 가능
		String no=request.getParameter("orders.p_no"); 
		int cnt=Integer.parseInt(request.getParameter("orders.u_cnt")); 
		System.out.println("**********"+no);
		System.out.println("**********"+cnt);

		OrderDao odao = sqlSession.getMapper(OrderDao.class);
		ProductDto orderPSelect=odao.orderSelect(no);
		
		model.addAttribute("orderPSelect",orderPSelect);
		model.addAttribute("cnt",cnt);
		
		return "/order/orderPage";
	}
	
	// 주문 기능 payment
	@RequestMapping("/payment")
	public String payment(HttpServletRequest request, Model model) {
		System.out.println("========payment=======");
		
		//String mId=request.getParameter("m_id"); //아이디
		// TODO 230203 mId 추후수정
		String mId="blue2"; 
		String pNo=request.getParameter("p_no"); //상품번호
		int cnt=Integer.parseInt(request.getParameter("cnt")); //수량

		OrderDao odao=sqlSession.getMapper(OrderDao.class);
		odao.payment(mId,pNo,cnt);
		
		//model.addAttribute("pNo",pNo);
		model.addAttribute("mId",mId);
		
		return "redirect:myOrderList";
	}
	
	//나의 주문 내역보기
	@RequestMapping("/myOrderList")
	public String orderList(HttpServletRequest request, Model model) {
		System.out.println("========myOrderList=======");
		
		// TODO 230203 mId 추후수정
		String mId=request.getParameter("mId");
		System.out.println("mId: "+mId);
		//String mId=request.getParameter("m_id"); //아이디

		OrderDao odao=sqlSession.getMapper(OrderDao.class);
		ArrayList<OrderMemberDto> omdList=odao.mtOrderList(mId);

		model.addAttribute("omdList",omdList);
		
		return "/order/myOrderList";
	}
	
}
