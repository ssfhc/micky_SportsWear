package micky.sports.shop.dao;

import java.util.ArrayList;

import micky.sports.shop.dto.ProductDto;

public interface ProductDao {

	//상품목록
	public ArrayList<ProductDto> productlist();
	
	//productdetail
	public ArrayList<ProductDto> productMain(String pname);
	public ArrayList<ProductDto> product(String pname,String pfilesrc);
	
	//수량이나 캐시가 없으면 결제가 진행되지 않도록하기
	public ProductDto checkPrdCnt(String pno);
	
	//구매한 수량 재고 삭제
	public int delpayment(String pno,int cnt);

	//상품목록 차트
	public ArrayList<ProductDto> productChart();
	
	//상품목록 차트
	public ArrayList<ProductDto> pdtTimeChart(String simpleTime);

}
