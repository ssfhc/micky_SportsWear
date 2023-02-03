package micky.sports.shop.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.CartDao;
import micky.sports.shop.dto.CartDto;
import micky.sports.shop.dto.ProductDto;


public class MickyCartinsertservice implements MickyServiceInter{

	private SqlSession sqlSession;
	
	public MickyCartinsertservice(SqlSession sqlsession) {
		this.sqlSession=sqlsession;
	}

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map= model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String p_no=request.getParameter("p_no");
		
		CartDao dao=sqlSession.getMapper(CartDao.class);
		
//		ProductDto dto=dao.Detaillist(p_no);
		
		
		dao.insertCart(p_no);
		
		
//		model.addAttribute("list",list);	
	}
	
}
