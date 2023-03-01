package micky.sports.shop.service.member;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import micky.sports.shop.crypt.CryptoUtil;
import micky.sports.shop.dao.Member;
import micky.sports.shop.service.MickyServiceInter;

public class JoinService implements MickyServiceInter{

	private SqlSession sqlSession;
	
	public JoinService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		System.out.println("JoinService@@@");
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		CryptoUtil crypt = (CryptoUtil) map.get("crypt");
		
		String attachPath="resources\\upload\\";
	    String uploadPath=request.getSession().getServletContext().getRealPath("/");
	    System.out.println("uploadpathhhhh:"+uploadPath);
	    String path = "C:\\2022spring\\springwork1\\micky_SportsWear\\src\\main\\webapp\\resources\\upload";
	    MultipartRequest req = null;
	    try {
	    	req=
	  	          new MultipartRequest(request, path, 1024*1024*20, "utf-8",
	  	                new DefaultFileRenamePolicy());
	    	System.out.println("req : "+req);
		} catch (Exception e) {
			// TODO: handle exception
		} 
	   
//		String checkid_YESorNO = request.getParameter("checkid_YESorNO");
//		String m_id = request.getParameter("m_id");
//		String m_pw = request.getParameter("m_pw");
//		String m_name = request.getParameter("m_name");
//		String m_tel = request.getParameter("m_tel");
//		String m_name2 = request.getParameter("m_name2");
//		String m_email = request.getParameter("m_email");
//		String m_grade = request.getParameter("m_grade");
//		int m_age = Integer.parseInt(request.getParameter("m_age"));
//		String m_gender = request.getParameter("m_gender");
//		int m_cash = Integer.parseInt(request.getParameter("m_cash"));
//		String m_filesrc = request.getParameter("m_filesrc");
	    
	    //String checkid_YESorNO = req.getParameter("checkid_YESorNO");
//	    String m_tel1 = req.getParameter("m_tel1");
//	    String m_tel2 = req.getParameter("m_tel2");
//	    String m_tel3 = req.getParameter("m_tel3");
	    
	    
	    
		String m_id = req.getParameter("m_id");
		//System.out.println(m_id); //확인용
		String m_pw = req.getParameter("m_pw");
		String key="";
		try {
			key=CryptoUtil.sha512(m_pw);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("sha512방식 암호화 : "+key);
		
		String key2=key;
		String encryStr = "";
		try {
			encryStr = CryptoUtil.encryptAES256(m_pw, key2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("양방향암호화 : "+encryStr);
		
		
		String m_name = req.getParameter("m_name"); 
		System.out.println("이름확인 : "+m_name);
		String m_tel = req.getParameter("m_tel");
		System.out.println("전화번호확인 : "+m_tel);
		String m_name2 = req.getParameter("m_name2");
		System.out.println("닉네임 확ㅇ니 : "+m_name2);
		
		
		/*
		 * String m_emaill = req.getParameter("m_email"); //이메일 앞주소 String m_email2 =
		 * req.getParameter("m_email2"); //이메일 뒷주소
		 */		
		String m_email = req.getParameter("m_email");
		System.out.println("이메일주소조합확인 : "+m_email);
		
		
		String m_grade = req.getParameter("m_grade");
		int m_age = Integer.parseInt(req.getParameter("m_age"));
		System.out.println("확인인인ㅇ니닝ㄴ잉니 :"+m_age);
		String m_gender = req.getParameter("m_gender");
		String m_filesrc = req.getFilesystemName("m_filesrc");
		System.out.println("확인좀하자@@@@@@@@@@@@@@@@@"+m_filesrc);
		
		
		
		if(m_filesrc==null) // 파일첨부안하면 null이라 오류떠서 null상황 배제를 위해 조건을 달아준다
			m_filesrc="";
		
		Member dao = sqlSession.getMapper(Member.class);
		
		dao.join(m_id,m_pw,m_name,m_tel,m_name2,m_email,m_grade,m_age,m_gender,m_filesrc,key,encryStr);			
	}

}
