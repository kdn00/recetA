package com.recetA.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.recetA.database.SqlSessionManager;

public class RefriDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	

	// 키값 가져오기 기능 구현
		public int m_key_search(String m_id) {
			int r_key = 0;
			try {
				System.out.println(r_key);
				r_key = sqlSession.selectOne("m_key_search", m_id);
				System.out.println(r_key);
				
				if (r_key >0) {
					System.out.println("키값 가져오기 성공");
					sqlSession.commit();
				} else {
					System.out.println("키값 가져오기 실패");
					sqlSession.rollback();
				}
			} finally {
				sqlSession.close();
			} // finally 끝
			return r_key;
		} // 키값 가져오기 기능 끝
	
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
		} // 재료삭제 끝
		
		// 재료 검색 기능 구현
		public List<RefriMember> Ingred_search(String s_name) {
			List<RefriMember> Ingred_search = null;
			try {
				Ingred_search = sqlSession.selectList("Ingred_search", s_name);
				if(Ingred_search!=null) {
					sqlSession.commit();
				}else{
					sqlSession.rollback();
				}
			} finally {
				sqlSession.close();
			}//finally 끝
			return Ingred_search;
			
		}// 재료검색 끝
		
		
		// 재료 추가 기능 구현
		public int Ingred_plus(RefriMember member) {
			int cnt = 0, cnt2 = 0;
			try {
				cnt = sqlSession.insert("Ingred_plus", member);
				if (cnt > 0) {
					// 성공 유무 확인하기
					System.out.println("회원가입 dao 성공");
					sqlSession.commit();
				} else {
					System.out.println("회원가입 dao 실패");
					sqlSession.rollback();
				}
			} finally {
				sqlSession.close();
			} // finally 끝
			return cnt;
		} // 재료 추가 끝
		
}
