package com.recetA.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.recetA.database.SqlSessionManager;

public class FavoritesDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();

	// 즐겨찾기 추가 기능 구현
	public int Favorites_insert(FavoritesMember member) {
		int cnt = 0;
		try {
			cnt = sqlSession.insert("Favorites_insert", member);
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
	} // 즐겨찾기 추가 끝

	// 즐겨찾기 기능 구현
	public List<FavoritesMember> FavoritesMember(int m_key) {
		List<FavoritesMember> Favorites_search = null;
		try {
			Favorites_search = sqlSession.selectList("Favorites_search", m_key);
			System.out.println(Favorites_search);

			if (Favorites_search != null) {
				System.out.println("재료확인 성공");
				sqlSession.commit();
			} else {
				System.out.println("재료확인 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return Favorites_search;
	} // 즐겨찾기 기능 끝

	// 즐겨찾기 code url찾기 기능 구현
	public FavoritesMember Favorites_Data(String b_name) {
		FavoritesMember Favorites_search = null;
		try {
			Favorites_search = sqlSession.selectOne("Favorites_Data", b_name);
			System.out.println(Favorites_search);

			if (Favorites_search != null) {
				System.out.println("재료확인 성공");
				sqlSession.commit();
			} else {
				System.out.println("재료확인 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return Favorites_search;
	} // 기능 끝
	
	// 즐겨찾기 k_key, b_name찾기 기능 구현

	public FavoritesMember Favorites_Check(FavoritesMember vo) {
		FavoritesMember Favorites_Check = null;
		try {
			Favorites_Check = sqlSession.selectOne("Favorites_Check", vo);
			System.out.println(Favorites_Check);

			if (Favorites_Check != null) {
				System.out.println("즐겨찾기 있음");
				sqlSession.commit();
			} else {
				System.out.println("즐겨찾기 없음");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return Favorites_Check;
	} // 기능 끝

	// 즐겨찾기 삭제 기능 구현
			public int Favorites_del (FavoritesMember vo) {
				int cnt=0;
				try {
					cnt = sqlSession.delete("Favorites_del",vo);
					if(cnt>0) {
						sqlSession.commit();
					}else {
						sqlSession.rollback();
					}
				} finally {
				sqlSession.close();
				}//finally 끝
				return cnt;
			} // 즐겨찾기 삭제 끝
	
	
}
