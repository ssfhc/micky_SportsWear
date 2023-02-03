package micky.sports.shop.dao;

import java.util.ArrayList;

import micky.sports.shop.dto.ReviewDto;

public interface ReviewDao {
	public ArrayList<ReviewDto> reviewboard();
//	public void write(String r_title,String r_content,String r_filesrc);
	public void write(String m_id,String r_title,String r_content,String r_filesrc);
	public void delete(String r_no);
	public ArrayList<ReviewDto> mylistview();
	public ReviewDto popupview(String r_no);
	public void modify(String r_no, String r_title, String r_content);

}
