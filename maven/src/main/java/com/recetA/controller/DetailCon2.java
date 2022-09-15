package com.recetA.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.ProcessDAO;

public class DetailCon2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("detailed recipe ready.");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String b_code = (String)session.getAttribute("b_code");
		
		ProcessDAO dao = new ProcessDAO();
		int cnt = dao.selectDetailRecipe(b_code);
		if (cnt > 0) {
			session.setAttribute("b_code", b_code);
			response.sendRedirect("detail.jsp");
		} else {
			
			response.sendRedirect("main.jsp");
		}
		
	}
}
