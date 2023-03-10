package micky.sports.shop.controller;

import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import micky.sports.shop.crypt.CryptoUtil;
import micky.sports.shop.service.MickyServiceInter;
import micky.sports.shop.service.member.EmailOverlapCheckService;
import micky.sports.shop.service.member.FindIdService;
import micky.sports.shop.service.member.FindPwService;
import micky.sports.shop.service.member.InfoUpdateFormService;
import micky.sports.shop.service.member.InfoUpdateService;
import micky.sports.shop.service.member.JoinIdCheckService;
import micky.sports.shop.service.member.JoinNickNameCheckService;
import micky.sports.shop.service.member.JoinService;
import micky.sports.shop.service.member.LogOutService;
import micky.sports.shop.service.member.LoginService;
import micky.sports.shop.service.member.MainService;
import micky.sports.shop.service.member.MemberChartService;
import micky.sports.shop.service.member.MemberDropCheckService;
import micky.sports.shop.service.member.MemberDropService;
import micky.sports.shop.service.member.TemporaryPwService;
import micky.sports.shop.service.myPage.MyPageService;
import micky.sports.shop.service.product.ProductChartService;
import micky.sports.shop.service.qnamember.AdminQnaListService;
import micky.sports.shop.service.qnamember.MemberDeleteService;
import micky.sports.shop.service.qnamember.MemberListService;
import micky.sports.shop.service.qnamember.MemberUpdateFormService;
import micky.sports.shop.service.qnamember.MemberUpdateService;
import micky.sports.shop.service.qnamember.QnaDeleteService;
import micky.sports.shop.service.qnamember.QnaDetailService;
import micky.sports.shop.service.qnamember.QnaListService;
import micky.sports.shop.service.qnamember.QnaReplyService;
import micky.sports.shop.service.qnamember.QnaWriteService;
import micky.sports.shop.vopage.SearchVO;

@Controller
@RequestMapping("/member")
public class MemberController {

	MickyServiceInter mickyServiceInter;
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession session;
	
	@Autowired
	private JavaMailSender mailSender;
	
	//????????????
	@RequestMapping("/500error")
	public String error500(HttpServletRequest request, Model model) {
		System.out.println("@@@MemberController/500error()@@@");					
		return "/error/500error";
	}		
	@RequestMapping("/404error")
	public String error404(HttpServletRequest request, Model model) {
		System.out.println("@@@MemberController/404error()@@@");					
		return "/error/404error";
	}

	
	
		

	
	
	//????????????
	@RequestMapping("/main")
	public String main(HttpServletRequest request, Model model) {
		System.out.println("@@@MemberController/main()@@@");
		mickyServiceInter = new MainService(sqlSession,session);
		mickyServiceInter.execute(model);
				
		return "/member/main";
	}
	
	
	//???????????????
	@RequestMapping("/loginform")
	public String loginform(Model model) {
		System.out.println("@@@MemberController/loginform()@@@");
		
		return "/member/loginform";
	}
	
	
	//???????????????
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public int login(HttpServletRequest request,Model model,CryptoUtil crypt) {
		System.out.println("@@@MemberController/login()@@@"); //controller ????????????
			
		model.addAttribute("request",request);
		model.addAttribute("crypt",crypt);
		mickyServiceInter = new LoginService(sqlSession,session);
		mickyServiceInter.execute(model);
		
		
		Map<String, Object> map = model.asMap();
		int logincheck_result = (Integer) map.get("logincheck_result"); //ajax return?????? data ???????????? model??? ?????? ??????
		
		return logincheck_result;
	}
	
	
	//??????????????????
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/logout()@@@");
				
		//model.addAttribute("request",request);
		mickyServiceInter = new LogOutService(sqlSession,session);
		mickyServiceInter.execute(model);
		mickyServiceInter=new ProductChartService(sqlSession,session);
		mickyServiceInter.execute(model);
				
