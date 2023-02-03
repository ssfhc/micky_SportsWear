package micky.sports.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import micky.sports.shop.service.MickyServiceInter;
import micky.sports.shop.service.review.ReviewDeleteService;
import micky.sports.shop.service.review.ReviewMylistviewService;
import micky.sports.shop.service.review.ReviewPopupcontentmodifyService;
import micky.sports.shop.service.review.ReviewPopupcontentviewService;
import micky.sports.shop.service.review.ReviewService;
import micky.sports.shop.service.review.ReviewWriteService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	MickyServiceInter mickyServiceInter;
	
	@Autowired
	private SqlSession sqlSession;
	
//	임시 메인페이지
	@RequestMapping("/reviewBoard")
	public String reviewBoard(HttpServletRequest request,Model model) {
		System.out.println("=====reviewBoard====");
		
		mickyServiceInter=new ReviewService(sqlSession);
		mickyServiceInter.execute(model);
		
		return "review/reviewBoard";
	}
	
//	마이페이지-카테고리 리뷰로 접근
	@RequestMapping("/reviewMylistview")
	public String reviewListview(HttpServletRequest request, Model model) {
		System.out.println("=====reviewMylistview====");
		
		model.addAttribute("request", request);
		mickyServiceInter=new ReviewMylistviewService(sqlSession);
		mickyServiceInter.execute(model);
		
		return "review/reviewMylistview";
	}
	
//	작성 폼(Popup)
	@RequestMapping("/reviewWriteview")
	public String reviewWriteview(Model model) {
		System.out.println("=====reviewWriteview====");
		
		return "review/reviewWriteview";
	}
	
//	작성
	@RequestMapping("/reviewWrite")
	public String reviewWrite(HttpServletRequest request, Model model) {
		System.out.println("=====reviewWrite====");
		
		model.addAttribute("request", request);
		mickyServiceInter=new ReviewWriteService(sqlSession);
		mickyServiceInter.execute(model);
		
		return "redirect:reviewBoard";
	}
	
//	삭제
	@RequestMapping("/reviewDelete")
	public String reviewDelete(HttpServletRequest request, Model model) {
		System.out.println("=====reviewDelete====");
		
		model.addAttribute("request", request);
		mickyServiceInter=new ReviewDeleteService(sqlSession);
		mickyServiceInter.execute(model);
		
		return "redirect:reviewBoard";
	}
	
//	Popup 수정폼
	@RequestMapping("/reviewPopupcontentview")
	public String reviewPopupcontentview(HttpServletRequest request, Model model) {
		System.out.println("=====reviewPopupview====");
		
		model.addAttribute("request", request);
		mickyServiceInter=new ReviewPopupcontentviewService(sqlSession);
		mickyServiceInter.execute(model);
		
		return "review/reviewPopupcontentview";
	}
	
//	Popup 수정하기
	@RequestMapping("/reviewPopupcontentmodify")
	public String reviewPopupcontentmodify(HttpServletRequest request, Model model) {
		System.out.println("=====reviewPopupcontentmodify====");
		
		
		model.addAttribute("request", request);
		mickyServiceInter=new ReviewPopupcontentmodifyService(sqlSession);
		mickyServiceInter.execute(model);
		
		return "redirect:reviewBoard";
	}
}
