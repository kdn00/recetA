package com.recetA.domain;

import java.util.ArrayList;

public class BasicDAO {
	
	// 대분류 선택x일 때랑 랜덤일 때 처리 기능??
	public ArrayList<Basic> selectRandom(){
		ArrayList<Basic> randombasic = null;
		
		return randombasic;
	}
	
	// 대분류 처리 기능 --> 다시 쓰세요 b_ctype 넣어야함
	public ArrayList<Basic> selectbCtype(String b_ctype) {
		ArrayList<Basic> bigbasic = null;
		
		return bigbasic;
	}
	
	// 소분류 처리 기능
	public ArrayList<Basic> selectSmall(Basic basic) {
		ArrayList<Basic> smallbasic = null;
		
		return smallbasic;
	}
	
	// 상세 페이지 레시피 이름 출력
	public String selectbName(int b_code) {
		String b_name = null;
		
		return b_name;
	}

}
