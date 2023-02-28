package micky.sports.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import micky.sports.shop.service.MickyServiceInter;
import micky.sports.shop.service.order.MyDelivCancelService;
import micky.sports.shop.service.order.MyOCancelOfferService;
import micky.sports.shop.service.order.MyOrderCancelService;
import micky.sports.shop.service.order.MyOrderConfirmService;
import micky.sports.shop.service.order.MyOrderListService;
import micky.sports.shop.service.order.OrderDeliveryService;
import micky.sports.shop.service.order.OrderPageService;
import micky.sports.shop.service.order.OrderPaymentService;
import micky.sports.shop.vopage.SearchVO;

@Controller
@RequestMapping("/order")
public class OrderController {
	MickyServiceInter mickyServiceInter;
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession httpsession;
	
	//주문하는 페이지
	@RequestMapping("/orderPage")
	public String orderView(HttpServletRequest request, Model model) {

		model.addAttribute("request",request);
		mickyServiceInter=new OrderPageService(sqlSession,httpsession);
		mickyServiceInter.execute(model);
		
		return "/order/orderPage";
	}
	
	// 주문 기능 payment +배송지입력
	@RequestMapping("/payment")
	public String payment(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		mickyServiceInter=new OrderPaymentService(sqlSession,httpsession);
		mickyServiceInter.execute(model);
		
		mickyServiceInter=new OrderDeliveryService(sqlSession,httpsession);
		mickyServiceInter.execute(model);
		
		return "/order/orderResult";
	}
	
	//나의 주문 내역보기
	@RequestMapping("/myOrderList")
	public String orderList(HttpServletRequest request,SearchVO searchVO, Model model) {
		
		model.addAttribute("request",request);
		mickyServiceInter=new MyOrderListService(sqlSession,searchVO,httpsession);
		mickyServiceInter.execute(model);
		
		return "/order/myOrderList";
	}
	
	//나의 주문 내역에서 취소요청시
		@RequestMapping("/myOrderCancel")
		public String myOrderCancel(HttpServletRequest request,Model model) {
			
			model.addAttribute("request",request);
			mickyServiceInter=new MyOrderCancelService(sqlSession,httpsession);
			mickyServiceInter.execute(model);
			
			return "/order/myOrderCancel";
		}
		//취소요청페이지에서 취소요청하기 클릭
		@RequestMapping(method = RequestMethod.POST, value = "/myOCancleOffer")
		public String myOCancleOffer(HttpServletRequest request,Model model) throws Exception {
			
			request.setCharacterEncoding("UTF-8");
			model.addAttribute("request",request);
			mickyServiceInter=new MyOCancelOfferService(sqlSession,httpsession);
			mickyServiceInter.execute(model);
			
			return "/order/myOCancelOffer";
		}
		
		//배송완료 상태에서 반품요청
		@RequestMapping("/myDelivCancel")
		public String myDelivCancel(HttpServletRequest request,Model model) {
			
			model.addAttribute("request",request);
			mickyServiceInter=new MyDelivCancelService(sqlSession,httpsession);
			mickyServiceInter.execute(model);
			
			return "redirect:myOrderList";
		}
		//배송완료 상태에서 구매확정
		@RequestMapping("/myOrderConfirm")
		public String myOrderConfirm(HttpServletRequest request,Model model) {
			
			model.addAttribute("request",request);
			mickyServiceInter=new MyOrderConfirmService(sqlSession,httpsession);
			mickyServiceInter.execute(model);
			
			return "redirect:myOrderList";
		}
		
}
