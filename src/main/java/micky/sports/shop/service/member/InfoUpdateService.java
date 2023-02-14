package micky.sports.shop.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import micky.sports.shop.dao.Member;
import micky.sports.shop.dto.MemberDto;
import micky.sports.shop.service.MickyServiceInter;

public class InfoUpdateService implements MickyServiceInter{

	private SqlSession sqlSession;
	private HttpSession session;
	
	public InfoUpdateService(SqlSession sqlSession,HttpSession session) {
		this.sqlSession = sqlSession;
		this.session = session;
	}
	
	@Override
	public void execute(Model model) {
		System.out.println("InfoUpdateService");
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_tel = request.getParameter("m_tel");
		String m_name2 = request.getParameter("m_name2");
		
		String m_email = request.getParameter("m_email"); //이메일 앞주소
		//String m_email2 = request.getParameter("m_email2"); //이메일 뒷주소
		//String m_email = m_emaill+m_email2;
		
		//String m_filesrc = request.getParameter("m_filesrc");
		

		
		Member dao = sqlSession.getMapper(Member.class);
		
		dao.infoupdate(m_id,m_pw,m_tel,m_name2,m_email);

	}

}