		return "/product/productChart";
	}
	
	
	//??????????????????
	@RequestMapping("/joinform")
	public String joinform(Model model) {
		System.out.println("@@@MemberController/joinform()@@@");
		return "/member/joinform";
	}
	
	
	//???????????????????????????
	@RequestMapping(value="/joinidcheck",method = RequestMethod.POST)
	@ResponseBody
	public int joinidcheck(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/joinidcheck()@@@");
		
		model.addAttribute("request",request);
		mickyServiceInter = new JoinIdCheckService(sqlSession);
		mickyServiceInter.execute(model);
		
		Map<String, Object> map = model.asMap();
		int overlapcheck_result = (Integer) map.get("overlapcheck_result"); //ajax return?????? data ???????????? model??? ?????? ??????
		
//		String overlapcheck_result = request.getParameter("count");
		
		System.out.println("?????? : "+overlapcheck_result); //?????????
		
		return overlapcheck_result; //return ??? ?????? ajax success (data)??? ??????
	}
	
	
	//???????????????????????????
	@RequestMapping(value="/joinnicknamecheck",method = RequestMethod.POST)
	@ResponseBody
	public int joinnicknamecheck(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/joinnicknamecheck()@@@");
		
		model.addAttribute("request",request);
		mickyServiceInter = new JoinNickNameCheckService(sqlSession);
		mickyServiceInter.execute(model);
		
		Map<String, Object> map = model.asMap();
		int overlapcheck_result = (Integer) map.get("overlapcheck_result");
		
//		String overlapcheck_result = request.getParameter("count");
		
		System.out.println("?????? : "+overlapcheck_result);
		
		return overlapcheck_result;
	}	
	
	
	//??????????????????
	@RequestMapping("/join")
	public String join(HttpServletRequest request,Model model,CryptoUtil crypt) {
		System.out.println("@@@MemberController/join()@@@");
		//String m_id= request.getParameter("m_id");
		//System.out.println("???????????? joincontrol : "+m_id);	
		model.addAttribute("request",request);
		model.addAttribute("crypt",crypt);
		mickyServiceInter = new JoinService(sqlSession);
		mickyServiceInter.execute(model);
			
		return "/member/loginform";
	}
	
	
	//?????????????????????
	@RequestMapping("/mypageform")
	public String mypageform(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/mypageform()@@@");
								
		return "/member/mypageform";
	}
	
	
