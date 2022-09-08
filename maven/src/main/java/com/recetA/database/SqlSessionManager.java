package com.recetA.database;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	// SqlSessionFactory --> Connection같은 역할을 수행함
	// conn, close는 자원소모가 심해서 이를 mybatis로 해결하고자 함
	// Connection 객체를 미리 만들어 놓음(Connection Pool)
	// 커넥션 풀은 미리 만들어진 연결을 빌리고 반납하는 형태로 관리

	static SqlSessionFactory sqlSessionFactory;

	// static{} --> 객체를 호출할 때 무조건 한 번 실행되는 부분
	static {
		try {
			// resource 할 때는 /로 경로를 쓴다.
			// DB 환경설정 파일 경로를 입력
			String resource = "com/recetA/database/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // static 끝

	// DAO에서 SqlSessionFactory를 사용하기 위해서 메소드를 생성
	public static SqlSessionFactory getSqlSession() {

		return sqlSessionFactory;

	}

}
