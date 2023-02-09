package micky.sports.shop.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.CartDao;


public class MickyCartDelete implements MickyServiceInter{

	private SqlSession sqlSession;
	
	public MickyCartDelete(SqlSession sqlsession) {
		this.sqlSession=sqlsession;
	}

	@Override
	public void execute(Model model) {
				
		Map<String, Object> map= model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String c_no=request.getParameter("c_no");
		CartDao dao=sqlSession.getMapper(CartDao.class);
		
		dao.Deletelist(c_no);
		System.out.println("삭제완료 번호 : "+c_no);
//		model.addAttribute("list",list);	
	}
	
}
