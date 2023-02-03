package micky.sports.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import micky.sports.shop.service.MickyCartList;
import micky.sports.shop.service.MickyCartinsertservice;
import micky.sports.shop.service.MickyDetailList;
import micky.sports.shop.service.MickyProductList;
import micky.sports.shop.service.MickyServiceInter;

@Controller
@RequestMapping("/Cart")
public class CartController {
	
	MickyServiceInter mickyServiceInter;
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/before")
	public String before(HttpServletRequest request, Model model) {
		//제품리스트
		System.out.println("before");
		
		mickyServiceInter=new MickyProductList(sqlSession);
		mickyServiceInter.execute(model);
		return "Cart/before";
	}
	
	@RequestMapping("/detaillist")
	public String detaillist(HttpServletRequest request, Model model) {
		//제품상세조회
		System.out.println("DetailList");
		
		model.addAttribute("request",request);
		
		mickyServiceInter=new MickyDetailList(sqlSession);
		mickyServiceInter.execute(model);	
		return "Cart/detaillist";
	}
	
	@RequestMapping("/insertCart")
	public String insertCart(HttpServletRequest request,Model model) {
		//장바구니추가
		System.out.println("insertCart");
		model.addAttribute("request",request);
		
		mickyServiceInter=new MickyCartinsertservice(sqlSession);
		mickyServiceInter.execute(model);
		return "Cart/before";
	}
	
	
	@RequestMapping("/Cartlist")
	public String Cart(HttpServletRequest request,Model model) {
		//장바구니 화면 구성 
		model.addAttribute("request",request);
		
		mickyServiceInter=new MickyCartList(sqlSession);
		mickyServiceInter.execute(model);
		return "Cart/Cartlist";
	}
	@RequestMapping("/Cartlist2")
	public String Cart2(HttpServletRequest request,Model model) {
		//장바구니 화면 구성 
		model.addAttribute("request",request);
		
		mickyServiceInter=new MickyCartList(sqlSession);
		mickyServiceInter.execute(model);
		return "Cart/Cartlist2";
	}
}
