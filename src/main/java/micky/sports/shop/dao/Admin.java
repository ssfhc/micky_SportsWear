package micky.sports.shop.dao;
//인터페이스 : 추상메소드들의 집합 - AdminDao.java 참고
import java.util.ArrayList;


import micky.sports.shop.dto.OrderMemberDto;


public interface Admin {
	public ArrayList<OrderMemberDto> olist();//관리자 주문관리 현황 리스트
	public OrderMemberDto acontentview(String om_cntnum);//관리자 주문내역 상세(주문취소)
	public void amodify(String om_cntnum,String om_state);//결제완료 → 주문취소 변경
}
