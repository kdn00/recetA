package com.smhrd.database;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	// SqlSessionFactory --> Connection같은 역할
	   // conn,close 자원소모가 심했음. mybatis 해결
	   // Connection 객체를 미리 만들어놓음(Connection Pool)
	   // 커넥션풀은 미리 만들어진 연결을 빌리고 반납하는 형태로 관리
	   
	   static SqlSessionFactory sqlSessionFactory;
	   
	   // static{} --> 객체를 호출할때 무조건 한번 실행되는 부분
	   static {
	            // DB 환경설정 파일 경로
	      try {
	         String resource = "com/smhrd/database/config.xml";
	         InputStream inputStream;
	         inputStream = Resources.getResourceAsStream(resource);
	         sqlSessionFactory =
	               new SqlSessionFactoryBuilder().build(inputStream);
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	   }//static 끝
	   
	   // DAO에서 SqlSessionFactory 사용하기 위해서 메소드를 생성
	   public static SqlSessionFactory getSqlSession() {
	      return sqlSessionFactory;
	   }
}
