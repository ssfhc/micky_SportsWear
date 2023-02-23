package micky.sports.shop.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.Member;
import micky.sports.shop.service.MickyServiceInter;

public class MemberChartService implements MickyServiceInter{

	private SqlSession sqlSession;
	private HttpSession session;
	
	public MemberChartService(SqlSession sqlSession,HttpSession session) {
		this.sqlSession = sqlSession;
		this.session = session;
	}
	
	@Override
	public void execute(Model model) {
		System.out.println("MemberChartService");
		
		int totalMember = 0;
		int maleMember = 0;
		int femaleMember = 0;
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
			
		Member dao = sqlSession.getMapper(Member.class);
		
		totalMember = dao.getTotalMember();
		System.out.println("totalMember확인 : "+totalMember);
		
		maleMember = dao.getMaleMember();
		System.out.println("maleMember확인 : "+maleMember);
		
		femaleMember = dao.getFemaleMember();
		System.out.println("femaleMember확인 : "+femaleMember);
		
		model.addAttribute("totalMember",totalMember);
		model.addAttribute("maleMember",maleMember);
		model.addAttribute("femaleMember",femaleMember);
		

	}

}
