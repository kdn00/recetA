package com.recetA.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.recetA.database.SqlSessionManager;
import com.recetA.domain.Ingredient;
public class IngredientDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	public List<Ingredient> selectRecipeingre(int b_code) {
		List<Ingredient> cnt = null;
		try {
			// (Mapper-insert태그의 ID, 매개변수)
			cnt = sqlSession.selectList("selectRecipedetail" , b_code);
			if (cnt != null) {
				// 성공 유무 확인하기
				System.out.println("레시피 재료 추출 성공");
				sqlSession.commit();
			} else {
				System.out.println("레시피 재료 추출 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return cnt;
	} // 상세 재료 출력 코드 끝

}
