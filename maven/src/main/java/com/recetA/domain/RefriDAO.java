package com.recetA.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.recetA.database.SqlSessionManager;

public class RefriDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	

	// 보유재료 기능 구현
	public List<RefriMember> refri(RefriMember vo) {
		List<RefriMember> refri = null;
		try {
			refri = sqlSession.selectList("refri_search", vo);

			if (refri != null) {
				System.out.println("로그인 성공");
				sqlSession.commit();
			} else {
				System.out.println("로그인 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return refri;
	} // 보유재료 기능 끝
	
	// 재료 개수 수정 기능 구현
	public int ingred_update(RefriMember member) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("ingred_update", member);
			if (cnt > 0) {
				System.out.println("개수 수정 성공");
				sqlSession.commit();

			} else {
				System.out.println("개수 수정 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return cnt;
	} //재재료 수정 기능 끝
}
