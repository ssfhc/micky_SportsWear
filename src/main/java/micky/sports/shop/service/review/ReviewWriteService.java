package micky.sports.shop.service.review;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.ReviewDao;
import micky.sports.shop.service.MickyServiceInter;

public class ReviewWriteService implements MickyServiceInter{

	private SqlSession sqlSession;
	
	public ReviewWriteService(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		System.out.println(">>>>ReviewWriteService");
		
//		model에서 request를 풀어내는 방법
		Map<String, Object> map=model.asMap(); //model을 Map으로 변환
		HttpServletRequest request=
				(HttpServletRequest) map.get("request");
		
		String r_title=request.getParameter("r_title");
//		String r_title=request.getParameter("r_title"); //여기 파일첨부
		String r_content=request.getParameter("r_content");
		
		ReviewDao rdao=sqlSession.getMapper(ReviewDao.class);
		rdao.write(r_title,r_content);
		
	}

}
