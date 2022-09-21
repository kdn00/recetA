package com.recetA.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.recetA.database.SqlSessionManager;

public class PagingDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	// 검색 처리 기능
	public List<Basic> pagingsearch(SearchVO search) {
		List<Basic> searchresult = null;
		try {
			searchresult = sqlSession.selectList("pagingsearch", search);
			if (searchresult != null) {
				System.out.println("검색 페이징 dao 성공");
				System.out.println(searchresult.get(0).getB_name());
				sqlSession.commit();
			} else {
				System.out.println("검색 페이징 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return searchresult;
	} // 검색 끝
	
	// 대분류 페이징
	public List<Basic> pagingbCtype(Basic pageinfo) {
		List<Basic> getpage = null;
		try {
			getpage = sqlSession.selectList("pagingbCtype", pageinfo);
			System.out.println(getpage);
			if (getpage != null) {
				System.out.println("대분류 페이징 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("대분류 페이징 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}// finally 끝
		return getpage;
	}// 대분류 페이징 끝
	
	// 소분류 페이징
	// 음식 분류
	public List<Basic> pagingbFtype(Basic pageinfo) {
		List<Basic> getpage = null;
		try {
			getpage = sqlSession.selectList("pagingbFtype", pageinfo);
			System.out.println(getpage);
			if (getpage != null) {
				System.out.println("음식 분류 페이징 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("음식 분류 페이징 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}// finally 끝
		return getpage;
	}// 음식 분류 끝
	
	// 재료 분류
	public List<Basic> pagingbItype(Basicitype pageinfo) {
		List<Basic> getpage = null;
		try {
			getpage = sqlSession.selectList("pagingbItype", pageinfo);
			System.out.println(getpage);
			if (getpage != null) {
				System.out.println("재료 분류 페이징 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("재료 분류 페이징 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}// finally 끝
		return getpage;
	}// 재료 분류 끝
	
	// 조리 시간
	public List<Basic> pagingbTime(Basictime pageinfo) {
		List<Basic> getpage = null;
		try {
			getpage = sqlSession.selectList("pagingbTime", pageinfo);
			System.out.println(getpage);
			if (getpage != null) {
				System.out.println("조리 시간 페이징 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("조리 시간 페이징 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}// finally 끝
		return getpage;
	}// 조리 시간 끝
	
	// n인분
	public List<Basic> pagingbAmount(Basicamount pageinfo) {
		List<Basic> getpage = null;
		try {
			getpage = sqlSession.selectList("pagingbAmount", pageinfo);
			System.out.println(getpage);
			if (getpage != null) {
				System.out.println("n인분 페이징 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("n인분 페이징 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}// finally 끝
		return getpage;
	}// n인분 끝
	
	// 난이도
	public List<Basic> pagingbDifficulte(Basicdifficulte pageinfo) {
		List<Basic> getpage = null;
		try {
			getpage = sqlSession.selectList("pagingbDifficulte", pageinfo);
			System.out.println(getpage);
			if (getpage != null) {
				System.out.println("난이도 페이징 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("난이도 페이징 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}// finally 끝
		return getpage;
	}// 난이도 끝
	
}