//	//????????????????????????
//	@RequestMapping("/adminpage")
//	public String adminpage(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/adminpage()@@@");
//							
//		return "/member/adminpage";
//	}
//	
//	
//	//??????????????????
//	@RequestMapping("/memberlist")
//	public String memberlist(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/memberlist()@@@");
//		mickyServiceInter = new MemberListService(sqlSession,session);
//		mickyServiceInter.execute(model);	
//				
//		return "/member/memberlist";		
//	}
//	
//	
//	//????????????????????????
//	@RequestMapping("/memberupdateform")
//	public String memberupdateform(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/memberupdateform()@@@");
//		model.addAttribute("request", request);
//		mickyServiceInter = new MemberUpdateFormService(sqlSession,session);
//		mickyServiceInter.execute(model);	
//				
//		return "/member/memberupdateform";		
//	}
//	
//	
//	//????????????????????????
//	@RequestMapping("/memberupdate")
//	public String memberupdate(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/memberupdate()@@@");
//		model.addAttribute("request", request);
//		mickyServiceInter = new MemberUpdateService(sqlSession,session);
//		mickyServiceInter.execute(model);	
//				
//		return "redirect:/member/memberlist";		
//	}
//	
//	
//	//????????????????????????
//	@RequestMapping("/memberdelete")
//	public String memberdelete(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/memberdelete()@@@");
//		model.addAttribute("request", request);
//		mickyServiceInter = new MemberDeleteService(sqlSession,session);
//		mickyServiceInter.execute(model);	
//				
//		return "redirect:/member/memberlist";		
//	}
//	
//	
//	//?????????????????? ????????????????????????
//	@RequestMapping("/qnalist")
//	public String qnalist(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/qnalist()@@@");
//		
//		model.addAttribute("request", request);	
//		
//		//System.out.println("???????????????????????????????????? : "+session.getAttribute("loginid"));
//		
//		mickyServiceInter = new QnaListService(sqlSession,session);
//		mickyServiceInter.execute(model);	
//		return "/member/qnalist";		
//	}
//	
//	
//	//?????????????????? ??????????????????????????????
//	@RequestMapping("/qnawriteform")
//	public String qnawriteform(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/qnawriteform()@@@");
//		//model.addAttribute("request", request);	
//		//mickyServiceInter = new QnaWriteFormService(sqlSession,session);
//		//mickyServiceInter.execute(model);	
//		return "/member/qnawriteform";		
//	}
//	
//	
//	//?????????????????? ??????????????????????????????
//	@RequestMapping("/qnawrite")
//	public String qnawrite(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/qnawrite()@@@");
//		model.addAttribute("request", request);	
//
//		mickyServiceInter = new QnaWriteService(sqlSession,session);
//		mickyServiceInter.execute(model);	
//		return "redirect:/member/qnalist";		
//	}
//	
//	
//	//?????????????????? ????????? ?????????
//	@RequestMapping("/qnadetail")
//	public String qnadetail(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/qnadetail()@@@");
//		model.addAttribute("request", request);	
//			
//			
//		mickyServiceInter = new QnaDetailService(sqlSession,session);
//		mickyServiceInter.execute(model);	
//		return "/member/qnadetail";		
//	}
//	
//	
//	//?????????????????? ??????????????????
//	@RequestMapping("/qnareplyform")
//	public String qnareplyform(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/qnareplyform()@@@");
//		model.addAttribute("request", request);	
//			
//			
//		mickyServiceInter = new QnaDetailService(sqlSession,session);
//		mickyServiceInter.execute(model);	
//		return "/member/qnareplyform";		
//	}
//	
//	
//	//?????????????????? ????????????????????????
//	@RequestMapping("/qnareply")
//	public String qnareply(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/qnareply()@@@");
//		model.addAttribute("request", request);	
//			
//			
//		mickyServiceInter = new QnaReplyService(sqlSession,session);
//		mickyServiceInter.execute(model);	
//		return "redirect:/member/adminqnalist";		
//	}
//	
//	
	//?????????????????? ?????????????????????
	@RequestMapping("/infoupdateform")
	public String infoupdateform(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/infoupdateform()@@@");
		model.addAttribute("request", request);	
			
			
		mickyServiceInter = new InfoUpdateFormService(sqlSession,session);
		mickyServiceInter.execute(model);	
		return "/member/infoupdateform";		
	}
	
	
	//?????????????????? ???????????????
	@RequestMapping("/infoupdate")
	public String infoupdate(HttpServletRequest request,Model model,CryptoUtil crypt) {
		System.out.println("@@@MemberController/infoupdate()@@@");
		model.addAttribute("request", request);	
		model.addAttribute("crypt",crypt);
			
		mickyServiceInter = new InfoUpdateService(sqlSession,session);
		mickyServiceInter.execute(model);
//		mickyServiceInter = new MyPageService(sqlSession,session);
//		mickyServiceInter.execute(model);	
		return "/myPage/myPageIntro";		
	}
	
	
	//?????????????????????
	@RequestMapping(value="/emailoverlapcheck",method = RequestMethod.POST)
	@ResponseBody
	public int emailoverlapcheck(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/emailoverlapcheck()@@@");
		model.addAttribute("request", request);	
		
		
		mickyServiceInter = new EmailOverlapCheckService(sqlSession,session);
		mickyServiceInter.execute(model);
		
		Map<String, Object> map = model.asMap();
		int overlapcheck_result = (Integer) map.get("overlapcheck_result"); //ajax return?????? data ???????????? model??? ?????? ??????
		
//		String overlapcheck_result = request.getParameter("count");
		
		System.out.println("?????? : "+overlapcheck_result); //?????????
		
		return overlapcheck_result; //return ??? ?????? ajax success (data)??? ??????
	}
	
	
	//???????????????
	@RequestMapping(value="/emailcheck",method = RequestMethod.POST)
	@ResponseBody
	public String emailcheck(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/emailcheck()@@@");
		
		String email = request.getParameter("email");
		
		System.out.println("??????????????? ???????????? ????????? ?????? : "+email); //?????????
		
		Random random = new Random();
		int check_num = random.nextInt(888888) + 111111;
		System.out.println("???????????????????????? : "+check_num); //?????????
		
		// ????????? ????????? 
        String setFrom = "ssfhc594@gmail.com";
        String toMail = email;
        String title = "???????????? ?????? ????????? ?????????.";
        String content = 
                "??????????????? ?????????????????? ???????????????." +
                "<br><br>" + 
                "?????? ????????? " + check_num + "?????????." + 
                "<br>" + 
                "?????? ??????????????? ???????????? ???????????? ???????????? ?????????.";
        
        try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }

        String num = Integer.toString(check_num);
        return num;
	}
	
	
	//???????????????????????????????????????????????????
	@RequestMapping("/memberdropcheckform")
	public String memberdropcheckform(HttpServletRequest request, Model model) {
		System.out.println("@@@MemberController/memberdropcheckform()@@@");
		//mickyServiceInter = new MainService(sqlSession,session);
		//mickyServiceInter.execute(model);
				
		return "/member/memberdropcheckform";
	}
	
	
	//?????????????????????????????????????????????
	@RequestMapping(value="/memberdropcheck",method = RequestMethod.POST)
	@ResponseBody
	public int memberdropcheck(HttpServletRequest request, Model model,CryptoUtil crypt) {
		System.out.println("@@@MemberController/memberdropcheckform()@@@");
		model.addAttribute("request",request); 
		model.addAttribute("crypt",crypt);
		mickyServiceInter = new MemberDropCheckService(sqlSession,session);
		mickyServiceInter.execute(model);
		
		Map<String, Object> map = model.asMap();
		int memberdropcheck = (Integer) map.get("memberdropcheck");
		
//		String overlapcheck_result = request.getParameter("count");
		
		System.out.println("?????? : "+memberdropcheck);
		
		return memberdropcheck;
	}
	
	
	//??????????????????
	@RequestMapping("/memberdrop")
	public String memberdrop(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/memberdrop()@@@");
		model.addAttribute("request", request);
		mickyServiceInter = new MemberDropService(sqlSession,session);
		mickyServiceInter.execute(model);	
		mickyServiceInter=new ProductChartService(sqlSession,session);
		mickyServiceInter.execute(model);
		
		return "/product/productChart";		
	}
	
	
