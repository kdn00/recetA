package com.recetA.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.FavoritesDAO;
import com.recetA.domain.FavoritesMember;

import oracle.net.ns.SessionAtts;

public class Favorites_DataCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String b_name = request.getParameter("b_name");
		System.out.println("즐찾들어왔어요");
		System.out.println(b_name);
		
		FavoritesDAO dao = new FavoritesDAO();
		FavoritesMember cnt = dao.Favorites_Data(b_name);
		
		if(cnt !=null) {
			System.out.println("찾아오기 성공");
			session.setAttribute("Favorites_Data", cnt);

		}else {
			System.out.println("찾아오기 실패");
		}
		response.sendRedirect("Favorites_CheckCon");

	
	}

}
