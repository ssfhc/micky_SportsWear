package micky.sports.shop.service.order;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.OrderDao;
import micky.sports.shop.dto.OrderMemberDto;
import micky.sports.shop.service.MickyServiceInter;
import micky.sports.shop.vopage.SearchVO;

public class MyOrderListService implements MickyServiceInter {
	private SqlSession sqlSession;
	private HttpSession httpsession;
	private SearchVO searchVO;
	public MyOrderListService(SqlSession sqlSession,SearchVO searchVO,HttpSession httpsession) {
		this.sqlSession=sqlSession;
		this.httpsession=httpsession;
		this.searchVO=searchVO;
	}
	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");	
		
		//로그인 세션
		httpsession = request.getSession();
		String loginId = (String)httpsession.getAttribute("loginid");
		
		if(loginId!=null) {
			OrderDao odao=sqlSession.getMapper(OrderDao.class);
			
			//페이징
			String strPage=request.getParameter("page");
			if(strPage==null) {
				strPage="1";
			}

			int page=Integer.parseInt(strPage);
			searchVO.setPage(page);
			int total=odao.selectBoardTotCount(loginId);	
			searchVO.pageCalculate(total);

			int rowStart=searchVO.getRowStart();
			int rowEnd=searchVO.getRowEnd();
			
			ArrayList<OrderMemberDto> omdList=odao.mtOrderList(loginId,rowStart,rowEnd);
	
			model.addAttribute("omdList",omdList);
			model.addAttribute("totRowcnt",total);
			model.addAttribute("searchVO",searchVO);
			
			//나의주문내역에서 정보확인
			model.addAttribute("myList",odao.ordersMember(loginId));
		}
	}

}