//	//?????????????????? ????????????????????????
//	@RequestMapping("/adminqnalist")
//	public String adminqnalist(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/adminqnalist()@@@");		
//		model.addAttribute("request", request);	
//			
//		mickyServiceInter = new AdminQnaListService(sqlSession,session);
//		mickyServiceInter.execute(model);	
//		return "/member/adminqnalist";		
//	}
//	
//	
//	//?????????????????? ??????????????? ?????????????????????
//	@RequestMapping(value="/qnadelete",method = RequestMethod.GET)
//	@ResponseBody
//	public String qnadelete(HttpServletRequest request,Model model) {
//		System.out.println("@@@MemberController/qnadelete()@@@");		
//		model.addAttribute("request", request);	
//			
//		mickyServiceInter = new QnaDeleteService(sqlSession,session);
//		mickyServiceInter.execute(model);	
//		return "/member/qnalist";		
//	}
	
	
	  //????????????????????????  
	  @RequestMapping("/findpwform")
	  public String findpwform(HttpServletRequest request, Model model) {
		  System.out.println("@@@MemberController/findpwform()@@@");
//		  mickyServiceInter = new MainService(sqlSession,session); 
//		  mickyServiceInter.execute(model);
	  
		  return "/member/findpwform"; 
	 }	  	  
		//????????????????????????
		@RequestMapping(value="/findpw",method = RequestMethod.POST)
		@ResponseBody
		public int findpw(HttpServletRequest request,Model model) {
			System.out.println("@@@MemberController/findpw()@@@");
			model.addAttribute("request", request);	
			
			
			mickyServiceInter = new FindPwService(sqlSession,session);
			mickyServiceInter.execute(model);
			
			Map<String, Object> map = model.asMap();
			int overlapcheck_result = (Integer) map.get("overlapcheck_result"); //ajax return?????? data ???????????? model??? ?????? ??????
			
			
			System.out.println("?????? : "+overlapcheck_result); //?????????
			
			return overlapcheck_result; //return ??? ?????? ajax success (data)??? ??????
		}				
	  //?????????????????? ??????????????????
	  @RequestMapping(value="/sendpwemail",method = RequestMethod.POST)
	  @ResponseBody
	  public String sendpwemail(HttpServletRequest request,Model model,CryptoUtil crypt) {
		  System.out.println("@@@MemberController/sendpwemail()@@@");
		  model.addAttribute("request", request);	
		  model.addAttribute("crypt",crypt);
		  String email = request.getParameter("email");
		
		  System.out.println("sendpwemail ????????? ?????? : "+email); //?????????
		
		
		  Random random = new Random();
		  String check_num = ""+random.nextInt(888888) + 111111;
		  model.addAttribute("check_num",check_num);
		
		  mickyServiceInter = new TemporaryPwService(sqlSession,session); 
		  mickyServiceInter.execute(model);
		  System.out.println("???????????????????????? : "+check_num); //?????????
		
		  // ????????? ????????? 
		  String setFrom = "ssfhc594@gmail.com";
		  String toMail = email;
		  String title = "?????????????????? ?????? ????????? ?????????.";
		  String content = 
				  		"??????????????? ?????????????????? ???????????????." +
						"<br><br>" + 
						"????????????????????? " + check_num + "?????????." + 
						"<br>" + 
						"?????? ????????? ????????? ??? ???????????? ???????????? ?????????.";
        
		  try {
            
			  MimeMessage message = mailSender.createMimeMessage();
			  MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			  helper.setFrom(setFrom);
			  helper.setTo(toMail);
			  helper.setSubject(title);
			  helper.setText(content,true);
			  mailSender.send(message);
            
		  }catch(Exception e) {
			  e.printStackTrace();
		  }

		  String num = check_num;
		  return num;
	  }	  	  
	  //?????????????????????  
	  @RequestMapping("/findidform")
	  public String findidform(HttpServletRequest request, Model model) {
		  System.out.println("@@@MemberController/findidform()@@@");
//		  mickyServiceInter = new MainService(sqlSession,session); 
//		  mickyServiceInter.execute(model);
	  
		  return "/member/findidform"; 
	 }	  	  
		//?????????????????????
		@RequestMapping(value="/findid",method = RequestMethod.POST)
		@ResponseBody
		public String findid(HttpServletRequest request,Model model) {
			System.out.println("@@@MemberController/findid()@@@");
			model.addAttribute("request", request);	
			
			
			mickyServiceInter = new FindIdService(sqlSession,session);
			mickyServiceInter.execute(model);
			
			Map<String, Object> map = model.asMap();
			String overlapcheck_result = (String) map.get("overlapcheck_result"); //ajax return?????? data ???????????? model??? ?????? ??????
			if(overlapcheck_result==null) {
				overlapcheck_result="";				
			}
			
			System.out.println("?????? : "+overlapcheck_result); //?????????
			
			return overlapcheck_result; //return ??? ?????? ajax success (data)??? ??????
		}				
		//??????????????????????????????????????????????????????
		@RequestMapping("/membercheckform")
		public String membercheckform(HttpServletRequest request, Model model) {
			System.out.println("@@@MemberController/membercheckform()@@@");
			//mickyServiceInter = new MainService(sqlSession,session);
			//mickyServiceInter.execute(model);
					
			return "/member/membercheckform";
		}
		@RequestMapping("/qnawriteformtest")
		public String qnawriteformtest(HttpServletRequest request, Model model) {
			System.out.println("@@@MemberController/qnawriteformtest()@@@");
			//mickyServiceInter = new MainService(sqlSession,session);
			//mickyServiceInter.execute(model);
					
			return "/qnamember/qnawriteformtest";
		}
}