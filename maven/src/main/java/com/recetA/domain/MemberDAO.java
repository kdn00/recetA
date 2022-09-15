package com.recetA.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.recetA.database.SqlSessionManager;
import com.recetA.domain.Member;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	// 회원가입 기능 구현
	public int insertMember(Member member) {
		int cnt = 0, cnt2 = 0;
		try {
			// (Mapper-insert태그의 ID, 매개변수)
			cnt = sqlSession.insert("insertMember", member);
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
	} // 회원가입 끝
	
	// 냉장고 키 생성을 위해 m_key select
	public Member insertMember2(String member) {
		Member insertMember = null;
		try {
			insertMember = sqlSession.selectOne("insertMember2", member);

			if (insertMember != null) {
				System.out.println("키 검색 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("키 검색 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return insertMember;
	} // 로그인 끝
	
	// 회원가입 때 냉장고 키 추가 기능 구현
	public int insertMember3(int key) {
		int cnt = 0;
		try {
			// (Mapper-insert태그의 ID, 매개변수)
			cnt = sqlSession.insert("insertMember3", key);
			if (cnt > 0) {
				// 성공 유무 확인하기
				System.out.println("냉장고 키 생성 dao 성공");
				sqlSession.commit();
			} else {
				System.out.println("냉장고 키 생성 dao 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return cnt;
	} // 냉장고 키 추가 기능 구현 끝
	
	// 로그인 기능 구현
	public Member selectMember(Member member) {
		Member loginMember = null;
		try {
			loginMember = sqlSession.selectOne("selectMember", member);

			if (loginMember != null) {
				System.out.println("dao 로그인 성공");
				sqlSession.commit();
			} else {
				System.out.println("dao 로그인 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return loginMember;
	} // 로그인 끝
	

	// 회원수정 기능 구현
	public int updateMember(Member member) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("updateMember", member);
			if (cnt > 0) {
				System.out.println("회원 정보 수정 성공");
				sqlSession.commit();

			} else {
				System.out.println("회원 정보 수정 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return cnt;
	} // 회원수정 끝

	

	// 회원 탈퇴
	//나만의 냉장고 삭제 시작
	public int deleteMember1(String m_key) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("deleteMember1", m_key);
			if (cnt > 0) {
				System.out.println("회원 탈퇴 성공");
				sqlSession.commit();

			} else {
				System.out.println("회원 탈퇴 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return cnt;
	} // 삭제 끝
	public int deleteFridge1(String k_key) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("deleteFridge1", k_key);
			if (cnt > 0) {
				System.out.println("회원 탈퇴 성공");
				sqlSession.commit();
				
			} else {
				System.out.println("회원 탈퇴 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return cnt;
	} // 삭제 끝
	public int deleteMember(String m_key) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("deleteMember", m_key);
			if (cnt > 0) {
				System.out.println("회원 탈퇴 성공");
				sqlSession.commit();

			} else {
				System.out.println("회원 탈퇴 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return cnt;
	} // 회원 탈퇴 끝
	
	public int deleteFridge(String m_key) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("deleteFridge", m_key);
			if (cnt > 0) {
				System.out.println("회원 탈퇴 성공");
				sqlSession.commit();

			} else {
				System.out.println("회원 탈퇴 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return cnt;
	} // 삭제 끝
	
}



