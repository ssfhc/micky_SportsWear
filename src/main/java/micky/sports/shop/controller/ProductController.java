package micky.sports.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import micky.sports.shop.dao.ProductDao;
import micky.sports.shop.service.MickyServiceInter;
import micky.sports.shop.service.product.ProductChartService;
import micky.sports.shop.service.product.ProductDetailService;
import micky.sports.shop.service.product.ProductListService;

@Controller
@RequestMapping("/product")
public class ProductController {
	MickyServiceInter mickyServiceInter;

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession httpsession;
	
	//상품목록
	@RequestMapping("/productList")
	public String productLsit(HttpServletRequest request, Model model) {
		System.out.println("========productList=======");

		model.addAttribute("request",request);
		mickyServiceInter=new ProductListService(sqlSession,httpsession);
		mickyServiceInter.execute(model);
		
		return "/product/productList";
	}
	//상품페이지
	@RequestMapping("/productDetail")
	public String product(HttpServletRequest request, Model model) {
		System.out.println("========product=======");
		
		model.addAttribute("request",request);
		mickyServiceInter=new ProductDetailService(sqlSession,httpsession);
		mickyServiceInter.execute(model);
		
		return "/product/productDetail";
	}
	//상품목록차트
	@RequestMapping("/productChart")
	public String productChart(HttpServletRequest request, Model model) {
		System.out.println("========productChart=======");

		model.addAttribute("request",request);
		
		mickyServiceInter=new ProductChartService(sqlSession,httpsession);
		mickyServiceInter.execute(model);
		
		return "/product/productChart";
	}
	

}
