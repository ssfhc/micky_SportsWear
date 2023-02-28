package micky.sports.shop.service.product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.ProductDao;
import micky.sports.shop.service.MickyServiceInter;

public class ProductChartService implements MickyServiceInter{
	private SqlSession sqlSession;
	private HttpSession httpsession;
	
	public ProductChartService(SqlSession sqlSession,HttpSession httpsession) {
		this.sqlSession=sqlSession;
		this.httpsession = httpsession;
	}
		@Override
	public void execute(Model model) {
		
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");	

		//로그인 세션
		httpsession = request.getSession();
		String loginId = (String)httpsession.getAttribute("loginid");
	
		
		ProductDao Pdao=sqlSession.getMapper(ProductDao.class);
		model.addAttribute("productChart",Pdao.productChart());
		
		//시간별
		Date today=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
		String simpleTime = simpleDateFormat.format(today);
		
		model.addAttribute("pdtTimeChart", Pdao.pdtTimeChart(simpleTime));
		
	}

}
