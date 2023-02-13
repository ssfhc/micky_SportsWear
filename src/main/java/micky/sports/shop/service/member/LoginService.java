package micky.sports.shop.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.Member;
import micky.sports.shop.dto.MemberDto;
import micky.sports.shop.service.MickyServiceInter;

public class LoginService implements MickyServiceInter{

	private SqlSession sqlSession;
	private HttpSession session;
	
	public LoginService(SqlSession sqlSession,HttpSession session) {
		this.sqlSession = sqlSession;
		this.session = session;
	}
	
	@Override
	public void execute(Model model) {
		System.out.println("LoginService@@@");
		
		int logincheck_result = -1; //로그인 확인결과
		//String loginid = ""; 
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String m_id = request.getParameter("m_id"); //loginform에서 입력받은 id값
		String m_pw = request.getParameter("m_pw"); //loginform에서 입력받은 password값
		
		Member dao = sqlSession.getMapper(Member.class);
		
		logincheck_result = dao.login(m_id, m_pw); //입력한id,password를 조건으로 회원정보에 select count(*) 후 결과(int)
		
		if(logincheck_result==1) {
			System.out.println("로그인완료");
//			MemberDto dto = dao.getimg(m_id);
//			model.addAttribute("dto",dto);
			session = request.getSession();
			session.setAttribute("loginid", m_id);
			System.out.println("세션등록아이디 확인 : "+session.getAttribute("loginid"));
			//model.addAttribute("loginid",loginform_inputid);
		}else if(logincheck_result==0) {
			System.out.println("로그인실패");
		}else {
			System.out.println("오류");
		}
		//loginid = (String)session.getAttribute("loginid");
		//model.addAttribute("loginid",loginid);
		model.addAttribute("logincheck_result",logincheck_result);
	}

}
