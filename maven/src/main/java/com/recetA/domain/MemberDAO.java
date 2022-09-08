package com.recetA.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.recetA.database.SqlSessionManager;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	// 회원가입 기능 구현
	public int insertMember(Member member) {
		int cnt = 0;
		try {
			// (Mapper-insert태그의 ID, 매개변수)
			cnt = sqlSession.insert("insertMember", member);
			if (cnt > 0) {
				// 성공 유무 확인하기
				System.out.println("회원가입 성공");
				sqlSession.commit();
			} else {
				System.out.println("회원가입 실패");
				sqlSession.rollback();
			}

		} finally {
			sqlSession.close();
		} // finally 끝
		return cnt;
	} // 회원가입 끝

	
	// 로그인 기능 구현
	public Member selectMember(Member member) {
		Member loginMember = null;
		try {
			loginMember = sqlSession.selectOne("selectMember", member);

			if (loginMember != null) {
				System.out.println("로그인 성공");
				sqlSession.commit();
			} else {
				System.out.println("로그인 실패");
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
	public int deleteMember(String email) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("deleteMember", email);
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



}
