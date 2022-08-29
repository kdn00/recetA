package com.smhrd.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class TestDAO {

	// SqlSessionFactory 사용하기 위해 메소드 호출
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();

	// 회원가입 기능 메소드 만들기
	public int insertTest(Test test) {
		// Mapper.xml 작성될 SQL문의 ID지정해주기
		int cnt = 0;
		try {

			cnt = sqlSession.insert("insertTest", test);
			if (cnt > 0) {
				System.out.println("회원가입 성공");
				sqlSession.commit();
			} else {
				// System.out.println("회원가입 실패");
				sqlSession.rollback();
			} // cnt 판단 끝
		} finally {
			sqlSession.close();
		}
		return cnt;
	} // 회원가입 기능 끝

	// 로그인 기능 구현 만들기
	public Test selectTest(Test test) {
		Test m_test = null;
		try {
			m_test = sqlSession.selectOne("selectTest", test);
			if (m_test != null) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}
		return m_test;
	}
}
