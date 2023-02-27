package micky.sports.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import micky.sports.shop.service.MickyServiceInter;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
	MickyServiceInter mickyServiceInter;

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession httpsession;
	
	//마이페이지
	@RequestMapping("/checkIndex")
	public String checkIndex(HttpServletRequest request, Model model) {
		System.out.println("========checkIndex=======");
		
		model.addAttribute("request",request);
		
//		mickyServiceInter=new ProductListService(sqlSession,httpsession);
//		mickyServiceInter.execute(model);
		
		return "myPage/checkIndex";
	}
	

}
