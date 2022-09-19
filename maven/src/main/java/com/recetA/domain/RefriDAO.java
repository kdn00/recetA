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
			System.out.println(refri);
			
			if (refri != null) {
				System.out.println("재료확인 성공");
				sqlSession.commit();
			} else {
				System.out.println("재료확인 실패");
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
	} //재료 수정 기능 끝
	
	
	// 재료 삭제 기능 구현
		public int Ingred_del (String s_name) {
			int cnt=0;
			try {
				cnt = sqlSession.delete("Ingred_del",s_name);
				if(cnt>0) {
					sqlSession.commit();
				}else {
					sqlSession.rollback();
				}
			} finally {
			sqlSession.close();
			}//finally 끝
			return cnt;
		} // 회원삭제 끝
}
