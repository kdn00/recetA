package com.recetA.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.recetA.database.SqlSessionManager;

public class BasicDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();

	// 랜덤 레시피
	public Basic selectRandom(int b_code) {
		Basic randombasic = null;
		try {
			randombasic = sqlSession.selectOne("selectRecipe", b_code);
			if (randombasic != null) {
				System.out.println("랜덤 레시피 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("랜덤 레시피 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return randombasic;
	} // 랜덤 레시피 끝

	// 대분류 처리 기능
	public List<Basic> selectbCtype(String b_ctype) {
		List<Basic> bigbasic = null;
		try {
			bigbasic = sqlSession.selectList("selectbCtype", b_ctype);
			if (bigbasic != null) {
				System.out.println("대분류 레시피 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("대분류 레시피 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return bigbasic;
	} // 대분류 끝

	// 소분류 처리 기능
	// 5개 함수 다 만들래...
	// 음식 분류 기능
	public List<Basic> selectbFtype(Basic b_ftype) {
		List<Basic> smallbasic = null;
		try {
			smallbasic = sqlSession.selectList("selectbFtype", b_ftype);
			if (smallbasic != null) {
				System.out.println("음식 분류 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("음식 분류 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return smallbasic;
	} // 음식 분류 끝

	// 재료 분류 기능
	public List<Basic> selectbItype(Basicitype b_itype) {
		List<Basic> smallbasic = null;
		try {
			smallbasic = sqlSession.selectList("selectbItype", b_itype);
			if (smallbasic != null) {
				System.out.println("재료 분류 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("재료 분류 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return smallbasic;
	} // 재료 분류 끝

	// 조리 시간 기능
	public List<Basic> selectbTime(Basictime b_time) {
		List<Basic> smallbasic = null;
		try {
			smallbasic = sqlSession.selectList("selectbTime", b_time);
			if (smallbasic != null) {
				System.out.println("조리 시간 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("조리 시간 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return smallbasic;
	} // 조리 시간 끝

	// n인분 기능
	public List<Basic> selectbAmount(Basicamount b_amount) {
		List<Basic> smallbasic = null;
		try {
			smallbasic = sqlSession.selectList("selectbAmount", b_amount);
			if (smallbasic != null) {
				System.out.println("n인분 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("n인분 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return smallbasic;
	} // n인분 끝

	// 난이도 기능
	public List<Basic> selectbDifficulte(Basicdifficulte b_difficulte) {
		List<Basic> smallbasic = null;
		try {
			smallbasic = sqlSession.selectList("selectbDifficulte", b_difficulte);
			if (smallbasic != null) {
				System.out.println("난이도 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("난이도 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return smallbasic;
	} // 난이도 끝

	// 상세 페이지 레시피 이름 출력
	public List<Basic> selectbName(int b_code) {
		List<Basic> b_name = null;
		try {
			b_name = sqlSession.selectList("selectbName", b_code);
			if (b_name != null) {
				System.out.println("상세 레시피 이름 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("상세 레시피 이름 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return b_name;
	} // 상세 페이지에 레시피 이름 출력 끝

	// 검색 처리 기능
	public List<Basic> selectsearch(String search) {
		List<Basic> searchresult = null;
		try {
			searchresult = sqlSession.selectList("selectsearch", search);
			if (searchresult != null) {
				System.out.println("검색 dao 성공");
				System.out.println(searchresult.get(0).getB_name());
				sqlSession.commit();
			} else {
				System.out.println("검색 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return searchresult;
	} // 검색 끝
	
	// 페이징 기능
	// 검색 카운트
	public int pagingsearch(String search) {
		int pagesearch = 0;
		try {
			pagesearch = sqlSession.selectOne("pagingsearch", search);
			if (pagesearch != 0) {
				System.out.println("검색 카운트 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("검색 카운트 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return pagesearch;
	} // 검색 카운트 끝	
	
	
	// 대분류 카운트
	public int pagingbCtype(String b_ctype) {
		int pagebCtype = 0;
		try {
			pagebCtype = sqlSession.selectOne("pagingbCtype", b_ctype);
			if (pagebCtype != 0) {
				System.out.println("대분류 카운트 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("대분류 카운트 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return pagebCtype;
	} // 대분류 카운트 끝
	
	
	// 소분류 카운트(5개)
	// 1. 음식 분류 카운트
	public int pagingbFtype(Basic b_ftype) {
		int pagebFtype = 0;
		try {
			pagebFtype = sqlSession.selectOne("pagingbFtype", b_ftype);
			if (pagebFtype != 0) {
				System.out.println("음식 분류 카운트 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("음식 분류 카운트 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return pagebFtype;
	} // 음식 분류 카운트 끝
	
	
	// 2. 재료 분류 카운트
	public int pagingbItype(Basicitype b_itype) {
		int pagebItype = 0;
		try {
			pagebItype = sqlSession.selectOne("pagingbItype", b_itype);
			if (pagebItype != 0) {
				System.out.println("재료 분류 카운트 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("재료 분류 카운트 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return pagebItype;
	} // 재료 분류 카운트 끝	
	
	// 3. 조리 시간 카운트
	public int pagingbTime(Basictime b_time) {
		int pagebtime = 0;
		try {
			pagebtime = sqlSession.selectOne("pagingbTime", b_time);
			if (pagebtime != 0) {
				System.out.println("조리 시간 카운트 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("조리 시간 카운트 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return pagebtime;
	} // 조리 시간 카운트 끝
	
	// 4. n인분 카운트
	public int pagingbAmount(Basicamount b_amount) {
		int pagebamount = 0;
		try {
			pagebamount = sqlSession.selectOne("pagingbAmount", b_amount);
			if (pagebamount != 0) {
				System.out.println("n인분 카운트 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("n인분 카운트 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return pagebamount;
	} // n인분 카운트 끝	
	
	// 5. 난이도 카운트
	public int pagingbbDifficulte(Basicdifficulte b_difficulte) {
		int pagebdifficulte = 0;
		try {
			pagebdifficulte = sqlSession.selectOne("pagingbbDifficulte", b_difficulte);
			if (pagebdifficulte != 0) {
				System.out.println("난이도 카운트 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("난이도 카운트 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return pagebdifficulte;
	} // 난이도 카운트 끝	

}
