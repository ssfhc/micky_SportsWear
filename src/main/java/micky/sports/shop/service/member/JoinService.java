package micky.sports.shop.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.Member;
import micky.sports.shop.service.MickyServiceInter;

public class JoinService implements MickyServiceInter{

	private SqlSession sqlSession;
	
	public JoinService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		System.out.println("JoinService@@@");
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");
		String m_tel = request.getParameter("m_tel");
		String m_name2 = request.getParameter("m_name2");
		String m_email = request.getParameter("m_email");
		String m_grade = request.getParameter("m_grade");
		int m_age = Integer.parseInt(request.getParameter("m_age"));
		String m_gender = request.getParameter("m_gender");
		int m_cash = Integer.parseInt(request.getParameter("m_cash"));
		String m_filesrc = request.getParameter("m_filesrc");
		
		Member dao = sqlSession.getMapper(Member.class);
		
		dao.join(m_id,m_pw,m_name,m_tel,m_name2,m_email,m_grade,m_age,m_gender,m_cash,m_filesrc);
	}

}
