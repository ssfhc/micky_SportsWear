package micky.sports.shop.service.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.Admin;
import micky.sports.shop.service.MickyServiceInter;

//관리자 주문내역 상세 : 결제완료 → 반품완료 변경(Update)
public class ARefundCompleteModifyService implements MickyServiceInter{
	
	private SqlSession sqlSession;
	public ARefundCompleteModifyService(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		System.out.println("--ARefundCompleteModifyService");
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");
		
		String om_cntnum=request.getParameter("om_cntnum");
		String om_state=request.getParameter("om_state");
		
		Admin dao=sqlSession.getMapper(Admin.class);
		dao.arefundmodify(om_cntnum, om_state);
		
//		System.out.println(om_cntnum);
//		System.out.println(om_state);
		
	}
}
