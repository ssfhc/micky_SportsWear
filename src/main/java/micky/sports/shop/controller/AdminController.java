package micky.sports.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import micky.sports.shop.service.MickyServiceInter;
import micky.sports.shop.service.admin.ACancleModifyService;
import micky.sports.shop.service.admin.AContentViewService;
import micky.sports.shop.service.admin.AOrderListService;
import micky.sports.shop.vopage.SearchVO;


@Controller
public class AdminController {
	MickyServiceInter mickyServiceInter;
	
	@Autowired
	private SqlSession sqlSession;
	
	//관리자 주문관리 현황 리스트
	 @RequestMapping("/admin_olist") //url 주소줄 
	 public String olist(HttpServletRequest request,SearchVO searchVO,Model model) { 
		 System.out.println(">>>>>>>>>olist<<<<<<<<<<");
		 
		 //DB 
		 model.addAttribute("request",request);
		 model.addAttribute("searchVo",searchVO);
		 		 
		 mickyServiceInter=new AOrderListService(sqlSession);
		 mickyServiceInter.execute(model);

		 return "admin/admin_olist"; //spring jsp 파일 위치
	 }
	 
	 
	//관리자 주문내역 상세
	 @RequestMapping("/admin_contentview") //url 주소줄 
	 public String acontentupdate(HttpServletRequest request, Model model) {
		 System.out.println(">>>>>>>>>acontentview<<<<<<<<<<");
	
		 //DB 
		 model.addAttribute("request",request);
		 
		 mickyServiceInter=new AContentViewService(sqlSession);
		 mickyServiceInter.execute(model);	
		 
		 return "admin/admin_contentview"; //spring jsp 파일 위치
	}
		 
		 
	//관리자 주문내역 상세 : 결제완료 → 주문취소 변경
	 @RequestMapping(method = RequestMethod.POST, value = "/modify") //url 주소줄 
	 public String amodify(HttpServletRequest request, Model model) {
		 System.out.println(">>>>>>>>>amodify<<<<<<<<<<");
	
		 //DB 
		 model.addAttribute("request",request);
		 
		 mickyServiceInter=new ACancleModifyService(sqlSession);
		 mickyServiceInter.execute(model);	
		 
		 return "redirect:admin/admin_olist"; //spring jsp 파일 위치
	} 
		 
		
}
