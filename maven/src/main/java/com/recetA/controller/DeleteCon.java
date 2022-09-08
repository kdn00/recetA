package com.recetA.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recetA.domain.MemberDAO;

public class DeleteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("[DeleteCon]");
		// 0. 한글 인코딩
		request.setCharacterEncoding("UTF-8");

		// 1. 데이터 가져오기(파라미터 수집)
		// DeleteCon?email=이메일값... 쿼리스트링으로 데이터 전송된 것을
		// name값
		String m_id = request.getParameter("id");

		// 2. MemberMapper.xml에서 SQL문 만들기

		// 3. MemberDAO에서 회원삭제 메소드 만들기 - sqlSession.delete()

		// 4. 메소드 호출(email값 매개변수로 넣어주기)
		MemberDAO dao = new MemberDAO();
		int cnt = dao.deleteMember(m_id);

		// 5. 메소드 호출 성공 여부에 따른 명령 후 처리
		if (cnt > 0) {
			System.out.println("회원 삭제 성공!");
		} else {
			System.out.println("회원 삭제 실패!");
		}

		// 6. 회원 정보가 사라져서 마이페이지 사용x index.html로 이동
		response.sendRedirect("index.html");
	}

}
