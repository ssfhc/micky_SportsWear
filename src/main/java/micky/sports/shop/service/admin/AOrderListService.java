package micky.sports.shop.service.admin;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import micky.sports.shop.dao.Admin;
import micky.sports.shop.dto.OrderMemberDto;
import micky.sports.shop.service.MickyServiceInter;
import micky.sports.shop.vopage.SearchVO;

//관리자 주문관리 현황 리스트
@Service
public class AOrderListService implements MickyServiceInter{
	private SqlSession sqlSession;
	
	public AOrderListService(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		System.out.println("---AOrderListService");
		
		//model → map
		Map<String , Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("reqest");
		SearchVO searchVO=
				(SearchVO)map.get("searchVO");
		
		//DB select
		Admin dao=sqlSession.getMapper(Admin.class);
		ArrayList<OrderMemberDto> olist=dao.olist();
		model.addAttribute("olist",olist);
		
		
		// 주문취소 목록 검색 기능-시작날짜~종료날짜+취소요청Y 기준
		
		
		
	}
}
