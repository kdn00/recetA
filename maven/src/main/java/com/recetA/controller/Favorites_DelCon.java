package com.recetA.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.FavoritesDAO;
import com.recetA.domain.FavoritesMember;
import com.recetA.domain.Member;
import com.recetA.domain.RefriDAO;

public class Favorites_DelCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("즐찾삭제왔어요");

		Member loginMember = (Member) session.getAttribute("loginMember");
		int m_key = loginMember.getM_key();
		System.out.println(m_key);

		FavoritesMember Favorites_Data = (FavoritesMember) session.getAttribute("Favorites_Data");
		String b_name = Favorites_Data.getB_name();
		System.out.println(b_name);

		FavoritesMember vo = new FavoritesMember(m_key, b_name);

		// 2. MemberMapper.xml에서 SQL문 만들기

		// 3. MemberDAO에서 회원삭제 메소드 만들기

		// 4. 메소드 호출(email값 매개변수로 넣어주기)
		FavoritesDAO dao = new FavoritesDAO();
		int cnt = dao.Favorites_del(vo);

		// 5. 성공 여부에 따른 명령 후 처리
		if (cnt > 0) {
			System.out.println("즐겨찾기 삭제 성공");
		} else {
			System.out.println("즐겨찾기 삭제 실패");
		}
		// 6. select.jsp로 이동
		response.sendRedirect("RecipedetailpageCon2");

	}

}
