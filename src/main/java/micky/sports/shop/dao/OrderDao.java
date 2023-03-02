package micky.sports.shop.dao;

import java.util.ArrayList;

import micky.sports.shop.dto.MemberDto;
import micky.sports.shop.dto.OrderMemberDto;
import micky.sports.shop.dto.ProductDto;

public interface OrderDao {
	public int payment(String mId,String pNo,int cCnt);
	
	//주문페이지 정보보기
	public ProductDto orderSelect(String pno);

	//나의 주문내역에서 주문목록 확인
	public ArrayList<OrderMemberDto> mtOrderList(String mIdd,int rowStart,int rowEnd);
	
	//주문페이지에서 회원 정보확인
	public MemberDto ordersMember(String loginId);
	
	//구매한 금액 회원 캐시 차감
	public void delcash(String mId,int totPrices);
	
	//주문성공시 주문번호
	public String checkOmnum(String mId);

	//나의주문내역보기 페이징 접속한 회원아이디의 전체내역수
	public int selectBoardTotCount(String mId);
	
	//나의주문내역에서 취소요청 클릭시 화면전환
	public OrderMemberDto myOrderCancelOffer(String omnum);
	
	//취소사유 적은후 취소요청하기 
	public void myOCancelOffersubmit(String calcleOfferomcntnum,String myOrderCancelReason);
	
	//배송관련 최근주문번호확인*변경전
	public OrderMemberDto checkOmCntnum(String mId);
	//배송*변경전
	public void deliverys(String omCntnum,String mId,String receipt_name,String receipt_phone,String addr1,String addr2,String addr3);

	//배송관련 최근주문번호확인*변경후
	public ArrayList<OrderMemberDto> checkOms(String mId);
	//배송*변경후
	public void delivery(String omNum,String mId,String receipt_name,String receipt_phone,String addr1,String addr2,String addr3,String omCntnum);
	
	//구매확정
	public void myOrderConfirm(String omnum);
	//반품요청
	public void myDelivCancelOffer(String omnum);
	
	//마이페이지 인트로
	public ArrayList<OrderMemberDto> myPage(String mId);
}
