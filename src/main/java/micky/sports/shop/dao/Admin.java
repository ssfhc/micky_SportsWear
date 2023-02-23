package micky.sports.shop.dao;
//인터페이스 : 추상메소드들의 집합 - AdminDao.java 참고
import java.util.ArrayList;

import micky.sports.shop.dto.MemberDto;
import micky.sports.shop.dto.OrderMemberDto;


public interface Admin {
	public ArrayList<OrderMemberDto> olist(int start,int end);//관리자 주문관리 현황 리스트
	public int selectAdminTotCount();//관리자 admin_olist 총 갯수(page)	
																								
	public ArrayList<OrderMemberDto> slist(String om_cancle,String som_cdate,String eom_cdate,String selNum);//주문취소 목록 검색 기능-시작날짜-종료날짜 & 취소요청 기준	
	
	public OrderMemberDto acontentview(String om_cntnum);//관리자 주문내역 상세(주문취소)
	
	public void acanclemodify(String om_cntnum,String om_state);//결제완료 → 주문취소 변경
	public void aorderconfirmmodify(String om_cntnum,String om_state);//결제완료 → 주문확정 변경
	public void adelmodify(String om_cntnum,String om_state);//결제완료 → 배송완료 변경
	public void arefundmodify(String om_cntnum,String om_state);//결제완료 → 반품완료 변경
	public void abuyconfirmmodify(String om_cntnum,String om_state);//결제완료 → 구매확정 변경
	
	public MemberDto sendcsms(String om_cntnum);//sms
	
}


