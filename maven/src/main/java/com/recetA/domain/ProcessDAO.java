package com.recetA.domain;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.recetA.database.SqlSessionManager;
import com.recetA.domain.Process;
public class ProcessDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
	public List<Process> selectDetailRecipe(int b_code) {
		List<Process> cnt = null;
		try {
			
			cnt = sqlSession.selectList("selectRecipedetail2", b_code);

			if (cnt != null) {
				System.out.println("상세 레시피 공개 성공");
				sqlSession.commit();
			} else {
				System.out.println("상세 레시피 공개 실패");
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		} // finally 끝
		return cnt;
	} //상세 레시피 뿌리기 끝
	
}
